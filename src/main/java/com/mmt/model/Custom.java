package com.mmt.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 客户
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Custom implements Serializable {

    private String cid;
    private String openid;
    private String type;
    private String source;
    private String phone;
    private String name;
    private String sex;
    private String ethnic;
    private String birthday;
    private String identity;
    private String nativeplace;
    private String koseki;
    private String nowaddress;
    private String phoneserviceno;
    private String bankcard;
    private String bankaddress;
    private String family_linkone_name;
    private String family_linkone_sex;
    private String family_linkone_relation;
    private String family_linkone_phone;
    private String family_linkone_address;
    private String family_linktwo_name;
    private String family_linktwo_sex;
    private String family_linktwo_relation;
    private String family_linktwo_phone;
    private String family_linktwo_address;
    private String contacts_ids;
    private String headimg;
    private String identity_front; //身份证正面
    private String identity_frontimg;
    private String identity_reverse; //身份证反面
    private String identity_reverseimg;
    private String cus_photo; //个人照
    private String cus_photoimg;
    private String company;
    private String income;
    private String consume;
    private String school;
    private String indatestring;
    private String studentcard;
    private String workcard;
    private String httpworkcard;
    private String zhimfvideo;
    private String httpzhimfvideo;
    private Integer family_flg = 2;  //是否完善亲属联系人
    private Integer link_flg = 2;  //是否完善联系人
    private Integer identity_flg = 2;  //是否完善身份信息
    private Integer person_flg = 2; //是否完善个人信息
    private Integer taobao_flg = 2; //是否完善淘宝信息
    private Integer zhifb_flg = 2;   //是否完善支付宝信息
    private Integer mobile_flg = 2;  //是否完善运营商信息
    private Integer student_flg = 2; //是否完善学信网信息

    //上传至微信的身份证正面，返回的serverId
    private String identity_front_serverId;
    private String identity_reverse_serverId;
    private String cus_photo_serverId;

    private String taobao_no;
    private String taobao_pass;
    private String zhifb_no;
    private String zhifb_pass;
    private String student_no;
    private String student_pass;
    private String shipaddress;

    private String crtuser;
    private String crtdate;
    private String recsts;

    private String linksJson;
    private String link_ids;
    private List<CusLink> cusLinkList;


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
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

    public String getPhoneserviceno() {
        return phoneserviceno;
    }

    public void setPhoneserviceno(String phoneserviceno) {
        this.phoneserviceno = phoneserviceno;
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

    public String getFamily_linkone_name() {
        return family_linkone_name;
    }

    public void setFamily_linkone_name(String family_linkone_name) {
        this.family_linkone_name = family_linkone_name;
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

    public String getFamily_linktwo_name() {
        return family_linktwo_name;
    }

    public void setFamily_linktwo_name(String family_linktwo_name) {
        this.family_linktwo_name = family_linktwo_name;
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

    public String getContacts_ids() {
        return contacts_ids;
    }

    public void setContacts_ids(String contacts_ids) {
        this.contacts_ids = contacts_ids;
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

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getRecsts() {
        return recsts;
    }

    public void setRecsts(String recsts) {
        this.recsts = recsts;
    }

    public String getIdentity_front() {
        return identity_front;
    }

    public void setIdentity_front(String identity_front) {
        this.identity_front = identity_front;
    }

    public String getIdentity_reverse() {
        return identity_reverse;
    }

    public void setIdentity_reverse(String identity_reverse) {
        this.identity_reverse = identity_reverse;
    }

    public String getCus_photo() {
        return cus_photo;
    }

    public void setCus_photo(String cus_photo) {
        this.cus_photo = cus_photo;
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

    public Integer getFamily_flg() {
        return family_flg;
    }

    public void setFamily_flg(Integer family_flg) {
        this.family_flg = family_flg;
    }

    public Integer getLink_flg() {
        return link_flg;
    }

    public void setLink_flg(Integer link_flg) {
        this.link_flg = link_flg;
    }

    public Integer getIdentity_flg() {
        return identity_flg;
    }

    public void setIdentity_flg(Integer identity_flg) {
        this.identity_flg = identity_flg;
    }

    public Integer getPerson_flg() {
        return person_flg;
    }

    public void setPerson_flg(Integer person_flg) {
        this.person_flg = person_flg;
    }

    public Integer getTaobao_flg() {
        return taobao_flg;
    }

    public void setTaobao_flg(Integer taobao_flg) {
        this.taobao_flg = taobao_flg;
    }

    public Integer getZhifb_flg() {
        return zhifb_flg;
    }

    public void setZhifb_flg(Integer zhifb_flg) {
        this.zhifb_flg = zhifb_flg;
    }

    public Integer getMobile_flg() {
        return mobile_flg;
    }

    public void setMobile_flg(Integer mobile_flg) {
        this.mobile_flg = mobile_flg;
    }

    public Integer getStudent_flg() {
        return student_flg;
    }

    public void setStudent_flg(Integer student_flg) {
        this.student_flg = student_flg;
    }

    public String getIdentity_front_serverId() {
        return identity_front_serverId;
    }

    public void setIdentity_front_serverId(String identity_front_serverId) {
        this.identity_front_serverId = identity_front_serverId;
    }

    public String getIdentity_reverse_serverId() {
        return identity_reverse_serverId;
    }

    public void setIdentity_reverse_serverId(String identity_reverse_serverId) {
        this.identity_reverse_serverId = identity_reverse_serverId;
    }

    public String getCus_photo_serverId() {
        return cus_photo_serverId;
    }

    public void setCus_photo_serverId(String cus_photo_serverId) {
        this.cus_photo_serverId = cus_photo_serverId;
    }

    public String getWorkcard() {
        return workcard;
    }

    public void setWorkcard(String workcard) {
        this.workcard = workcard;
    }

    public String getHttpworkcard() {
        return httpworkcard;
    }

    public void setHttpworkcard(String httpworkcard) {
        this.httpworkcard = httpworkcard;
    }

    public String getIdentity_frontimg() {
        return identity_frontimg;
    }

    public void setIdentity_frontimg(String identity_frontimg) {
        this.identity_frontimg = identity_frontimg;
    }

    public String getIdentity_reverseimg() {
        return identity_reverseimg;
    }

    public void setIdentity_reverseimg(String identity_reverseimg) {
        this.identity_reverseimg = identity_reverseimg;
    }

    public String getCus_photoimg() {
        return cus_photoimg;
    }

    public void setCus_photoimg(String cus_photoimg) {
        this.cus_photoimg = cus_photoimg;
    }

    public String getTaobao_no() {
        return taobao_no;
    }

    public void setTaobao_no(String taobao_no) {
        this.taobao_no = taobao_no;
    }

    public String getTaobao_pass() {
        return taobao_pass;
    }

    public void setTaobao_pass(String taobao_pass) {
        this.taobao_pass = taobao_pass;
    }

    public String getZhifb_no() {
        return zhifb_no;
    }

    public void setZhifb_no(String zhifb_no) {
        this.zhifb_no = zhifb_no;
    }

    public String getZhifb_pass() {
        return zhifb_pass;
    }

    public void setZhifb_pass(String zhifb_pass) {
        this.zhifb_pass = zhifb_pass;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getStudent_pass() {
        return student_pass;
    }

    public void setStudent_pass(String student_pass) {
        this.student_pass = student_pass;
    }

    public List<CusLink> getCusLinkList() {
        return cusLinkList;
    }

    public void setCusLinkList(List<CusLink> cusLinkList) {
        this.cusLinkList = cusLinkList;
    }

    public String getLinksJson() {
        return linksJson;
    }

    public void setLinksJson(String linksJson) {
        this.linksJson = linksJson;
        List<CusLink> links = JSONArray.parseArray(linksJson, CusLink.class);
        this.setCusLinkList(links);
    }

    public String getLink_ids() {
        return link_ids;
    }

    public void setLink_ids(String link_ids) {
        this.link_ids = link_ids;
    }

    public String getShipaddress() {
        return shipaddress;
    }

    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress;
    }

    public String getZhimfvideo() {
        return zhimfvideo;
    }

    public void setZhimfvideo(String zhimfvideo) {
        this.zhimfvideo = zhimfvideo;
    }

    public String getHttpzhimfvideo() {
        return httpzhimfvideo;
    }

    public void setHttpzhimfvideo(String httpzhimfvideo) {
        this.httpzhimfvideo = httpzhimfvideo;
    }
}

