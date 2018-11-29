package com.mmd.dao;

import java.util.List;
import com.mmd.model.Message;
import org.apache.ibatis.annotations.Param;

public interface MessageDao {
    List<Message> getAllMessage(Message message);

    void addMessage(Message message);

    void delMessage(@Param("ids") List<String> strings);
}
