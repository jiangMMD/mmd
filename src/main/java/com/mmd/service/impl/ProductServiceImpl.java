package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.ProductDao;
import com.mmd.model.Employee;
import com.mmd.model.ProdCarousal;
import com.mmd.model.Productsinfo;
import com.mmd.model.User;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.ProductService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private HttpSession session;

    @Override
    public Result getProClassifyByKey(String key) {
        return new Result(1, "查询成功！", productDao.getProClassifyByKey(key));
    }

    @Override
    public ResultPage getProductList(Page page, Productsinfo productsinfo) {
        PageHelper.startPage(page);
        List<Productsinfo> list = productDao.getProductList(productsinfo);
        return new ResultPage<>(list);
    }

    @Override
    public Result delProduct(String ids) {
        productDao.delProduct(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result uplineProduct(String ids) {
        productDao.uplineProduct(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result downlineProduct(String ids) {
        productDao.downlineProduct(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Productsinfo getProductDetail(String id) {
        return productDao.getProductDetail(id);
    }

    @Override
    public ProdCarousal getProdCarousal(String id) {
        ProdCarousal prodCarousal = productDao.getProdCarousal(id);
        return prodCarousal;
    }


    @Override
    public List<ProdCarousal> getProdCarousalList(String id) {
        return productDao.getCarousalList(id);
    }

    @Override
    public List<Map<String, Object>> getProdService(String id) {
        return productDao.getProdService(id);
    }

    @Override
    public List<Map<String, Object>> getProdSku(String id) {
        List<Map<String, Object>> list = productDao.getProdSku(id);
//        for (int i = 0; i < list.size(); i++) {
//            Map<String, Object> map = list.get(i);
//            String skuVal = (String) map.get("sku_val");
//            String[] skuArr = skuVal.split(",");
//            Map<String, String> par = new HashMap<>();
//            List<Map<String, Object>> skuProp = new ArrayList<>();
//            for (String sku : skuArr) {
//                String[] propInfo= sku.split(":");
//                par.put("prop_name_id", propInfo[0]);
//                par.put("prop_val_id", propInfo[1]);
//                skuProp.add(productDao.getProdPropBySku(par));
//            }
//            map.put("skuProp", skuProp);
//        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllProdService(String serviceIds) {
        return productDao.getAllProdService(serviceIds);
    }

    @Override
    public List<Map<String, Object>> getProdParamImg(String id) {
        return productDao.getProdParamImg(id);
    }

    @Override
    public Result getProdSkuDetail(String sku_id) {
        Map<String, Object> map = productDao.getProdSkuDetail(sku_id);
        String skuVal = (String) map.get("sku_val");
        String[] skuArr = skuVal.split(",");
        Map<String, String> par = new HashMap<>();
        List<Map<String, Object>> skuProp = new ArrayList<>();
        for (String sku : skuArr) {
            String[] propInfo = sku.split(":");
            par.put("prop_name_id", propInfo[0]);
            par.put("prop_val_id", propInfo[1]);
            skuProp.add(productDao.getProdPropBySku(par));
        }
        map.put("skuProp", skuProp);
        return new Result(1, "查询成功！", map);
    }

    @Override
    public Result saveProdSku(Map<String, Object> params) {
        System.out.println(params);
        String[] propnameIds = String.valueOf(params.get("sku_propname_id")).split(",");
        String[] propvalIds = String.valueOf(params.get("sku_propval_id")).split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < propnameIds.length; i++) {
            sb.append(",");
            sb.append(propnameIds[i]).append(":").append(propvalIds[i]);
        }
        params.put("sku_val", sb.substring(1));
        //如果SKU_ID为空，那么就新增sku
        if (params.get("sku_id") == null || "".equals(params.get("sku_id"))) {
            productDao.insertSku(params);
        } else {
            productDao.updateSku(params);
        }
        dealSkuRel(String.valueOf(params.get("pid")));
        //修改产品总库存
        productDao.updateProdStore(String.valueOf(params.get("pid")));
        return new Result().success(params);
    }

    private void dealSkuRel(String pid) {
        //更新产品的关系属性表
        List<String> skuVals = productDao.getAllProdSkuVals(pid);
        System.out.println(skuVals);
        Set<Map<String, String>> set = new HashSet<>();
        for (String svalInfo : skuVals) {
            String[] svalArray = svalInfo.split(",");
            for(String sval : svalArray) {
                Map<String, String> map = new HashMap<>();
                String[] val = sval.split(":");
                map.put("prop_name_id", val[0]);
                map.put("prop_val_id", val[1]);
                set.add(map);
            }
        }
        productDao.delAllSkuRel(pid);
        productDao.insertSkuRel(set, pid);
    }

    @Override
    public Result delProdSku(String sku_id, String pid) {
        productDao.delProdSku(sku_id);
        dealSkuRel(pid);
        return new Result();
    }

    private Employee getEmployeeInfo() {
        return (Employee) session.getAttribute("employee");
    }

    @Override
    public Result addOrUpdProd(Productsinfo productsinfo) {
        Employee employee = getEmployeeInfo();
        if(productsinfo.getPid() != null) {
            productDao.updateProd(productsinfo);
        }else {
            productsinfo.setCrtuser(employee.getName());
            //设置产品编号
            productsinfo.setProdno(PublicUtil.getProdNo());
            productDao.addProd(productsinfo);
        }
        return new Result();
    }

    @Override
    public Result uploadCarousel(String filename, String goods_url, String pid) {
        productDao.uploadCarousel(goods_url, pid);
        return new Result().success(goods_url);
    }

    @Override
    public Result delCarousel(String url, String filename, String pid) {
        productDao.delCarousel(url, filename, pid);
        return new Result();
    }

    @Override
    public Result uploadDetailImg(String filename, String goods_url, String pid) {
        productDao.uploadDetailImg(goods_url, pid);
        return new Result().success(goods_url);
    }

    @Override
    public Result delDetailimg(String url, String filename, String pid) {
        productDao.delDetailimg(url, filename, pid);
        return new Result();
    }

}
