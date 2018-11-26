package com.mmd.utils;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.mmd.pjo.Result;
import com.baidu.yun.push.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Baidu推送工具
 */
public class BaiduPushUtils {

    private static final Logger logger = LoggerFactory.getLogger(BaiduPushUtils.class);

    //安卓秘钥
    public static String android_apiKey = "lZBuvBH2zO1GPn15mEWHjX0W ";
    public static String android_secretKey = "eUrZnCaquNRCFcOaiNI8OhCqGggVNtjL ";
    //IOS秘钥
    public static String ios_apikey = "WSDqelgrZ7CD3azkBcljSvkU";
    public static String ios_secretKey = "qTqcnmtvQGokO1oGImkROoMCaUpzkI3o";


    public static void main(String[] args) {
        pushAllIos("123");
    }

    /**
     * 广播推送安卓
     *
     * @return
     */
    public static Result pushAllAndroid(String msg) {
        PushKeyPair pushKeyPair = new PushKeyPair(android_apiKey, android_secretKey);
        BaiduPushClient client = new BaiduPushClient(pushKeyPair, BaiduPushConstants.CHANNEL_REST_URL);
        //创建消息JSON格式
        String msgJson = "{\"title\":\"TEST\",\"description\":\"Hello Baidu push!\"}";
        sendAllMsg(client, msgJson);
        return new Result();
    }

    /**
     * 广播推送IOS
     *
     * @return
     */
    public static Result pushAllIos(String msg) {
        PushKeyPair pushKeyPair = new PushKeyPair(ios_apikey, ios_secretKey);
        BaiduPushClient client = new BaiduPushClient(pushKeyPair, BaiduPushConstants.CHANNEL_REST_URL);
        //创建消息JSON格式
        String msgJson = "{\"aps\":\"{\"alert\": \"这是来自程序的测试\"}\"}";
        sendAllMsg(client, msgJson);
        return new Result();
    }

    private static void sendAllMsg(BaiduPushClient client, String msgJson) {

        //注册推送客户端的监听器
        client.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent yunLogEvent) {
                System.out.println(yunLogEvent);
                logger.info(yunLogEvent.getMessage());
            }
        });

        PushMsgToAllRequest request = new PushMsgToAllRequest().addMsgExpires(3600).addMessageType(0)
                .addMessage(msgJson).addSendTime(System.currentTimeMillis() / 1000 + 70).
                        addDeviceType(3);
        try {
            PushMsgToAllResponse response = client.pushMsgToAll(request);
            System.out.println("msgId:" + response.getMsgId() + ",sendTime:" + response.getSendTime() + ",timerId:" + response.getTimerId());
        } catch (PushClientException e) {
            e.printStackTrace();
        } catch (PushServerException e) {
            System.out.println(String.format("requestId: %d, errorCode: %d, errorMsg: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
    }


}
