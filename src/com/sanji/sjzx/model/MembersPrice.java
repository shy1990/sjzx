package com.sanji.sjzx.model;

import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class MembersPrice extends Base{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String goodsSkuId;

    private String memberId;

    private String floatPrice;

    private Date createTime;

    private String userId;

    private String disabled;
    
    private String price;
    
    private String originalPrice;
    
    private String afterFloatPrice;//调整后价格
    
    private String overMan;//操作人
    
    private String userName;//用户名(商铺名)
    
    private String goodsName;//商品名称
    
    private String totalNum;//订单量
    
    private String itemNum;//订单项
    
    private String currentTime;//当前时间
    
    private String pcat;//行政区域（山东省济南市。。。）
    
    private String colorName;//颜色
    
    private String region;//代表区域代码
    
    
    public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getPcat() {
		return pcat;
	}

	public void setPcat(String pcat) {
		this.pcat = pcat;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getAfterFloatPrice() {
		return afterFloatPrice;
	}

	public void setAfterFloatPrice(String afterFloatPrice) {
		this.afterFloatPrice = afterFloatPrice;
	}

	public String getOverMan() {
		return overMan;
	}

	public void setOverMan(String overMan) {
		this.overMan = overMan;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	

	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(String goodsSkuId) {
        this.goodsSkuId = goodsSkuId == null ? null : goodsSkuId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
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
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }
}