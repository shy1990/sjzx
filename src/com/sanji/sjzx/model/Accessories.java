package com.sanji.sjzx.model;

import java.sql.Timestamp;

import com.sanji.sjzx.pojo.Base;

public class Accessories extends Base{
    /**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String accessoriesNum;

    private String type;

    private String disabled;

    private Timestamp createTime;

    private Timestamp modifyTime;

    private String userId;

    private String price;

    private String originalPrice;

    private String brandId;

    private String catId;

    private String tmallUrl;

    private String tmallPrice;

    private String defaultImg;

    private String batteryCapacity;

    private String accessoriesVersion;

    private String filmType;

    private String material;

    private String styles;

    private String colorId;

    private String accessoriesStyle;

    private String isoriginal;

    private String wearType;

    private String iswire;

    private String stock;

    private String clickRate;

    private String accessoriesDetail;
    
    private String specCode;//新添字段--规格代码
    
    private String userName;//操纵人名称
    private String brandName;//品牌名称
    private String catName;//类别名称
    private String colorName;//颜色名称
    private String goodsId;
    
    private String isshelves;
    private Timestamp shelvesTime;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccessoriesNum() {
		return accessoriesNum;
	}
	public void setAccessoriesNum(String accessoriesNum) {
		this.accessoriesNum = accessoriesNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getTmallUrl() {
		return tmallUrl;
	}
	public void setTmallUrl(String tmallUrl) {
		this.tmallUrl = tmallUrl;
	}
	public String getDefaultImg() {
		return defaultImg;
	}
	public void setDefaultImg(String defaultImg) {
		this.defaultImg = defaultImg;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getAccessoriesVersion() {
		return accessoriesVersion;
	}
	public void setAccessoriesVersion(String accessoriesVersion) {
		this.accessoriesVersion = accessoriesVersion;
	}
	public String getFilmType() {
		return filmType;
	}
	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getStyles() {
		return styles;
	}
	public void setStyles(String styles) {
		this.styles = styles;
	}
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public String getAccessoriesStyle() {
		return accessoriesStyle;
	}
	public void setAccessoriesStyle(String accessoriesStyle) {
		this.accessoriesStyle = accessoriesStyle;
	}
	public String getIsoriginal() {
		return isoriginal;
	}
	public void setIsoriginal(String isoriginal) {
		this.isoriginal = isoriginal;
	}
	public String getWearType() {
		return wearType;
	}
	public void setWearType(String wearType) {
		this.wearType = wearType;
	}
	public String getIswire() {
		return iswire;
	}
	public void setIswire(String iswire) {
		this.iswire = iswire;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getClickRate() {
		return clickRate;
	}
	public void setClickRate(String clickRate) {
		this.clickRate = clickRate;
	}
	public String getAccessoriesDetail() {
		return accessoriesDetail;
	}
	public void setAccessoriesDetail(String accessoriesDetail) {
		this.accessoriesDetail = accessoriesDetail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
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
	public String getTmallPrice() {
		return tmallPrice;
	}
	public void setTmallPrice(String tmallPrice) {
		this.tmallPrice = tmallPrice;
	}
	public String getSpecCode() {
		return specCode;
	}
	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}

	public String getIsshelves() {
		return isshelves;
	}
	public void setIsshelves(String isshelves) {
		this.isshelves = isshelves;
	}
	public Timestamp getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(Timestamp shelvesTime) {
		this.shelvesTime = shelvesTime;
	}
}