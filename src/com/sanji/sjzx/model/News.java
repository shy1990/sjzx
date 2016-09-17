package com.sanji.sjzx.model;

import java.util.Date;

import com.sanji.sjzx.pojo.Base;


public class News extends Base{
	private static final long serialVersionUID = 1L;

	private String id;

    private String firstTitle;

    private String newsCatId;

    private Date createtime;

    private Date modifytime;

    private String secondTitle;

    private String disabled;

    private String userId;

    private String status;

    private String resources;

    private String keywords;

    private String description;

    private String author;

    private String newsattr;

    private String content;
    
    private String newsPic;

    private String newsCatName;
    
    private Integer isCallCenter; //是否是客服中心添加的数据
    
    private String newsCatPid;//扩展字段,前台显示用
    
    private Integer viewnum;// 阅读次数

    private String kz1;

    private String kz2;

    private String kz3;

    private String kz4;

    private String kz5;

    private String kz6;

    private String kz7;

    private String kz9;

    private String kz10;

    private String kz11;

    private String kz12;

    private String kz13;

    private String kz14;

    public String getKz1() {
		return kz1;
	}

	public void setKz1(String kz1) {
		this.kz1 = kz1;
	}

	public String getKz2() {
		return kz2;
	}

	public void setKz2(String kz2) {
		this.kz2 = kz2;
	}

	public String getKz3() {
		return kz3;
	}

	public void setKz3(String kz3) {
		this.kz3 = kz3;
	}

	public String getKz4() {
		return kz4;
	}

	public void setKz4(String kz4) {
		this.kz4 = kz4;
	}

	public String getKz5() {
		return kz5;
	}

	public void setKz5(String kz5) {
		this.kz5 = kz5;
	}

	public String getKz6() {
		return kz6;
	}

	public void setKz6(String kz6) {
		this.kz6 = kz6;
	}

	public String getKz7() {
		return kz7;
	}

	public void setKz7(String kz7) {
		this.kz7 = kz7;
	}

	public String getKz9() {
		return kz9;
	}

	public void setKz9(String kz9) {
		this.kz9 = kz9;
	}

	public String getKz10() {
		return kz10;
	}

	public void setKz10(String kz10) {
		this.kz10 = kz10;
	}

	public String getKz11() {
		return kz11;
	}

	public void setKz11(String kz11) {
		this.kz11 = kz11;
	}

	public String getKz12() {
		return kz12;
	}

	public void setKz12(String kz12) {
		this.kz12 = kz12;
	}

	public String getKz13() {
		return kz13;
	}

	public void setKz13(String kz13) {
		this.kz13 = kz13;
	}

	public String getKz14() {
		return kz14;
	}

	public void setKz14(String kz14) {
		this.kz14 = kz14;
	}

	/**
	 * @return the isCallCenter
	 */
	public Integer getIsCallCenter() {
		return isCallCenter;
	}

	/**
	 * @param isCallCenter the isCallCenter to set
	 */
	public void setIsCallCenter(Integer isCallCenter) {
		this.isCallCenter = isCallCenter;
	}

	/**
	 * @return the newsCatPid
	 */
	public String getNewsCatPid() {
		return newsCatPid;
	}

	/**
	 * @param newsCatPid the newsCatPid to set
	 */
	public void setNewsCatPid(String newsCatPid) {
		this.newsCatPid = newsCatPid;
	}

	/**
	 * @return the newsCatName
	 */
	public String getNewsCatName() {
		return newsCatName;
	}

	/**
	 * @param newsCatName the newsCatName to set
	 */
	public void setNewsCatName(String newsCatName) {
		this.newsCatName = newsCatName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle == null ? null : firstTitle.trim();
    }

    public String getNewsCatId() {
        return newsCatId;
    }

    public void setNewsCatId(String newsCatId) {
        this.newsCatId = newsCatId == null ? null : newsCatId.trim();
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

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle == null ? null : secondTitle.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources == null ? null : resources.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getNewsattr() {
        return newsattr;
    }

    public void setNewsattr(String newsattr) {
        this.newsattr = newsattr == null ? null : newsattr.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    
    /**
	 * @return the newsPic
	 */
	public String getNewsPic() {
		return newsPic;
	}

	/**
	 * @param newsPic the newsPic to set
	 */
	public void setNewsPic(String newsPic) {
		this.newsPic = newsPic;
	}

	public Integer getViewnum() {
		return viewnum;
	}

	public void setViewnum(Integer viewnum) {
		this.viewnum = viewnum;
	}
	
}