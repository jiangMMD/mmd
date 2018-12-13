package com.mmd.controll;

import com.mmd.model.Merchant;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.service.BusinessService;
import com.mmd.utils.PropertyLoad;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 商家及其商品控制类
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/getMerchantList")
    public @ResponseBody ResultPage getMerchantList(Page page, Merchant merchant) {
        return businessService.getMerchantList(page, merchant);
    }

    //详细
    @RequestMapping("/toBusinessDetail")
    public ModelAndView toBusinessDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Merchant merchant = businessService.getBusinessDetail(id);
        modelAndView.addObject("merchant", merchant);
        modelAndView.setViewName("../content/business/businessdetail.jsp");
        return modelAndView;
    }

    @RequestMapping("/delBusiness")
    public @ResponseBody
    Result delBusiness(String ids) {
        return businessService.delBusiness(ids);
    }
    //上线
    @RequestMapping("/uplineBusiness")
    public @ResponseBody
    Result uplineBusiness(String ids) {
        return businessService.uplineBusiness(ids);
    }
    //下线
    @RequestMapping("/downlineBusiness")
    public @ResponseBody
    Result downlineBusiness(String ids) {
        return businessService.downlineBusiness(ids);
    }

    /**
     * 添加修改商品信息
     * @param mer_homeimgFile
     * @param mer_homeiconFile
     * @param merchant
     * @return
     */
    @RequestMapping("/addOrUpdBusiness")
    public @ResponseBody Result addOrUpdBusiness(MultipartFile mer_homeimgFile, MultipartFile mer_homeiconFile, Merchant merchant) throws IOException {
        if(mer_homeiconFile !=null && !mer_homeiconFile.isEmpty()) {
            String fileName = dealFile(mer_homeiconFile, PropertyLoad.getProperty("business_filedir"));
            String url = PropertyLoad.getProperty("business_url") + fileName;
            System.out.println(PropertyLoad.getProperty("business_url"));
            merchant.setMerHomeicon(url);
        }
        if(mer_homeimgFile !=null && !mer_homeimgFile.isEmpty()) {
            String fileName = dealFile(mer_homeimgFile, PropertyLoad.getProperty("business_filedir"));
            String url = PropertyLoad.getProperty("business_url") + fileName;
            merchant.setMerHomeimg(url);
        }

        return businessService.addOrUpdBusiness(merchant);
    }


    /**
     * 处理文件，
     */
    private String dealFile(MultipartFile file, String dir) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        String ref = file_sourcename.substring(file_sourcename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0, 8);
        String filename = uuid + ref;
        File dirFile = new File(dir + File.separator +filename);
        if (!dirFile.getParentFile().exists()) {
            dirFile.getParentFile().mkdirs();
        }
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return filename;
    }

}
