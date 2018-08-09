package com.mmt.listener;

import com.alibaba.fastjson.JSON;
import com.mmt.dao.UserDao;
import com.mmt.model.User;
import com.mmt.pjo.AmqMsg;
import com.mmt.socket.MegSocketHandler;
import com.mmt.utils.PublicUtil;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;

@Transactional
public class AmqListener implements MessageListener {

    private static Logger logger = Logger.getLogger(AmqListener.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void onMessage(Message message) {
        System.out.println("------------监听rbt消息队列-----------");
        try {
            String msgJson = new String(message.getBody(), "UTF-8");
            //转为amqMsg
            AmqMsg amqMsg = JSON.parseObject(msgJson, AmqMsg.class);
            //处理通知
            dealNotify(amqMsg);
            System.out.println("---------消息结束--------");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.info("-----------RabbitMq接收者异常-----------" + e);
        } catch (Exception e1) {
            e1.printStackTrace();
            logger.info("-----------RabbitMq接收者异常-----------" + e1);
        }
    }

    /**
     * 通知相应工作人员
     *
     * @param amqMsg
     */
    private void dealNotify(AmqMsg amqMsg) throws UnsupportedEncodingException {
        String code = amqMsg.getCode();
        if (Objects.equals(code, "1")) {
            //说明是产品审核，那么需要通知具有产品审核权限的工作人员
            //审核页面的权限为27
            Map<String, Object> userMap = userDao.getUserByMenuId(27);
            if (userMap == null) {
                return;
            }
            String uids = (String) userMap.get("uids");
            //对这些客户发送消息
            if (MegSocketHandler.userMaps.size() == 0) {
                //说明服务器刚启动，此时无法进行通知操作,那么将这些消息加入到消息列表中
                userDao.addUserMessage(PublicUtil.toListByIds(uids), amqMsg.getMessage());
            } else {
                //创建要要通知的消息
                WebSocketMessage webSocketMessage = new TextMessage(amqMsg.getName().getBytes("UTF-8"));
                //找到对应客户进行通知
                Map<Long, WebSocketSession> maps = MegSocketHandler.userMaps;
                for (Map.Entry<Long, WebSocketSession> entry : maps.entrySet()) {
                    if (("," + uids + ",").contains(("," + entry.getKey() + ","))) {
                        MegSocketHandler.sendOneUserMeg(webSocketMessage, entry.getKey());
                    }
                }
            }
        }
    }
}
