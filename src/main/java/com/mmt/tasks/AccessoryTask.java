package com.mmt.tasks;

import com.mmt.dao.BookDao;
import com.mmt.dao.TaskDao;
import com.mmt.dao.UserDao;
import com.mmt.model.Accessory;
import com.mmt.model.Book;
import com.mmt.model.User;
import com.mmt.service.UserService;
import com.mmt.utils.PropertyLoad;
import com.mmt.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

/**
 * 附件任务， 定时删除无效的附件（包含无效的用户头像，无效的用户数据）
 */
@Component
@Transactional
public class AccessoryTask {

    @Autowired
    private TaskDao taskDao;

//    @Scheduled(cron = "0 0 2 * * *") //每天凌晨2点执行
    public void Task() {
        String startSyncDate = PublicUtil.getDateTime();
        //开始同步订单附件
        List<Accessory> accessoryList = taskDao.getBookAccs();
        //生成Set数据集合
        Set<String> setDatas = dealAccesstory(accessoryList);
        //同步处理订单信息
        String book_dir = PropertyLoad.getProperty("book_accessory_dir");
        File dirFile = new File(book_dir);
        try {
            File[] files = dirFile.listFiles();
            if(files == null || files.length == 0) {
                return;
            }
            for (File file : files) {
                String name = file.getName();
                if(!setDatas.contains(name)) { //如果不包含， 那么就删除该文件
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //开始同步用户头像附件
        List<User> userList = taskDao.getHeadiconList();
    }

    public Set<String> dealUserHeadIcon(List<User> list) {
        Set<String> stringSet = new HashSet<>();
        if(list != null) {
            for (User user : list) {
                if(!StringUtils.isEmpty(user.getHeadicon()) && user.getHeadicon().contains("nginxImg")) {
                }
                stringSet.add(user.getHeadicon());
            }
        }
        return null;
    }

    public Set<String> dealAccesstory(List<Accessory> accessories) {
        Set<String> stringSet = new HashSet<>();
        if(accessories != null) {
            for (Accessory accessory : accessories) {
                stringSet.add(accessory.getIdentity_front());
                stringSet.add(accessory.getIdentity_reverse());
                stringSet.add(accessory.getIdentity_inhand());
                stringSet.add(accessory.getWork_card());
                stringSet.add(accessory.getStudent_card());
                stringSet.add(accessory.getStaff_photo());
                stringSet.add(accessory.getBank_card());
                stringSet.add(accessory.getTaobao_address());
                stringSet.add(accessory.getZhifb_zmf());
                stringSet.add(accessory.getImei());
                stringSet.add(accessory.getContract_photo());
                stringSet.add(accessory.getOperation_video());
                stringSet.add(accessory.getMemo_one());
                stringSet.add(accessory.getMemo_two());
            }
        }
        return stringSet;
    }

}
