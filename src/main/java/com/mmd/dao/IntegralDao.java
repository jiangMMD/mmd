package com.mmd.dao;

import com.mmd.model.Integral;

import java.util.List;

public interface IntegralDao {
    List<Integral> getIntegralList(Integral integral);
}
