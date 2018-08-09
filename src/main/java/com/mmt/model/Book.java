package com.mmt.model;

import com.mmt.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class Book {

    private Long bid;
    private String book_type; //1:由租转售
    private String type;
    private String name;
    private String phone;
    private String book_no;
    private String sex;
    private String birth;
    private String ethnic;
    private String identity;
    private String place;
    private String familyphone;
    private String koseki;
    private String nowaddress;
    private String company;
    private String income;
    private String consume;
    private String weixin;
    private String phoneserviceno;
    private String qq;
    private String email;
    private String memo;
    private String bankcard;
    private String bankaddress;
    private String family_linkone;
    private String family_linkone_sex;
    private String family_linkone_relation;
    private String family_linkone_phone;
    private String family_linkone_address;
    private String family_linktwo;
    private String family_linktwo_sex;
    private String family_linktwo_relation;
    private String family_linktwo_phone;
    private String family_linktwo_address;
    private String link_ids;
    private String product_name;
    private String product_imei;
    private String product_price;
    private String leaseterm;
    private String despositrate;
    private String desposit;
    private String monthrentrate;
    private String monthrent;
    private Long accessory_id;
    private String state;
    private String state_name;
    private Long agency_id;
    private String audit_state; //订单审核状态
    private String audit_state_name; //订单审核状态名称
    private String crtuser;
    private String crtdate;
    private String upduser;
    private String upddate;
    private String recsts;
    private String repaydate; //应还款日期
    private String expectfee; //逾期费用
    private Integer expectday;    //逾期天数
    private String repaylssue; //已还款的期数
    private String school;
    private String indatestring;
    private String studentcard;
    private String startdate; //订单开始时间

    private Agency agency;
    private String agency_name;
    private String agency_city;
    private String audituser;
    private String auditdate;
    private String reaudituser;
    private String reauditdate;
    private String updmemo;
    private String updItem;
    private String unpassaudit_memo;
    private String submitpact;
    private String oper; //操作类型
    private String syncdate; //订单同步的时间
    private String totalexpectfee; //历史总逾期费用（所有期的逾期总和）
    private String reimbursement; //已还款总额
    private String repaytotal; //当前应还款总额

    private String history_count; // 历史租赁数量


    private String taobao_loginno;
    private String taobao_password;
    private String zhifubao_loginno;
    private String zhifubao_password;
    private String xuexin_loginno;
    private String xuexin_password;

    private List<CusLink> cusLinkList;
    private Accessory accessory;

    //当前用户信息， 用于管理查询订单信息
    private User user;


    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getAudituser() {
        return audituser;
    }

    public void setAudituser(String audituser) {
        this.audituser = audituser;
    }

    public String getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(String auditdate) {
        this.auditdate = auditdate;
    }

    public String getUpdmemo() {
        return updmemo;
    }

    public void setUpdmemo(String updmemo) {
        this.updmemo = updmemo;
    }

    public String getUnpassaudit_memo() {
        return unpassaudit_memo;
    }

    public void setUnpassaudit_memo(String unpassaudit_memo) {
        this.unpassaudit_memo = unpassaudit_memo;
    }

    /*****附件信息*****/



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBook_no() {
        return book_no;
    }

    public void setBook_no(String book_no) {
        this.book_no = book_no;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFamilyphone() {
        return familyphone;
    }

    public void setFamilyphone(String familyphone) {
        this.familyphone = familyphone;
    }

    public String getKoseki() {
        return koseki;
    }

    public void setKoseki(String koseki) {
        this.koseki = koseki;
    }

    public String getNowaddress() {
        return nowaddress;
    }

    public void setNowaddress(String nowaddress) {
        this.nowaddress = nowaddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getPhoneserviceno() {
        return phoneserviceno;
    }

    public void setPhoneserviceno(String phoneserviceno) {
        this.phoneserviceno = phoneserviceno;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getBankaddress() {
        return bankaddress;
    }

    public void setBankaddress(String bankaddress) {
        this.bankaddress = bankaddress;
    }

    public String getFamily_linkone() {
        return family_linkone;
    }

    public void setFamily_linkone(String family_linkone) {
        this.family_linkone = family_linkone;
    }

    public String getFamily_linkone_sex() {
        return family_linkone_sex;
    }

    public void setFamily_linkone_sex(String family_linkone_sex) {
        this.family_linkone_sex = family_linkone_sex;
    }

    public String getFamily_linkone_relation() {
        return family_linkone_relation;
    }

    public void setFamily_linkone_relation(String family_linkone_relation) {
        this.family_linkone_relation = family_linkone_relation;
    }

    public String getFamily_linkone_phone() {
        return family_linkone_phone;
    }

    public void setFamily_linkone_phone(String family_linkone_phone) {
        this.family_linkone_phone = family_linkone_phone;
    }

    public String getFamily_linkone_address() {
        return family_linkone_address;
    }

    public void setFamily_linkone_address(String family_linkone_address) {
        this.family_linkone_address = family_linkone_address;
    }

    public String getFamily_linktwo() {
        return family_linktwo;
    }

    public void setFamily_linktwo(String family_linktwo) {
        this.family_linktwo = family_linktwo;
    }

    public String getFamily_linktwo_sex() {
        return family_linktwo_sex;
    }

    public void setFamily_linktwo_sex(String family_linktwo_sex) {
        this.family_linktwo_sex = family_linktwo_sex;
    }

    public String getFamily_linktwo_relation() {
        return family_linktwo_relation;
    }

    public void setFamily_linktwo_relation(String family_linktwo_relation) {
        this.family_linktwo_relation = family_linktwo_relation;
    }

    public String getFamily_linktwo_phone() {
        return family_linktwo_phone;
    }

    public void setFamily_linktwo_phone(String family_linktwo_phone) {
        this.family_linktwo_phone = family_linktwo_phone;
    }

    public String getFamily_linktwo_address() {
        return family_linktwo_address;
    }

    public void setFamily_linktwo_address(String family_linktwo_address) {
        this.family_linktwo_address = family_linktwo_address;
    }

    public String getLink_ids() {
        return link_ids;
    }

    public void setLink_ids(String link_ids) {
        this.link_ids = link_ids;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_imei() {
        return product_imei;
    }

    public void setProduct_imei(String product_imei) {
        this.product_imei = product_imei;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getLeaseterm() {
        return leaseterm;
    }

    public void setLeaseterm(String leaseterm) {
        this.leaseterm = leaseterm;
    }

    public String getDespositrate() {
        return despositrate;
    }

    public void setDespositrate(String despositrate) {
        this.despositrate = despositrate;
    }

    public String getDesposit() {
        return desposit;
    }

    public void setDesposit(String desposit) {
        this.desposit = desposit;
    }

    public String getMonthrentrate() {
        return monthrentrate;
    }

    public void setMonthrentrate(String monthrentrate) {
        this.monthrentrate = monthrentrate;
    }

    public String getMonthrent() {
        return monthrent;
    }

    public void setMonthrent(String monthrent) {
        this.monthrent = monthrent;
    }

    public Long getAccessory_id() {
        return accessory_id;
    }

    public void setAccessory_id(Long accessory_id) {
        this.accessory_id = accessory_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public Long getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Long agency_id) {
        this.agency_id = agency_id;
    }

    public String getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(String audit_state) {
        this.audit_state = audit_state;
    }

    public String getAudit_state_name() {
        return audit_state_name;
    }

    public void setAudit_state_name(String audit_state_name) {
        this.audit_state_name = audit_state_name;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getRecsts() {
        return recsts;
    }

    public void setRecsts(String recsts) {
        this.recsts = recsts;
    }

    public List<CusLink> getCusLinkList() {
        return cusLinkList;
    }

    public void setCusLinkList(List<CusLink> cusLinkList) {
        this.cusLinkList = cusLinkList;
    }

    public String getRepaydate() {
        return repaydate;
    }

    public void setRepaydate(String repaydate) {
        //设置逾期天数
        if(!StringUtils.isEmpty(repaydate)) {
            int day = PublicUtil.diffDayByDayDate(PublicUtil.strDateToDate(repaydate, "yyyy-MM-dd"));
            if(day > 0) {
                this.setExpectday(day);
            }
        }
        this.repaydate = repaydate;
    }

    public String getExpectfee() {
        return expectfee;
    }

    public void setExpectfee(String expectfee) {
        this.expectfee = expectfee;
    }

    public Integer getExpectday() {
        return expectday;
    }

    public void setExpectday(Integer expectday) {
        this.expectday = expectday;
    }

    public String getRepaylssue() {
        return repaylssue;
    }

    public void setRepaylssue(String repaylssue) {
        this.repaylssue = repaylssue;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getIndatestring() {
        return indatestring;
    }

    public void setIndatestring(String indatestring) {
        this.indatestring = indatestring;
    }

    public String getStudentcard() {
        return studentcard;
    }

    public void setStudentcard(String studentcard) {
        this.studentcard = studentcard;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getAgency_city() {
        return agency_city;
    }

    public void setAgency_city(String agency_city) {
        this.agency_city = agency_city;
    }

    public String getReaudituser() {
        return reaudituser;
    }

    public void setReaudituser(String reaudituser) {
        this.reaudituser = reaudituser;
    }

    public String getReauditdate() {
        return reauditdate;
    }

    public void setReauditdate(String reauditdate) {
        this.reauditdate = reauditdate;
    }

    public String getSubmitpact() {
        return submitpact;
    }

    public void setSubmitpact(String submitpact) {
        this.submitpact = submitpact;
    }

    public String getHistory_count() {
        return history_count;
    }

    public void setHistory_count(String history_count) {
        this.history_count = history_count;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }


    public String getSyncdate() {
        return syncdate;
    }

    public void setSyncdate(String syncdate) {
        this.syncdate = syncdate;
    }

    public String getTotalexpectfee() {
        return totalexpectfee;
    }

    public void setTotalexpectfee(String totalexpectfee) {
        this.totalexpectfee = totalexpectfee;
    }

    public String getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(String reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getRepaytotal() {
        return repaytotal;
    }

    public void setRepaytotal(String repaytotal) {
        this.repaytotal = repaytotal;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaobao_loginno() {
        return taobao_loginno;
    }

    public void setTaobao_loginno(String taobao_loginno) {
        this.taobao_loginno = taobao_loginno;
    }

    public String getTaobao_password() {
        return taobao_password;
    }

    public void setTaobao_password(String taobao_password) {
        this.taobao_password = taobao_password;
    }

    public String getZhifubao_loginno() {
        return zhifubao_loginno;
    }

    public void setZhifubao_loginno(String zhifubao_loginno) {
        this.zhifubao_loginno = zhifubao_loginno;
    }

    public String getZhifubao_password() {
        return zhifubao_password;
    }

    public void setZhifubao_password(String zhifubao_password) {
        this.zhifubao_password = zhifubao_password;
    }

    public String getXuexin_loginno() {
        return xuexin_loginno;
    }

    public void setXuexin_loginno(String xuexin_loginno) {
        this.xuexin_loginno = xuexin_loginno;
    }

    public String getXuexin_password() {
        return xuexin_password;
    }

    public void setXuexin_password(String xuexin_password) {
        this.xuexin_password = xuexin_password;
    }

    public String getUpdItem() {
        return updItem;
    }

    public void setUpdItem(String updItem) {
        this.updItem = updItem;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", book_no='" + book_no + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", identity='" + identity + '\'' +
                ", place='" + place + '\'' +
                ", familyphone='" + familyphone + '\'' +
                ", koseki='" + koseki + '\'' +
                ", nowaddress='" + nowaddress + '\'' +
                ", company='" + company + '\'' +
                ", income='" + income + '\'' +
                ", consume='" + consume + '\'' +
                ", weixin='" + weixin + '\'' +
                ", phoneserviceno='" + phoneserviceno + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", memo='" + memo + '\'' +
                ", bankcard='" + bankcard + '\'' +
                ", bankaddress='" + bankaddress + '\'' +
                ", family_linkone='" + family_linkone + '\'' +
                ", family_linkone_sex='" + family_linkone_sex + '\'' +
                ", family_linkone_relation='" + family_linkone_relation + '\'' +
                ", family_linkone_phone='" + family_linkone_phone + '\'' +
                ", family_linkone_address='" + family_linkone_address + '\'' +
                ", family_linktwo='" + family_linktwo + '\'' +
                ", family_linktwo_sex='" + family_linktwo_sex + '\'' +
                ", family_linktwo_relation='" + family_linktwo_relation + '\'' +
                ", family_linktwo_phone='" + family_linktwo_phone + '\'' +
                ", family_linktwo_address='" + family_linktwo_address + '\'' +
                ", link_ids='" + link_ids + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_imei='" + product_imei + '\'' +
                ", product_price='" + product_price + '\'' +
                ", leaseterm='" + leaseterm + '\'' +
                ", despositrate='" + despositrate + '\'' +
                ", desposit='" + desposit + '\'' +
                ", monthrentrate='" + monthrentrate + '\'' +
                ", monthrent='" + monthrent + '\'' +
                ", accessory_id=" + accessory_id +
                ", state='" + state + '\'' +
                ", state_name='" + state_name + '\'' +
                ", agency_id=" + agency_id +
                ", audit_state='" + audit_state + '\'' +
                ", audit_state_name='" + audit_state_name + '\'' +
                ", crtuser='" + crtuser + '\'' +
                ", crtdate='" + crtdate + '\'' +
                ", upduser='" + upduser + '\'' +
                ", upddate='" + upddate + '\'' +
                ", recsts='" + recsts + '\'' +
                ", repaydate='" + repaydate + '\'' +
                ", expectfee='" + expectfee + '\'' +
                ", repaylssue='" + repaylssue + '\'' +
                ", school='" + school + '\'' +
                ", indatestring='" + indatestring + '\'' +
                ", studentcard='" + studentcard + '\'' +
                ", cusLinkList=" + cusLinkList +
                ", accessory=" + accessory +
                '}';
    }

    public void updateFeeWithSms(Long bid) {
    }
}
