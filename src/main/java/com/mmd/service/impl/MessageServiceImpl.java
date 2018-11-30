package com.mmd.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmd.dao.MessageDao;
import com.mmd.model.Employee;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;
import com.mmd.plugin.QueryParamInterface;
import com.mmd.service.MessageService;
import com.mmd.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mmd.model.Message;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Autowired
    private HttpSession session;
    /**
     * 获取所有消息信息
     * @param page
     *      分页信息
     */
    @Override
    public ResultPage getAllMessage(Page page, Message message) {
        QueryParamInterface.setLocalPage(page);
        PageHelper.startPage(page);
        //处理查询参数问题
        List<Message> list = messageDao.getAllMessage(message);
        return new ResultPage<>(list);
    }


    @Override
    public Result addMessage(Message message) {
        message.setCrtuser(((Employee)session.getAttribute("employee")).getName());
        System.out.println(message);
        if (Objects.equals(message.getType(), "1"))
        {
           message.setUserId(null);
        }
       messageDao.addMessage(message);
        System.out.println(message);
        return new Result();
    }

    @Override
    public Result delMessage(String ids) {
        messageDao.delMessage(PublicUtil.toListByIds(ids));
        return new Result();
    }
}
