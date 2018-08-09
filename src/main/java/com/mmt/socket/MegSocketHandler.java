package com.mmt.socket;

import com.mmt.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

/**
 * Created by xinghb on 2017/10/28.
 */
@Component
public class MegSocketHandler implements WebSocketHandler{
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MegSocketHandler.class);

    public static Map<Long, WebSocketSession> userMaps = new HashMap<>();


    @PostConstruct
    public void initAuthData() {
    }

    /**
     * 连接之后事件
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        User user = (User) webSocketSession.getAttributes().get("user");
        userMaps.put(user.getUid(), webSocketSession);

        //开始订阅消息，
        /**
         * 审核员，需要订阅审核权限通知（初审，复审通知）。  货代部门进行客户通知
         */

    }

    /**
     * 接收消息处理器
     * @param webSocketSession
     * @param webSocketMessage
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("webSocketSession = [" + webSocketSession + "], webSocketMessage = [" + webSocketMessage + "]");
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.out.println("MegSocketHandler.handleTransportError");
        logger.error(throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        //断开连接的时候，那么移除用户
        User user = (User) webSocketSession.getAttributes().get("user");
        userMaps.remove(user.getUid());
    }

    @Override
    public boolean supportsPartialMessages() {
        System.out.println("MegSocketHandler.supportsPartialMessages1");
        return false;
    }

    /**
     * 发送消息给拥有指定权限的用户
     */
    public static void sendUserMegWithAuth(WebSocketMessage<?> message, String id) {

    }

    public static void sendOneUserMeg(WebSocketMessage<?> message, Long userid) {
        WebSocketSession session = userMaps.get(userid);
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
}
