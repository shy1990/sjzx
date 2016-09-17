package com.sanji.sjzx.model;

import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class RegionsPrice extends Base{
    /**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String goodsSkuId;
    			   
    private String regionsId;

    private String floatPrice;

    private Date createTime;

    private String userId;

    private String disabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(String goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getFloatPrice() {
        return floatPrice;
    }

    public void setFloatPrice(String floatPrice) {
        this.floatPrice = floatPrice;
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
        this.userId = userId;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

	public String getRegionsId() {
		return regionsId;
	}

	public void setRegionsId(String regionsId) {
		this.regionsId = regionsId;
	}
    
    
}