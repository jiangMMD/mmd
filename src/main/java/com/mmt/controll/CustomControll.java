package com.mmt.controll;

import com.mmt.model.Book;
import com.mmt.model.CusLink;
import com.mmt.model.Custom;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.CustomService;
import com.mmt.utils.PropertyLoad;
import com.mmt.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/custom")
public class CustomControll {

    @Autowired
    private CustomService customService;

    @RequestMapping("/getCustom")
    public @ResponseBody ResultPage<Custom> getCustom(Page page, Custom custom) {
        return customService.getCustom(page, custom);
    }

    @RequestMapping("/delCustom")
    public @ResponseBody
    Result delCustom (String ids) {
        return customService.delCustom(ids);
    }

    @RequestMapping("/toCustomDetail")
    public ModelAndView toCustomDetail(String cid) {
        ModelAndView modelAndView = new ModelAndView();
        Custom custom = customService.getCustomDetail(cid);
        if(custom == null) {
            modelAndView.setViewName("../content/common/error-403.html");
        }else{
            modelAndView.addObject("custom", custom);
            modelAndView.setViewName("../content/custom/customdetail.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/saveCustom")
    public @ResponseBody Result saveCustom(MultipartFile identity_frontFile, MultipartFile identity_reverseFile,
                                           MultipartFile cus_photoFile, MultipartFile workcardFile,
                                           MultipartFile zhimbvideoFile, Custom custom, Map<String, String> params) throws IOException {

        if(identity_frontFile != null && !identity_frontFile.isEmpty()) {
            custom.setIdentity_front(dealFile(custom.getCid(), identity_frontFile, "identity_front"));
        }
        if(identity_reverseFile != null && !identity_reverseFile.isEmpty()) {
            custom.setIdentity_reverse(dealFile(custom.getCid(), identity_reverseFile, "identity_reverse"));
        }
        if(cus_photoFile != null && !cus_photoFile.isEmpty()) {
            custom.setCus_photo(dealFile(custom.getCid(), cus_photoFile, "cus_photo"));
        }
        if(workcardFile != null && !workcardFile.isEmpty()) {
            custom.setWorkcard(dealFile(custom.getCid(), workcardFile, "work_card"));
        }
        if(zhimbvideoFile != null && !zhimbvideoFile.isEmpty()) {
            custom.setZhimfvideo(dealFile(custom.getCid(), zhimbvideoFile, "zhifmvideo"));
        }
        //处理联系人信息
        dealLinkInfo(custom, params);
        return customService.saveCustom(custom);
    }

    private void dealLinkInfo(Custom custom, Map<String, String> params) {
        List<CusLink> cusLinks = new ArrayList<>();
        CusLink cusLink1 = new CusLink(StringUtils.isEmpty(params.get("lid1"))?null:Long.valueOf(params.get("lid1")), PublicUtil.mapValToString(params.get("lname1")),
                PublicUtil.mapValToString(params.get("lsex1")),
                PublicUtil.mapValToString(params.get("lrelation1")),
                PublicUtil.mapValToString(params.get("lphone1")),
                PublicUtil.mapValToString(params.get("lmemo1")));
        CusLink cusLink2 = new CusLink(StringUtils.isEmpty(params.get("lid2"))?null:Long.valueOf(params.get("lid2")), PublicUtil.mapValToString(params.get("lname2")),
                PublicUtil.mapValToString(params.get("lsex2")),
                PublicUtil.mapValToString(params.get("lrelation2")),
                PublicUtil.mapValToString(params.get("lphone2")),
                PublicUtil.mapValToString(params.get("lmemo2")));
        cusLinks.add(cusLink1);
        cusLinks.add(cusLink2);
        if (!StringUtils.isEmpty(params.get("lname3")) || !StringUtils.isEmpty(params.get("lphone3"))) {
            CusLink cusLink3 = new CusLink(StringUtils.isEmpty(params.get("lid3"))?null:Long.valueOf(params.get("lid3")), PublicUtil.mapValToString(params.get("lname3")),
                    PublicUtil.mapValToString(params.get("lsex3")),
                    PublicUtil.mapValToString(params.get("lrelation3")),
                    PublicUtil.mapValToString(params.get("lphone3")),
                    PublicUtil.mapValToString(params.get("lmemo3")));
            cusLinks.add(cusLink3);
        }
        if (!StringUtils.isEmpty(params.get("lname4")) || !StringUtils.isEmpty(params.get("lphone4"))) {
            CusLink cusLink4 = new CusLink(StringUtils.isEmpty(params.get("lid4"))?null:Long.valueOf(params.get("lid4")), PublicUtil.mapValToString(params.get("lname4")),
                    PublicUtil.mapValToString(params.get("lsex4")),
                    PublicUtil.mapValToString(params.get("lrelation4")),
                    PublicUtil.mapValToString(params.get("lphone4")),
                    PublicUtil.mapValToString(params.get("lmemo4")));
            cusLinks.add(cusLink4);
        }
        if (!StringUtils.isEmpty(params.get("lname5")) || !StringUtils.isEmpty(params.get("lphone5"))) {
            CusLink cusLink5 = new CusLink(StringUtils.isEmpty(params.get("lid5"))?null:Long.valueOf(params.get("lid5")), PublicUtil.mapValToString(params.get("lname5")),
                    PublicUtil.mapValToString(params.get("lsex5")),
                    PublicUtil.mapValToString(params.get("lrelation5")),
                    PublicUtil.mapValToString(params.get("lphone5")),
                    PublicUtil.mapValToString(params.get("lmemo5")));
            cusLinks.add(cusLink5);
        }
        if (!StringUtils.isEmpty(params.get("lname6")) || !StringUtils.isEmpty(params.get("lphone6"))) {
            CusLink cusLink6 = new CusLink(StringUtils.isEmpty(params.get("lid6"))?null:Long.valueOf(params.get("lid6")), PublicUtil.mapValToString(params.get("lname6")),
                    PublicUtil.mapValToString(params.get("lsex6")),
                    PublicUtil.mapValToString(params.get("lrelation6")),
                    PublicUtil.mapValToString(params.get("lphone6")),
                    PublicUtil.mapValToString(params.get("lmemo6")));
            cusLinks.add(cusLink6);
        }
        custom.setCusLinkList(cusLinks);
    }

    /**
     * 处理文件，
     *
     * @param aid
     * @param file
     * @param typename
     * @return
     * @throws IOException
     */
    private String dealFile(String aid, MultipartFile file, String typename) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        String ref = file_sourcename.substring(file_sourcename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0, 8);
        //生成文件名称
        String date = PublicUtil.getDate("yyyy-MM-dd");
        String filename = date + "_" + aid + "_user_" + typename + "_" + uuid + ref;
        String dir = PropertyLoad.getProperty("custom_accessory_dir");
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return filename;
    }
}
