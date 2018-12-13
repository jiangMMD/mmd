package com.mmd.dao;

import com.mmd.model.ProdSkupropval;

import java.util.Map;

public interface PropvalDao {
    Map<String, Object> getPropValDetail(String id);
}
