package com.sanji.sjzx.model;

import com.sanji.sjzx.pojo.Base;

public class Brand extends Base{
  
	private static final long serialVersionUID = 1L;

	private String id;

    private String pid;

    private String name;

    private String pic;

    private String remark;

    private String disabled;

    private Long p_order;

    private Long grade;

    private String ptree;
    
    private String brandId;
    
    private String brandName;

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
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the p_order
	 */
	public Long getP_order() {
		return p_order;
	}

	/**
	 * @param p_order the p_order to set
	 */
	public void setP_order(Long p_order) {
		this.p_order = p_order;
	}

	/**
	 * @return the grade
	 */
	public Long getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Long grade) {
		this.grade = grade;
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

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}