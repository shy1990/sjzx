package com.sanji.sjzx.model;

import java.math.BigDecimal;
import java.util.List;

public class Regions {
    private String id;

    private String pid;

    private String ptree;

    private BigDecimal grade;

    private String name;
    
    private String atype;
    
    //辅助字段
    private String isParent;
    
    private String icon;
    
    private boolean open;
    
	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	private String disabled;
    
    private String state = "closed";
    
    private List<Regions> children;
    
    private String url;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the ptree
	 */
	public String getPtree() {
		return ptree;
	}

	/**
	 * @param ptree the ptree to set
	 */
	public void setPtree(String ptree) {
		this.ptree = ptree;
	}

	/**
	 * @return the grade
	 */
	public BigDecimal getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the disabled
	 */
	public String getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = "closed";
	}

	/**
	 * @return the children
	 */
	public List<Regions> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Regions> children) {
		this.children = children;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		String str = "region/regionAction!gainRegionByPid.action?pid="+this.id;
		return str;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
    


    
}