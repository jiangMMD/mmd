package com.mmt.model;

/**
 * 产品进出货单
 */
public class Iemi_turnover {

    private Long id;
    private Integer type;
    private String product_name;
    private String imei_ids;
    private String imei_nos;
    private String agency_id;
    private String agency_name;
    private String agency_city;
    private String crtuser;
    private String crtdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImei_ids() {
        return imei_ids;
    }

    public void setImei_ids(String imei_ids) {
        this.imei_ids = imei_ids;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
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

    public String getImei_nos() {
        return imei_nos;
    }

    public void setImei_nos(String imei_nos) {
        this.imei_nos = imei_nos;
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
}
