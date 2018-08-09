package com.mmt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmt.dao.ProductDao;
import com.mmt.model.User;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.ProductService;
import com.mmt.utils.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private HttpSession session;

    @Override
    public Result getAllSkuProduct() {
        List<Map<String, Object>> list = productDao.getAllSkuProduct();
        return new Result(1, "查询成功！", list);
    }

    @Override
    public Result getAllProduct() {
        List<Map<String, Object>> list = productDao.getAllProduct();
        return new Result(1, "查询成功！", list);
    }

    @Override
    public ResultPage getLineImeiInfo(Map<String, String> params, Page page) {
        PageHelper.startPage(page);
        return new ResultPage(productDao.getLineImeiInfo(params));
    }

    @Override
    public Result getSkuProductByPid(String product_id) {
        List<Map<String, Object>> list = productDao.getSkuProductByPid(product_id);
        return new Result(1, "查询成功！", list);
    }

    @Override
    public Map<String, Object> getImeiDetailById(String id) {
        return productDao.getImeiDetailById(id);
    }

    @Override
    public ResultPage getOutLink(Page page, Map<String, Object> params) {
        PageHelper.startPage(page);
        List<Map<String, Object>> list = productDao.getOutLink(params);
        return new ResultPage(list);
    }

    @Override
    public Map<String, Object> toOutLinkDet(String lid) {
        return productDao.toOutLinkDet(lid);
    }

    @Override
    public Result passAuditOutProduct(Map<String, Object> params) {
        //计算产品的总价值
        String product_eachprice = (String) params.get("product_eachprice");
        String product_lease = (String) params.get("product_lease");
        String product_price = new BigDecimal(product_eachprice).multiply(new BigDecimal(product_lease)).toString();
        params.put("product_price", product_price);
        User user = (User) session.getAttribute("user");
        params.put("audituser", user.getUser_no());
        //创建通知
        String msg = "尊敬的客户，您申请的外部链接产品，地址为："+params.get("link")+"，" +
                "已审核通过，产品名称为："+params.get("product_name")+", 颜色："+params.get("color")+", 内存："+params.get("storage")+";" +
                "签约价格："+params.get("product_signprice")+"元，" +
                "租期："+params.get("product_lease")+"个月,每期价格："+params.get("product_eachprice");
        params.put("notify_msg", msg);
        productDao.insertNotityWithOutProduct(params);
        productDao.passAuditOutPorduct(params);

        //发送短信通知结果
        return new Result();
    }

    @Override
    public Result unPassAuditOutPorduct(Map<String, Object> params) {
        String msg = "尊敬的客户，您申请的外部链接产品，地址为："+params.get("link")+", 审核拒绝，拒绝原因："+params.get("unpass_reason");
        params.put("notify_msg", msg);
        productDao.insertNotityWithUnPassOutProduct(params);
        User user = (User) session.getAttribute("user");
        params.put("audituser", user.getUser_no());
        productDao.unpassAuditOutProduct(params);
        return new Result();
    }
}
