package com.mmt.controll;

import com.mmt.model.Agency;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.AgencyService;
import com.mmt.utils.PropertyLoad;
import com.mmt.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/agency")
public class AgencyControll {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping("/getAgencyList")
    public @ResponseBody ResultPage<Agency> getAgencyList(Agency agency, Page page) {
        return agencyService.getAgencyList(agency, page);
    }

    @RequestMapping("/toAgencyDetail")
    public ModelAndView toAgencyDetail(String aid) {
        ModelAndView modelAndView = new ModelAndView();
        Agency agencyWithDb = agencyService.getAgencyDetail(aid);
        modelAndView.addObject("agency", agencyWithDb);
        modelAndView.setViewName("../content/agency/agencydet.jsp");
        return modelAndView;
    }

    @RequestMapping("/saveAgencyInfo")
    public @ResponseBody Result saveAgencyInfo(MultipartFile contractfile, MultipartFile businessfile, MultipartFile otherdatafile, Agency agency) throws IOException {
        //校验信息
        int count = agencyService.getAgencyWithLoginNo(agency);
        if(count > 0) {
            return new Result(0, "登录名已存在, 请重新选择");
        }
        String contractFile = dealFile(String.valueOf(agency.getAid()), contractfile, "contract");
        String businessFile = dealFile(String.valueOf(agency.getAid()), businessfile, "business");
        String otherdataFile = dealFile(String.valueOf(agency.getAid()), otherdatafile, "otherdata");

        agency.setContract(contractFile);
        agency.setBusiness(businessFile);
        agency.setOtherdata(otherdataFile);
        return agencyService.saveAgencyInfo(agency);
    }


    private String dealFile(String aid, MultipartFile file, String typename) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        //生成文件名称
        String date = PublicUtil.getDate("yyyy-MM-dd");
        String filename = date + "_" + aid + "_" + typename + "_" + file_sourcename;
        String dir = PropertyLoad.getProperty("agency_accessory_dir");
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return filename;
    }

    /**
     * 删除代理商信息
     */
    @RequestMapping("/delAgency")
    public @ResponseBody Result delAgency(String ids) {
        return agencyService.delAgency(ids);
    }
}
