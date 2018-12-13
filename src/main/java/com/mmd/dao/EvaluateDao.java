package com.mmd.dao;

import com.mmd.model.ProdEvaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EvaluateDao {
    List<Map<String, Object>> getEvaluate(ProdEvaluate prodEvaluate);

    ProdEvaluate getProdEvaluateDetail(@Param("id") String id);

    void delEvaluate(@Param("ids") List<String> ids);

    List<Map>getWord(ProdEvaluate prodEvaluate);

    List<Map<String, Object>> getPnameByKey(@Param("key") String key);


    void delWord(@Param("id") String id);


    Map<String, Object> getEvalStar(@Param("id") String id);

    void updateStarNum(@Param("id") String id, @Param("evalStar") int evalStar);

    void updateAvgStar(@Param("pid") String pid);
}
