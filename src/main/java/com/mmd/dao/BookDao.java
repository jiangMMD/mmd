package com.mmd.dao;

import com.mmd.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookDao {
    List<Map<String,Object>> getBookList(@Param("params") Map<String, String> params);

    void delBook(@Param("ids") List<String> ids);


}
