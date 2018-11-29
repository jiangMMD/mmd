package com.mmd.service;

import com.mmd.model.Message;
import com.mmd.pjo.Page;
import com.mmd.pjo.Result;
import com.mmd.pjo.ResultPage;


import java.util.Map;

public interface MessageService {


    ResultPage getAllMessage(Page page, Message message);


    Result addMessage(Message message);

    Result delMessage(String ids);
}
