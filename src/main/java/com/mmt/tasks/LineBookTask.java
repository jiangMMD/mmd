package com.mmt.tasks;

import com.mmt.dao.BookDao;
import com.mmt.dao.LineBookDao;
import com.mmt.model.Book;
import com.mmt.model.LineBook;
import com.mmt.model.Payment;
import com.mmt.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 线上订单费用结算
 */
@Component
@Transactional
public class LineBookTask {

    @Autowired
    private LineBookDao lineBookDao;
    /**
     * 订单任务， 每日1点处理任务
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void task() {
        //查询所有待还订单，处理订单信息
        List<LineBook> lineBookList = lineBookDao.queryBookWithPaid();
        for (LineBook lineBook : lineBookList) {
            try {
                //查询该订单的费用信息
                String repayDateStr = lineBook.getRepaydate();
                if(StringUtils.isEmpty(repayDateStr)) {
                    //如果待还日为空， 那么说明该订单出现问题，加入错误信息中
                    String errmsg = "该订单待还日为空，此订单状态为待还状态，待还日不可为空";
                    lineBookDao.insertErrBookMsg(lineBook.getBook_no(), errmsg);
                }else{
                    Date repayDate = PublicUtil.strDateToDate(repayDateStr, "yyyy-MM-dd");
                    //查看当前日期是否大于待还日期， 如果大于，说明该订单已经逾期，便产生逾期费用了
                    int diffDay = PublicUtil.diffDayByDayDate(repayDate);
                    System.out.println(diffDay);
                    if(diffDay > 0 && diffDay < 3) {
                        //计算逾期费，
                        String product_price = lineBook.getProduct_price();  //商品总价
                        BigDecimal bigDecimal = new BigDecimal(product_price);
                        //计算历史总逾期费用
                        if(StringUtils.isEmpty(lineBook.getSyncdate())) { //如果该订单尚未同步，说明历史逾期费用就是当前逾期费用
                            lineBook.setSyncdate(PublicUtil.getDate("yyyy-MM-dd"));
                            //每日逾期费用为 3%； （总价 * 逾期费3% * 逾期天数）
                            BigDecimal expectFee = bigDecimal.multiply(new BigDecimal(0.03)).multiply(new BigDecimal(diffDay)).setScale(2, BigDecimal.ROUND_HALF_DOWN); //默认采用四舍五入
                            lineBook.setExpectfee(expectFee.toString());
                            lineBook.setTotalexpectfee(expectFee.toString());
                            //设置当前应还,(当前逾期费 + 每期费用)
                            lineBook.setRepaytotal(expectFee.add(new BigDecimal(lineBook.getLeaseterm_price())).toString());
                        }else{
                            //查看上次同步时间，并根据上次同步时间，计算当前逾期费用
                            String syncDate = lineBook.getSyncdate();
                            int syncDay = PublicUtil.diffDayByDayDate(PublicUtil.strDateToDate(syncDate, "yyyy-MM-dd"));
                            //修改当前逾期费， 并修改当前逾期总费用
                            if(diffDay > syncDay && syncDay != 0) {
                                //本次同步要产生的逾期费用
                                BigDecimal addExpectFee = bigDecimal.multiply(new BigDecimal(0.03)).multiply(new BigDecimal(diffDay -  syncDay)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                                //当前逾期费用
                                String expectFee = lineBook.getExpectfee() == null ? "0" : lineBook.getExpectfee();
                                lineBook.setExpectfee(new BigDecimal(expectFee).add(addExpectFee).toString());

                                //历史逾期总费用
                                String totalExpectFee = lineBook.getTotalexpectfee() == null ? "0" : lineBook.getTotalexpectfee();
                                lineBook.setTotalexpectfee(new BigDecimal(totalExpectFee).add(addExpectFee).toString());
                                lineBook.setRepaytotal(new BigDecimal(lineBook.getLeaseterm_price()).add(new BigDecimal(lineBook.getExpectfee())).toString());
                            }
                        }
                        lineBook.setSyncdate(PublicUtil.getDate("yyyy-MM-dd"));
                        lineBookDao.setBookOverdueFee(lineBook); //设置逾期费用信息

                        //处理订单每期费用信息
                        dealBookEachFee(lineBook);
                    }else if(diffDay >= 3) {  //逾期大于三天， 那么订单转为由租转售
                        if(StringUtils.isEmpty(lineBook.getSyncdate())) {
                            //说明首次同步订单， 这属于服务一直故障阶段
                            //逾期超过3天，那么订单将变为由租转售,
                            //费用计算定式（前两天2 * 0.03 * 商品价格 + 总逾期天数 * 0.04 * 商品价格），
                            BigDecimal price = new BigDecimal(lineBook.getProduct_price());
                            //生成的当前逾期费
                            BigDecimal currExpectFee = new BigDecimal(2).multiply(price).multiply(new BigDecimal(0.03))
                                    .add(new BigDecimal(diffDay).multiply(price).multiply(new BigDecimal(0.04))).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                            //计算总逾期费用， (总逾期费 - 当前逾期费 + 生成的逾期费)
                            lineBook.setTotalexpectfee(price.multiply(new BigDecimal(lineBook.getTotalexpectfee() == null ? "0" : lineBook.getTotalexpectfee())
                                    .subtract(new BigDecimal(lineBook.getExpectfee() == null ? "0" : lineBook.getTotalexpectfee())))
                                    .add(currExpectFee).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
                            //设置当前逾期费
                            lineBook.setExpectfee(currExpectFee.toString());
                            //设置当前应还款额 (产品总额 + 总逾期金额 - 已还款总额)
                            lineBook.setRepaytotal(new BigDecimal(lineBook.getTotalexpectfee())
                                    .add(new BigDecimal(lineBook.getProduct_price()))
                                    .subtract(new BigDecimal(lineBook.getReimbursement()==null?"0":lineBook.getReimbursement())).toString());
                        }else{
                            BigDecimal price = new BigDecimal(lineBook.getProduct_price());
                            int syncDay = PublicUtil.diffDayByDayDate(PublicUtil.strDateToDate(lineBook.getSyncdate(), "yyyy-MM-dd"));
                            if(diffDay > syncDay && syncDay != 0) {
                                if(!Objects.equals(lineBook.getBook_type(), "1")) {
                                    //说明订单状态为出租状态，刚开始转变为 由租转售状态
                                    //生成的当前逾期费
                                    BigDecimal currExpectFee = new BigDecimal(2).multiply(price).multiply(new BigDecimal(0.03))
                                            .add(new BigDecimal(diffDay).multiply(price).multiply(new BigDecimal(0.04))).setScale(2, BigDecimal.ROUND_HALF_DOWN);

                                    //计算总逾期费用， (总逾期费 - 当前逾期费 + 生成的逾期费)
                                    lineBook.setTotalexpectfee(price.multiply(new BigDecimal(lineBook.getTotalexpectfee() == null ? "0" : lineBook.getTotalexpectfee())
                                            .subtract(new BigDecimal(lineBook.getExpectfee() == null ? "0" : lineBook.getTotalexpectfee())))
                                            .add(currExpectFee).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());

                                    //设置当前逾期费
                                    lineBook.setExpectfee(currExpectFee.toString());
                                    //设置当前应还款额 (产品总额 + 总逾期金额 - 已还款总额)
                                    lineBook.setRepaytotal(new BigDecimal(lineBook.getTotalexpectfee())
                                            .add(new BigDecimal(lineBook.getProduct_price()))
                                            .subtract(new BigDecimal(lineBook.getReimbursement()==null?"0":lineBook.getReimbursement())).toString());
                                }else{
                                    BigDecimal newExpectFee =  new BigDecimal(syncDay).multiply(price)
                                            .multiply(new BigDecimal(0.04)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                                    //设置当前逾期费
                                    lineBook.setExpectfee(new BigDecimal(lineBook.getExpectfee()==null?"0":lineBook.getExpectfee()).add(newExpectFee).toString());
                                    //设置当前总逾期费
                                    lineBook.setTotalexpectfee(new BigDecimal(lineBook.getTotalexpectfee()).add(newExpectFee).toString());
                                    //设置当前应还
                                    lineBook.setRepaytotal(new BigDecimal(lineBook.getTotalexpectfee())
                                            .add(new BigDecimal(lineBook.getProduct_price()))
                                            .subtract(new BigDecimal(lineBook.getReimbursement()==null?"0":lineBook.getReimbursement())).toString());
                                }
                            }
                        }
                        lineBook.setSyncdate(PublicUtil.getDate("yyyy-MM-dd"));
                        lineBookDao.setBookRent(lineBook);

                        //处理当前期的费用
                        dealBookEachFee(lineBook);
                    }else{
                        System.out.println("尚未逾期......");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                //记录操作错误日志
                lineBookDao.insertErrBookMsg(lineBook.getBook_no(), (e.getMessage() != null? e.getMessage().substring(0, 1000) : "无错误信息"));
            }
        }
    }


    /**
     * 处理订单每期费用信息
     */
    private void dealBookEachFee(LineBook lineBook) {
        //获取当前期信息
        Payment payment = lineBookDao.getCurrRepayByBook(lineBook.getBid(), lineBook.getRepaydate());
        //设置当前期的应还总额
        payment.setTotalmoney(lineBook.getRepaytotal());
        //设置当前期的逾期费用
        payment.setExpectfee(lineBook.getExpectfee());
        lineBookDao.updateRaymentFee(payment);
    }
}
