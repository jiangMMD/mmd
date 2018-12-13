package com.mmd.dao;

import com.mmd.model.ProdSkupropname;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropnameDao {
    List<ProdSkupropname> getAllProp(ProdSkupropname prodSkupropname);

    void updPropnameInfo(ProdSkupropname prodSkupropname);

    void delPropnameInfo(@Param("ids") List<String> strings);

    ProdSkupropname getPropByName(@Param("propName") String propName);

    void addPropnameInfo(ProdSkupropname prodSkupropname);
}
