package com.sanji.sjzx.model;

import java.math.BigDecimal;

import com.sanji.sjzx.pojo.Base;

public class DlyCorp extends Base {
	
    private String id;
    /*物流公司名称*/
    private String name;
    /*类型*/
    private String type;
    /*是否可用*/
    private String disable;
    /*排序*/
    private BigDecimal ordernum;
    /*物流公司网址*/
    private String website;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable == null ? null : disable.trim();
    }

    public BigDecimal getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(BigDecimal ordernum) {
        this.ordernum = ordernum;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }
}