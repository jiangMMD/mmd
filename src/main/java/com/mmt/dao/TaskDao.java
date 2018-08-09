package com.mmt.dao;

import com.mmt.model.Accessory;
import com.mmt.model.Book;
import com.mmt.model.User;

import java.util.List;
import java.util.Map;

/**
 * 定时任务处理类
 */
public interface TaskDao {

    Map<String,Object> getLastSyncDate();

    List<Accessory> getBookAccs();

    List<User> getHeadiconList();
}
