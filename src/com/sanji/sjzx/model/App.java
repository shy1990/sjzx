package com.sanji.sjzx.model;

import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class App extends Base{
  
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String pic;

    private String verionNum;

    private String url;

    private Date createTime;

    private Date modifyTime;

    private String userId;

    private String remark;

    private String packName;

    private String type;

    private String nuinstall;

    private String opentime;

    private String serialNumber;
    
    //
    private String userName;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getVerionNum() {
        return verionNum;
    }

    public void setVerionNum(String verionNum) {
        this.verionNum = verionNum == null ? null : verionNum.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName == null ? null : packName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getNuinstall() {
        return nuinstall;
    }

    public void setNuinstall(String nuinstall) {
        this.nuinstall = nuinstall == null ? null : nuinstall.trim();
    }

 	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "id="+id+" name="+name;
	}
    
}