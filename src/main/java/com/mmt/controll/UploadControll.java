package com.mmt.controll;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.mmt.constant.FileConstant;
import com.mmt.model.User;
import com.mmt.pjo.Result;
import com.mmt.service.UserService;
import com.mmt.utils.PropertyLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadControll {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @RequestMapping("uploadHeadIcon")
    public Result uploadHeadIcon(@RequestParam(value = "avatar") MultipartFile file) throws IOException {
        //上传头像信息, 将头像保存到指定的目录下
        User user = (User) session.getAttribute("user");
        String tempFileName = user.getUser_no() + "_" + UUID.randomUUID().toString().substring(0, 8) + "_" + file.getOriginalFilename();
        File saveImg = new File(PropertyLoad.getProperty("user_headicon_dir") + File.separator + tempFileName);
        System.out.println(PropertyLoad.getProperty("user_headicon_dir") + File.separator + tempFileName);
        if(!saveImg.getParentFile().exists()) {
            saveImg.getParentFile().mkdirs();
        }
        //创建该文件
        saveImg.createNewFile();
        //将文件复制到目标文件中
        file.transferTo(saveImg);
        //保存用户头像信息
        user.setHeadicon(FileConstant.NGINXHEADQUERY + "/" + tempFileName);
        userService.updateUserHeadIcon(user);
        session.setAttribute("user", user);
        return new Result(1, "操作成功！", FileConstant.NGINXHEADQUERY + "/" +tempFileName);
    }


    /**
     * 下载支付宝账单信息
     */
    @RequestMapping("/downZhifBill")
    public Result downZhifBill(String date) throws AlipayApiException {
        String zhifb_bill = PropertyLoad.getProperty("zhifb_bill");
        String zhifb_publickey = PropertyLoad.getProperty("zhifb_publickey");
        String zhifb_privatekey = PropertyLoad.getProperty("zhifb_privatekey");
        String zhifb_appid = PropertyLoad.getProperty("zhifb_appid");
        AlipayClient alipayClient = new DefaultAlipayClient(zhifb_bill, zhifb_appid, zhifb_privatekey,
                "json", "GBK", zhifb_publickey, "RSA2");
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent("{" +
                "\"bill_type\":\"signcustomer\"," +
                "\"bill_date\":\""+date+"\"}");
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            String jsonStr = response.getBody();
            Map<String, Object> result = (Map<String, Object>) JSON.parse(jsonStr);
            Map<String, Object> res = (Map<String, Object>) result.get("alipay_data_dataservice_bill_downloadurl_query_response");
            return new Result(1, "查找成功", res.get("bill_download_url"));
        } else {
            String jsonStr = response.getBody();
            Map<String, Object> result = (Map<String, Object>) JSON.parse(jsonStr);
            Map<String, Object> res = (Map<String, Object>) result.get("alipay_data_dataservice_bill_downloadurl_query_response");
            if(Objects.equals(res.get("code"), "40004")) {
                return new Result(0, "当日没有账单");
            }else{
                return new Result(0, "获取账单信息失败");
            }
        }
    }
}



