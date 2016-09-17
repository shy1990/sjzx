package com.sanji.sjzx.model;

import java.math.BigDecimal;
import java.util.Date;

import com.sanji.sjzx.pojo.Base;

public class Admin extends Base{
    private String id;

    private String username;

    private String password;

    private BigDecimal type;

    private Date createtime;

    private Date modifytime;

    private String disabled;

    private String truename;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String email;

    private String telephone;

    private String mobilephone;

    private String address;

    private String userId;

    private String remark;
    
    private String userUrl;
    
    private String userNum;
    
    private String ywId;
    
    private String roleName;//扩展字段，为了显示
    
    private String roleId;//扩展字段，为了显示
    
    private String arId;//扩展字段，为了显示
    
    public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the arId
	 */
	public String getArId() {
		return arId;
	}

	/**
	 * @param arId the arId to set
	 */
	public void setArId(String arId) {
		this.arId = arId;
	}

	/**
	 * @return the userUrl
	 */
	public String getUserUrl() {
		return userUrl;
	}

	/**
	 * @param userUrl the userUrl to set
	 */
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	/**
	 * @return the userNum
	 */
	public String getUserNum() {
		return userNum;
	}

	/**
	 * @param userNum the userNum to set
	 */
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
    
	
}