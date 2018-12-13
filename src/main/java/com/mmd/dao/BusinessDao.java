package com.mmd.dao;

import com.mmd.model.Merchant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessDao {

    List<Merchant> getMerchantList(Merchant merchant);

    Merchant getBusinessDetail(@Param("id") String id);

    void delBusiness(@Param("ids") List<String> ids);
}
