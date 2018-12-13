package com.mmd.service;

import com.mmd.model.IntegralLog;
import com.mmd.pjo.Page;
import com.mmd.pjo.ResultPage;

public interface IntegralLogService {
    ResultPage getIntegralLogList(Page page, IntegralLog integralLog);
}
