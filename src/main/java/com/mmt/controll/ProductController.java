package com.mmt.controll;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllSkuProduct")
    public @ResponseBody Result getAllSkuProduct() {
        return productService.getAllSkuProduct();
    }

    @RequestMapping("/getAllProduct")
    public @ResponseBody Result getAllProdcut() {
        return productService.getAllProduct();
    }

    @RequestMapping("/getSkuProductByPid")
    public @ResponseBody Result getSkuProductByPid(String product_id) {
        return productService.getSkuProductByPid(product_id);
    }

    @RequestMapping("/getLineImeiInfo")
    public @ResponseBody
    ResultPage getLineImeiInfo(@RequestParam Map<String, String> params, Page page) {
        return productService.getLineImeiInfo(params, page);
    }

    /**
     * imei详细
     */
    @RequestMapping("/toImeiDetail")
    public ModelAndView toImeiDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = productService.getImeiDetailById(id);
        modelAndView.addObject("imei", map);
        modelAndView.setViewName("../content/product/lineimeidetail.jsp");
        return modelAndView;
    }

    @RequestMapping("/getOutLink")
    public @ResponseBody ResultPage getOutLink(@RequestParam Map<String, Object> params, Page page) {
        return productService.getOutLink(page, params);
    }

    @RequestMapping("/toOutLinkDet")
    public ModelAndView toOutLinkDet(String lid) {
        Map<String, Object> map = productService.toOutLinkDet(lid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../content/product/outlinkproductdetail.jsp");
        modelAndView.addObject("outProduct", map);
        return modelAndView;
    }

    /**
     * 审核通过产品
     * @param params
     * @return
     */
    @RequestMapping("/passAuditOutProduct")
    public @ResponseBody Result passAuditOutProduct(@RequestParam Map<String, Object> params) {
        return productService.passAuditOutProduct(params);
    }

    /**
     * 审核拒绝产品
     */
    @RequestMapping("/unPassAuditOutPorduct")
    public @ResponseBody Result unPassAuditOutPorduct(@RequestParam Map<String, Object> params) {
        return productService.unPassAuditOutPorduct(params);
    }
}
