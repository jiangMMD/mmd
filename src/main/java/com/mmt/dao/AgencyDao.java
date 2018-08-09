package com.mmt.dao;

import com.mmt.model.Agency;
import com.mmt.pjo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgencyDao {

    List<Agency> getAgencyList(Agency agency);

    Agency getAgencyDetail(@Param("id") String id);

    int getAgencyWithLoginNo(Agency agency);

    void saveAgencyInfo(Agency agency);

    void updAgencyInfo(Agency agency);

    void delAgency(@Param("ids") List<String> ids);
}
