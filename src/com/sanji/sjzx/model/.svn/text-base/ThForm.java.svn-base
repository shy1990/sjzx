package com.sanji.sjzx.model;

import java.math.BigDecimal;
import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class ThForm extends Base{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private Date createTime;

    private String orderId;

    private BigDecimal money;

    private String status;

    private String abortReason;

    private String qhFormId;

    private String remark;

    private String readUserId;
    
    private String expressNumber;
    

	//以下是关联字段
    private String username;
    private String mobile;
    private String shipStatus;
    private String userId;
    private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	//辅助字段
    private String ordernum;
    
   
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
    public String getShipStatus() {
		return shipStatus;
	}


	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
    

    public String getOrdernum() {
		return ordernum;
	}


	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum == null ? null : ordernum.trim();
		this.expressNumber = expressNumber  == null ? null : ordernum+"-"+expressNumber.trim();
	}

    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAbortReason() {
        return abortReason;
    }

    public void setAbortReason(String abortReason) {
        this.abortReason = abortReason == null ? null : abortReason.trim();
    }

    public String getQhFormId() {
        return qhFormId;
    }

    public void setQhFormId(String qhFormId) {
        this.qhFormId = qhFormId == null ? null : qhFormId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getReadUserId() {
        return readUserId;
    }

    public void setReadUserId(String readUserId) {
        this.readUserId = readUserId == null ? null : readUserId.trim();
    }
    
    public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		   
			this.expressNumber = expressNumber  == null ? null : expressNumber.trim();
		
	}
}