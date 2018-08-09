package com.mmt.model;

public class Accessory {

    private Long yid;
    private String identity_front;
    private String identity_reverse;
    private String identity_inhand;
    private String work_card;
    private String student_card;
    private String staff_photo;
    private String bank_card;
    private String taobao_address;
    private String zhifb_zmf;
    private String imei;
    private String contract_photo;
    private String operation_video;
    private String memo_one;
    private String memo_two;
    private String crtuser;
    private String crtdate;
    private String upduser;
    private String upddate;
    private String recsts;

    public Long getYid() {
        return yid;
    }

    public void setYid(Long yid) {
        this.yid = yid;
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

    public String getIdentity_inhand() {
        return identity_inhand;
    }

    public void setIdentity_inhand(String identity_inhand) {
        this.identity_inhand = identity_inhand;
    }

    public String getWork_card() {
        return work_card;
    }

    public void setWork_card(String work_card) {
        this.work_card = work_card;
    }

    public String getStudent_card() {
        return student_card;
    }

    public void setStudent_card(String student_card) {
        this.student_card = student_card;
    }

    public String getStaff_photo() {
        return staff_photo;
    }

    public void setStaff_photo(String staff_photo) {
        this.staff_photo = staff_photo;
    }

    public String getBank_card() {
        return bank_card;
    }

    public void setBank_card(String bank_card) {
        this.bank_card = bank_card;
    }

    public String getTaobao_address() {
        return taobao_address;
    }

    public void setTaobao_address(String taobao_address) {
        this.taobao_address = taobao_address;
    }

    public String getZhifb_zmf() {
        return zhifb_zmf;
    }

    public void setZhifb_zmf(String zhifb_zmf) {
        this.zhifb_zmf = zhifb_zmf;
    }



    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getContract_photo() {
        return contract_photo;
    }

    public void setContract_photo(String contract_photo) {
        this.contract_photo = contract_photo;
    }

    public String getOperation_video() {
        return operation_video;
    }

    public void setOperation_video(String operation_video) {
        this.operation_video = operation_video;
    }

    public String getMemo_one() {
        return memo_one;
    }

    public void setMemo_one(String memo_one) {
        this.memo_one = memo_one;
    }

    public String getMemo_two() {
        return memo_two;
    }

    public void setMemo_two(String memo_two) {
        this.memo_two = memo_two;
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

    @Override
    public String toString() {
        return "Accessory{" +
                "yid=" + yid +
                ", identity_front='" + identity_front + '\'' +
                ", identity_reverse='" + identity_reverse + '\'' +
                ", identity_inhand='" + identity_inhand + '\'' +
                ", work_card='" + work_card + '\'' +
                ", student_card='" + student_card + '\'' +
                ", staff_photo='" + staff_photo + '\'' +
                ", bank_card='" + bank_card + '\'' +
                ", taobao_address='" + taobao_address + '\'' +
                ", zhifb_zmf='" + zhifb_zmf + '\'' +
                ", imei='" + imei + '\'' +
                ", contract_photo='" + contract_photo + '\'' +
                ", operation_video='" + operation_video + '\'' +
                ", memo_one='" + memo_one + '\'' +
                ", memo_two='" + memo_two + '\'' +
                ", crtuser='" + crtuser + '\'' +
                ", crtdate='" + crtdate + '\'' +
                ", upduser='" + upduser + '\'' +
                ", upddate='" + upddate + '\'' +
                ", recsts='" + recsts + '\'' +
                '}';
    }
}
