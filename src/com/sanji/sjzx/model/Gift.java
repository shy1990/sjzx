package com.sanji.sjzx.model;

import com.sanji.sjzx.pojo.Base;

public class Gift extends Base{
    /**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String goodsId;

    private String giftId;

    private Double giftPrice;
    
    private String disabled;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId == null ? null : giftId.trim();
    }

	public Double getGiftPrice() {
		return giftPrice;
	}

	public void setGiftPrice(Double giftPrice) {
		this.giftPrice = giftPrice;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

}