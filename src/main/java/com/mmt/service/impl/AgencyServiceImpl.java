package com.mmt.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmt.dao.AgencyDao;
import com.mmt.model.Agency;
import com.mmt.model.User;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.AgencyService;
import com.mmt.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyDao agencyDao;

    @Autowired
    private HttpSession session;

    @Override
    public ResultPage<Agency> getAgencyList(Agency agency, Page page) {
        PageHelper.startPage(page);
        List<Agency> agencyList = agencyDao.getAgencyList(agency);
        return new ResultPage<>(agencyList);
    }

    @Override
    public Agency getAgencyDetail(String id){
        return agencyDao.getAgencyDetail(id);
    }

    @Override
    public Result saveAgencyInfo(Agency agency){
        User user = (User) session.getAttribute("user");
        agency.setAlogin_password(DigestUtils.md5DigestAsHex(agency.getAlogin_password_source().getBytes()));
        if(agency.getAid() == null) {
            agency.setCrtuser(user.getUser_no());
            agencyDao.saveAgencyInfo(agency);
        }else{
            agency.setUpduser(user.getUser_no());
            agencyDao.updAgencyInfo(agency);
        }
        return new Result();
    }

    @Override
    public int getAgencyWithLoginNo(Agency agency) {
        return agencyDao.getAgencyWithLoginNo(agency);
    }

    @Override
    public Result delAgency(String ids) {
        agencyDao.delAgency(PublicUtil.toListByIds(ids));
        return new Result();
    }

}
