package com.sanji.sjzx.model;

import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class MembersGoodsShow extends Base {
    private String id;

    private String membersId;

    private String skuId;

    private Date createTime;

    private String userId;

    private String disabled;
    
    //关联字段
    private String skuIds;

    public String getSkuIds() {
		return skuIds;
	}

	public void setSkuIds(String skuIds) {
		this.skuIds = skuIds;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMembersId() {
        return membersId;
    }

    public void setMembersId(String membersId) {
        this.membersId = membersId == null ? null : membersId.trim();
    }

    public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }
}