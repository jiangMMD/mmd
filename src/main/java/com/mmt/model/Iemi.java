package com.mmt.model;

public class Iemi {

    private Long imei_id;
    private Integer state;
    private String imei_no;
    private String crtdate;
    private String product_name;
    private String agency_id;
    private String agency_name;
    private String agency_city;
    private String cus_name;
    private String cus_identity;
    private String crtuser;


    public Long getImei_id() {
        return imei_id;
    }

    public void setImei_id(Long imei_id) {
        this.imei_id = imei_id;
    }

    public String getImei_no() {
        return imei_no;
    }

    public void setImei_no(String imei_no) {
        this.imei_no = imei_no;
    }

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_identity() {
        return cus_identity;
    }

    public void setCus_identity(String cus_identity) {
        this.cus_identity = cus_identity;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAgency_city() {
        return agency_city;
    }

    public void setAgency_city(String agency_city) {
        this.agency_city = agency_city;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
    }

}
