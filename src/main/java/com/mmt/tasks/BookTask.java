package com.mmt.tasks;

import com.mmt.dao.BookDao;
import com.mmt.model.Book;
import com.mmt.model.Payment;
import com.mmt.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Component
@Transactional
public class BookTask {

    @Autowired
    private BookDao bookDao;
    /**
     * 订单任务， 每日1点处理任务
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void task() {
        //查询所有待还订单，处理订单信息
        List<Book> bookList = bookDao.queryBookWithPaid();
        for (Book book : bookList) {
            try {
                //查询该订单的费用信息
                String repayDateStr = book.getRepaydate();
                if(StringUtils.isEmpty(repayDateStr)) {
                    //如果待还日为空， 那么说明该订单出现问题，加入错误信息中
                    String errmsg = "该订单待还日为空，此订单状态为待还状态，待还日不可为空";
                    bookDao.insertErrBookMsg(book.getBook_no(), errmsg);
                }else{
                    Date repayDate = PublicUtil.strDateToDate(repayDateStr, "yyyy-MM-dd");
                    //查看当前日期是否大于待还日期， 如果大于，说明该订单已经逾期，便产生逾期费用了
                    int diffDay = PublicUtil.diffDayByDayDate(repayDate);
                    System.out.println(diffDay);
                    if(diffDay > 0 && diffDay < 3) {
                        //计算逾期费，
                        String product_price = book.getProduct_price();  //商品总价
                        BigDecimal bigDecimal = new BigDecimal(product_price);
                        //计算历史总逾期费用
                        if(StringUtils.isEmpty(book.getSyncdate())) { //如果该订单尚未同步，说明历史逾期费用就是当前逾期费用
                            book.setSyncdate(PublicUtil.getDate("yyyy-MM-dd"));
                            //每日逾期费用为 4%； （总价 * 逾期费4% * 逾期天数）
                            BigDecimal expectFee = bigDecimal.multiply(new BigDecimal(0.04)).multiply(new BigDecimal(diffDay)).setScale(2, BigDecimal.ROUND_HALF_DOWN); //默认采用四舍五入
                            book.setExpectfee(expectFee.toString());
                            book.setTotalexpectfee(expectFee.toString());
                            //设置当前应还,(当前逾期费 + 每期费用)
                            book.setRepaytotal(expectFee.add(new BigDecimal(book.getMonthrent())).toString());
                        }else{
                            //查看上次同步时间，并根据上次同步时间，计算当前逾期费用
                            String syncDate = book.getSyncdate();
                            int syncDay = PublicUtil.diffDayByDayDate(PublicUtil.strDateToDate(syncDate, "yyyy-MM-dd"));
                            //修改当前逾期费， 并修改当前逾期总费用
                            if(diffDay > syncDay && syncDay != 0) {
                                //本次同步要产生的逾期费用
                                BigDecimal addExpectFee = bigDecimal.multiply(new BigDecimal(0.04)).multiply(new BigDecimal(diffDay -  syncDay)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                                //当前逾期费用
                                String expectFee = book.getExpectfee() == null ? "0" : book.getExpectfee();
                                book.setExpectfee(new BigDecimal(expectFee).add(addExpectFee).toString());

                                //历史逾期总费用
                                String totalExpectFee = book.getTotalexpectfee() == null ? "0" : book.getTotalexpectfee();
                                book.setTotalexpectfee(new BigDecimal(totalExpectFee).add(addExpectFee).toString());
                                book.setRepaytotal(new BigDecimal(book.getMonthrent()).add(new BigDecimal(book.getExpectfee())).toString());
                            }
                        }
                        book.setSyncdate(PublicUtil.getDate("yyyy-MM-dd"));
                        bookDao.setBookOverdueFee(book); //设置逾期费用信息

                        //处理订单每期费用信息
                        dealBookEachFee(book);
                    }else if(diffDay >= 3) {  //逾期大于三天， 那么订单转为由租转售
                        if(StringUtils.isEmpty(book.getSyncdate())) {
                            //说明首次同步订单， 这属于服务一直故障阶段

                            //逾期超过3天，那么订单将变为由租转售,
                            //费用计算定式（前两天2 * 0.04 * 商品价格 + 总逾期天数 * 0.03 * 商品价格），
                            BigDecimal price = new BigDecimal(book.getProduct_price());
                            //生成的当前逾期费
                            BigDecimal currExpectFee = new BigDecimal(2).multiply(price).multiply(new BigDecimal(0.04))
                                    .add(new BigDecimal(diffDay).multiply(price).multiply(new BigDecimal(0.03))).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                            //计算总逾期费用， (总逾期费 - 当前逾期费 + 生成的逾期费)
                            book.setTotalexpectfee(price.multiply(new BigDecimal(book.getTotalexpectfee() == null ? "0" : book.getTotalexpectfee())
                                    .subtract(new BigDecimal(book.getExpectfee() == null ? "0" : book.getTotalexpectfee())))
                                    .add(currExpectFee).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                            //设置当前逾期费
                            book.setExpectfee(currExpectFee.toString());
                            //设置当前应还款额 (产品总额 + 总逾期金额 - 已还款总额)
                            book.setRepaytotal(new BigDecimal(book.getTotalexpectfee())
                                    .add(new BigDecimal(book.getProduct_price()))
                                    .subtract(new BigDecimal(book.getReimbursement()==null?"0":book.getReimbursement())).toString());
                        }else{
                            BigDecimal price = new BigDecimal(book.getProduct_price());
                            int syncDay = PublicUtil.diffDayByDayDate(PublicUtil.strDateToDate(book.getSyncdate(), "yyyy-MM-dd"));
                            if(diffDay > syncDay && syncDay != 0) {
                                if(!Objects.equals(book.getBook_type(), "1")) {
                                    //说明订单状态为出租状态，刚开始转变为 由租转售状态
                                    //生成的当前逾期费
                                    BigDecimal currExpectFee = new BigDecimal(2).multiply(price).multiply(new BigDecimal(0.04))
                                            .add(new BigDecimal(diffDay).multiply(price).multiply(new BigDecimal(0.03))).setScale(2, BigDecimal.ROUND_HALF_DOWN);

                                    //计算总逾期费用， (总逾期费 - 当前逾期费 + 生成的逾期费)
                                    book.setTotalexpectfee(price.multiply(new BigDecimal(book.getTotalexpectfee() == null ? "0" : book.getTotalexpectfee())
                                            .subtract(new BigDecimal(book.getExpectfee() == null ? "0" : book.getTotalexpectfee())))
                                            .add(currExpectFee).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());

                                    //设置当前逾期费
                                    book.setExpectfee(currExpectFee.toString());
                                    //设置当前应还款额 (产品总额 + 总逾期金额 - 已还款总额)
                                    book.setRepaytotal(new BigDecimal(book.getTotalexpectfee())
                                            .add(new BigDecimal(book.getProduct_price()))
                                            .subtract(new BigDecimal(book.getReimbursement()==null?"0":book.getReimbursement())).toString());
                                }else{
                                    BigDecimal newExpectFee =  new BigDecimal(syncDay).multiply(price)
                                            .multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                                    //设置当前逾期费
                                    book.setExpectfee(new BigDecimal(book.getExpectfee()==null?"0":book.getExpectfee()).add(newExpectFee).toString());
                                    //设置当前总逾期费
                                    book.setTotalexpectfee(new BigDecimal(book.getTotalexpectfee()).add(newExpectFee).toString());
                                    //设置当前应还
                                    book.setRepaytotal(new BigDecimal(book.getTotalexpectfee())
                                            .add(new BigDecimal(book.getProduct_price()))
                                            .subtract(new BigDecimal(book.getReimbursement()==null?"0":book.getReimbursement())).toString());
                                }
                            }
                        }
                        book.setSyncdate(PublicUtil.getDate("yyyy-MM-dd"));
                        bookDao.setBookRent(book);

                        //处理当前期的费用
                        dealBookEachFee(book);
                    }else{
                        System.out.println("尚未逾期......");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                //记录操作错误日志
                bookDao.insertErrBookMsg(book.getBook_no(), (e.getMessage() != null? e.getMessage().substring(0, 1000) : "无错误信息"));
            }
        }
    }




    /**
     * 处理订单每期费用信息
     * @param book
     */
    private void dealBookEachFee(Book book) {
        //获取当前期信息
        Payment payment = bookDao.getCurrRepayByBook(book.getBid(), book.getRepaydate());
        //设置当前期的应还总额
        payment.setTotalmoney(book.getRepaytotal());
        //设置当前期的逾期费用
        payment.setExpectfee(book.getExpectfee());
        bookDao.updateRaymentFee(payment);
    }


}
