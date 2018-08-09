package com.mmt.service.impl;

import com.github.pagehelper.PageHelper;
import com.mmt.dao.BookDao;
import com.mmt.dao.CustomDao;
import com.mmt.model.Accessory;
import com.mmt.model.CusLink;
import com.mmt.model.Custom;
import com.mmt.model.User;
import com.mmt.pjo.Page;
import com.mmt.pjo.Result;
import com.mmt.pjo.ResultPage;
import com.mmt.service.CustomService;
import com.mmt.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    private CustomDao customDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private HttpSession session;

    @Override
    public ResultPage<Custom> getCustom(Page page, Custom custom) {
        PageHelper.startPage(page);
        List<Custom> customList = customDao.getCustom(custom);
        return new ResultPage<>(customList);
    }

    @Override
    public Result delCustom(String ids) {
        int booknums = customDao.getBookNumsWithCids(PublicUtil.toListByIds(ids));
        if(booknums > 0) {
            return new Result(0, "操作失败，选中的客户中有订单信息，无法删除； 如需删除，请联系管理员进行删除");
        }
        customDao.delCustom(ids);
        return new Result();
    }

    @Override
    public Custom getCustomDetail(String cid) {
        return customDao.getCustomDetail(cid);
    }

    @Override
    public Result saveCustom(Custom custom) {
        User user = (User) session.getAttribute("user");
        //联系人信息
        List<CusLink> cusList = custom.getCusLinkList();
        StringBuilder link_ids = new StringBuilder();
        for (CusLink cusLink : cusList) {
            cusLink.setUpduser(user.getUser_no());
            if(cusLink.getLid() == null) {
                bookDao.addCusLink(cusLink);
            }else{
                bookDao.updCusLink(cusLink);
            }
            link_ids.append(",");
            link_ids.append(String.valueOf(cusLink.getLid()));
        }
        custom.setLink_ids(link_ids.substring(1));
        //保存附件信息
        customDao.updateCustom(custom);
        return new Result();
    }
}
