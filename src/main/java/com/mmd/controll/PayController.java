package com.mmd.controll;

import com.mmd.pjo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 支付相关
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    /**
     * 扫描二维码事件
     */
    public Result scanQRcode(@RequestBody Map<String, Object> params) {
        return null;
    }


}
