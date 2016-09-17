package com.sanji.sjzx.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.sanji.sjzx.pojo.Base;

public class Goods extends Base{
    /**
	 * @Fields serialVersionUID:TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	
    private String id;

    private String name;

    private String goodsNum;

    private String type;

    private String disabled;

    private Timestamp createTime;

    private Timestamp modifyTime;

    private String userId;

    private String brandId;

    private String catId;

    private Float screenSize;

    private String resolution;

    private String ram;

    private String cpuNumber;

    private String cpuRate;

    private String frontCamera;

    private String postCamera;

    private String tmallUrl;

    private String defaultImg;

    private Date exposureDate;

    private String touchscreenType;

    private String sreenPixDensity;

    private String screenTechnology;

    private String narrowFrame;

    private String screenRatio;

    private String theoryRate;

    private String wlanFunction;

    private String navigation;

    private String connectionShare;

    private String operationSystem;

    private String memoryCard;

    private String batteryType;

    private String batteryCapacity;

    private String talkTime;

    private String userInterface;

    private String extendedCapacity;

    private String camera;

    private String cameraType;

    private String cameraCertification;

    private String sensorType;

    private String flashLamp;

    private String videoShoot;

    private String shootFunction;

    private String aperture;

    private String focalLength;

    private String cameraFeatures;

    private String cameraOtherparams;

    private String modelDesign;

    private String weight;

    private String bodyFeatures;

    private String operationType;

    private String outSensorType;

    private String simType;

    private String bodyInterface;

    private String bodyMaterial;

    private String audioSupport;

    private String videoSupport;

    private String imgSupport;

    private String commonFunctions;

    private String businessFunctions;

    private String optionalAccessory;

    private String warrantyPolicy;

    private Integer warrantyTime;

    private String warrantyRemark;

    private String servicePhone;

    private String phoneRemark;

    private String detailContents;

    private String cellphoneType;

    private String cpuModel;

    private String gpuModel;

    private String theoryStandbyTime;

    private String cellphoneSize;

    private String clickRate;

    private String goodsDetail;
    
    private String isShellingSupplier;
    	        
		//新增关联查询时需要用到的字段
	    private String userName;//操作人
	    private String brandName;//品牌名称
	    private String catName;//类别名称
	    private String skuNum;//规格代码
	    private String colorName;//规格代码
	    
	    //private Double price;//单品价格
	    private String stock;//单品库存
	    private List<GoodsSku> goodsSkus;//单品数组 
	    //为实现业务而添加的属性
	    private String pstring;
	    private String exposure;
	    
	    public String getIsShellingSupplier() {
			return isShellingSupplier;
		}

		public void setIsShellingSupplier(String isShellingSupplier) {
			this.isShellingSupplier = isShellingSupplier;
		}
	    //新增字段
	    private String isQuotationHot;//是否报价热销

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

	    public String getGoodsNum() {
	        return goodsNum;
	    }

	    public void setGoodsNum(String goodsNum) {
	        this.goodsNum = goodsNum == null ? null : goodsNum.trim();
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type == null ? null : type.trim();
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

	    public String getBrandId() {
	        return brandId;
	    }

	    public void setBrandId(String brandId) {
	        this.brandId = brandId == null ? null : brandId.trim();
	    }

	    public String getCatId() {
	        return catId;
	    }

	    public void setCatId(String catId) {
	        this.catId = catId == null ? null : catId.trim();
	    }

	    /*public String getScreenSize() {
	        return screenSize;
	    }

	    public void setScreenSize(String screenSize) {
	        this.screenSize = screenSize == null ? null : screenSize.trim();
	    }*/
	    

	    public String getResolution() {
	        return resolution;
	    }

	    public Float getScreenSize() {
			return screenSize;
		}

		public void setScreenSize(String screenSize) {
			this.screenSize = screenSize == null ? null : Float.parseFloat(screenSize.trim());
		}

		public void setResolution(String resolution) {
	        this.resolution = resolution == null ? null : resolution.trim();
	    }

	    public String getRam() {
	        return ram;
	    }

	    public void setRam(String ram) {
	        this.ram = ram == null ? null : ram.trim();
	    }

	    public String getCpuNumber() {
	        return cpuNumber;
	    }

	    public void setCpuNumber(String cpuNumber) {
	        this.cpuNumber = cpuNumber == null ? null : cpuNumber.trim();
	    }

	    public String getCpuRate() {
	        return cpuRate;
	    }

	    public void setCpuRate(String cpuRate) {
	        this.cpuRate = cpuRate == null ? null : cpuRate.trim();
	    }

	    public String getFrontCamera() {
	        return frontCamera;
	    }

	    public void setFrontCamera(String frontCamera) {
	        this.frontCamera = frontCamera == null ? null : frontCamera.trim();
	    }

	    public String getPostCamera() {
	        return postCamera;
	    }

	    public void setPostCamera(String postCamera) {
	        this.postCamera = postCamera == null ? null : postCamera.trim();
	    }

	    public String getTmallUrl() {
	        return tmallUrl;
	    }

	    public void setTmallUrl(String tmallUrl) {
	        this.tmallUrl = tmallUrl == null ? null : tmallUrl.trim();
	    }

	    public String getDefaultImg() {
	        return defaultImg;
	    }

	    public void setDefaultImg(String defaultImg) {
	        this.defaultImg = defaultImg == null ? null : defaultImg.trim();
	    }

	    public String getTouchscreenType() {
	        return touchscreenType;
	    }

	    public void setTouchscreenType(String touchscreenType) {
	        this.touchscreenType = touchscreenType == null ? null : touchscreenType.trim();
	    }
	    
	    

	    public String getScreenTechnology() {
	        return screenTechnology;
	    }

	    public void setScreenTechnology(String screenTechnology) {
	        this.screenTechnology = screenTechnology == null ? null : screenTechnology.trim();
	    }

	    public String getNarrowFrame() {
	        return narrowFrame;
	    }

	    public void setNarrowFrame(String narrowFrame) {
	        this.narrowFrame = narrowFrame == null ? null : narrowFrame.trim();
	    }

	    public String getScreenRatio() {
	        return screenRatio;
	    }

	    public void setScreenRatio(String screenRatio) {
	        this.screenRatio = screenRatio == null ? null : screenRatio.trim();
	    }

	    public String getTheoryRate() {
	        return theoryRate;
	    }

	    public void setTheoryRate(String theoryRate) {
	        this.theoryRate = theoryRate == null ? null : theoryRate.trim();
	    }

	    public String getWlanFunction() {
	        return wlanFunction;
	    }

	    public void setWlanFunction(String wlanFunction) {
	        this.wlanFunction = wlanFunction == null ? null : wlanFunction.trim();
	    }

	    public String getNavigation() {
	        return navigation;
	    }

	    public void setNavigation(String navigation) {
	        this.navigation = navigation == null ? null : navigation.trim();
	    }

	    public String getConnectionShare() {
	        return connectionShare;
	    }

	    public void setConnectionShare(String connectionShare) {
	        this.connectionShare = connectionShare == null ? null : connectionShare.trim();
	    }

	    public String getOperationSystem() {
	        return operationSystem;
	    }

	    public void setOperationSystem(String operationSystem) {
	        this.operationSystem = operationSystem == null ? null : operationSystem.trim();
	    }

	    public String getMemoryCard() {
	        return memoryCard;
	    }

	    public void setMemoryCard(String memoryCard) {
	        this.memoryCard = memoryCard == null ? null : memoryCard.trim();
	    }

	    public String getBatteryType() {
	        return batteryType;
	    }

	    public void setBatteryType(String batteryType) {
	        this.batteryType = batteryType == null ? null : batteryType.trim();
	    }

	    public String getBatteryCapacity() {
	        return batteryCapacity;
	    }

	    public void setBatteryCapacity(String batteryCapacity) {
	        this.batteryCapacity = batteryCapacity == null ? null : batteryCapacity.trim();
	    }

	    public String getTalkTime() {
	        return talkTime;
	    }

	    public void setTalkTime(String talkTime) {
	        this.talkTime = talkTime == null ? null : talkTime.trim();
	    }

	    public String getUserInterface() {
	        return userInterface;
	    }

	    public void setUserInterface(String userInterface) {
	        this.userInterface = userInterface == null ? null : userInterface.trim();
	    }

	    public String getExtendedCapacity() {
	        return extendedCapacity;
	    }

	    public void setExtendedCapacity(String extendedCapacity) {
	        this.extendedCapacity = extendedCapacity == null ? null : extendedCapacity.trim();
	    }

	    public String getCamera() {
	        return camera;
	    }

	    public void setCamera(String camera) {
	        this.camera = camera == null ? null : camera.trim();
	    }

	    public String getCameraType() {
	        return cameraType;
	    }

	    public void setCameraType(String cameraType) {
	        this.cameraType = cameraType == null ? null : cameraType.trim();
	    }

	    public String getCameraCertification() {
	        return cameraCertification;
	    }

	    public void setCameraCertification(String cameraCertification) {
	        this.cameraCertification = cameraCertification == null ? null : cameraCertification.trim();
	    }

	    public String getSensorType() {
	        return sensorType;
	    }

	    public void setSensorType(String sensorType) {
	        this.sensorType = sensorType == null ? null : sensorType.trim();
	    }

	    public String getFlashLamp() {
	        return flashLamp;
	    }

	    public void setFlashLamp(String flashLamp) {
	        this.flashLamp = flashLamp == null ? null : flashLamp.trim();
	    }

	    public String getVideoShoot() {
	        return videoShoot;
	    }

	    public void setVideoShoot(String videoShoot) {
	        this.videoShoot = videoShoot == null ? null : videoShoot.trim();
	    }

	    public String getShootFunction() {
	        return shootFunction;
	    }

	    public void setShootFunction(String shootFunction) {
	        this.shootFunction = shootFunction == null ? null : shootFunction.trim();
	    }

	    public String getAperture() {
	        return aperture;
	    }

	    public void setAperture(String aperture) {
	        this.aperture = aperture == null ? null : aperture.trim();
	    }

	    public String getFocalLength() {
	        return focalLength;
	    }

	    public void setFocalLength(String focalLength) {
	        this.focalLength = focalLength == null ? null : focalLength.trim();
	    }

	    public String getCameraFeatures() {
	        return cameraFeatures;
	    }

	    public void setCameraFeatures(String cameraFeatures) {
	        this.cameraFeatures = cameraFeatures == null ? null : cameraFeatures.trim();
	    }

	    public String getCameraOtherparams() {
	        return cameraOtherparams;
	    }

	    public void setCameraOtherparams(String cameraOtherparams) {
	        this.cameraOtherparams = cameraOtherparams == null ? null : cameraOtherparams.trim();
	    }

	    public String getModelDesign() {
	        return modelDesign;
	    }

	    public void setModelDesign(String modelDesign) {
	        this.modelDesign = modelDesign == null ? null : modelDesign.trim();
	    }

	    public String getBodyFeatures() {
	        return bodyFeatures;
	    }

	    public void setBodyFeatures(String bodyFeatures) {
	        this.bodyFeatures = bodyFeatures == null ? null : bodyFeatures.trim();
	    }

	    public String getOperationType() {
	        return operationType;
	    }

	    public void setOperationType(String operationType) {
	        this.operationType = operationType == null ? null : operationType.trim();
	    }

	    public String getOutSensorType() {
	        return outSensorType;
	    }

	    public void setOutSensorType(String outSensorType) {
	        this.outSensorType = outSensorType == null ? null : outSensorType.trim();
	    }

	    public String getSimType() {
	        return simType;
	    }

	    public void setSimType(String simType) {
	        this.simType = simType == null ? null : simType.trim();
	    }

	    public String getBodyInterface() {
	        return bodyInterface;
	    }

	    public void setBodyInterface(String bodyInterface) {
	        this.bodyInterface = bodyInterface == null ? null : bodyInterface.trim();
	    }

	    public String getBodyMaterial() {
	        return bodyMaterial;
	    }

	    public void setBodyMaterial(String bodyMaterial) {
	        this.bodyMaterial = bodyMaterial == null ? null : bodyMaterial.trim();
	    }

	    public String getAudioSupport() {
	        return audioSupport;
	    }

	    public void setAudioSupport(String audioSupport) {
	        this.audioSupport = audioSupport == null ? null : audioSupport.trim();
	    }

	    public String getVideoSupport() {
	        return videoSupport;
	    }

	    public void setVideoSupport(String videoSupport) {
	        this.videoSupport = videoSupport == null ? null : videoSupport.trim();
	    }

	    public String getImgSupport() {
	        return imgSupport;
	    }

	    public void setImgSupport(String imgSupport) {
	        this.imgSupport = imgSupport == null ? null : imgSupport.trim();
	    }

	    public String getCommonFunctions() {
	        return commonFunctions;
	    }

	    public void setCommonFunctions(String commonFunctions) {
	        this.commonFunctions = commonFunctions == null ? null : commonFunctions.trim();
	    }

	    public String getBusinessFunctions() {
	        return businessFunctions;
	    }

	    public void setBusinessFunctions(String businessFunctions) {
	        this.businessFunctions = businessFunctions == null ? null : businessFunctions.trim();
	    }

	    public String getOptionalAccessory() {
	        return optionalAccessory;
	    }

	    public void setOptionalAccessory(String optionalAccessory) {
	        this.optionalAccessory = optionalAccessory == null ? null : optionalAccessory.trim();
	    }

	    public String getWarrantyPolicy() {
	        return warrantyPolicy;
	    }

	    public void setWarrantyPolicy(String warrantyPolicy) {
	        this.warrantyPolicy = warrantyPolicy == null ? null : warrantyPolicy.trim();
	    }
	    public Integer getWarrantyTime() {
			return warrantyTime;
		}

		public void setWarrantyTime(Integer warrantyTime) {
			this.warrantyTime = warrantyTime;
		}

		public String getWarrantyRemark() {
	        return warrantyRemark;
	    }

	    public void setWarrantyRemark(String warrantyRemark) {
	        this.warrantyRemark = warrantyRemark == null ? null : warrantyRemark.trim();
	    }

	    public String getServicePhone() {
	        return servicePhone;
	    }

	    public void setServicePhone(String servicePhone) {
	        this.servicePhone = servicePhone == null ? null : servicePhone.trim();
	    }

	    public String getPhoneRemark() {
	        return phoneRemark;
	    }

	    public void setPhoneRemark(String phoneRemark) {
	        this.phoneRemark = phoneRemark == null ? null : phoneRemark.trim();
	    }

	    public String getDetailContents() {
	        return detailContents;
	    }

	    public void setDetailContents(String detailContents) {
	        this.detailContents = detailContents == null ? null : detailContents.trim();
	    }

	    public String getGoodsDetail() {
	        return goodsDetail;
	    }

	    public void setGoodsDetail(String goodsDetail) {
	        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
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

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public List<GoodsSku> getGoodsSkus() {
			return goodsSkus;
		}

		public String getStock() {
			return stock;
		}

		public void setStock(String stock) {
			this.stock = stock;
		}

		public void setGoodsSkus(List<GoodsSku> goodsSkus) {
			this.goodsSkus = goodsSkus;
		}

		public String getPstring() {
			return pstring;
		}

		public void setPstring(String pstring) {
			this.pstring = pstring;
		}

		public String getCellphoneType() {
			return cellphoneType;
		}

		public void setCellphoneType(String cellphoneType) {
			this.cellphoneType = cellphoneType;
		}

		public String getCpuModel() {
			return cpuModel;
		}

		public void setCpuModel(String cpuModel) {
			this.cpuModel = cpuModel;
		}

		public String getGpuModel() {
			return gpuModel;
		}

		public void setGpuModel(String gpuModel) {
			this.gpuModel = gpuModel;
		}

		public String getTheoryStandbyTime() {
			return theoryStandbyTime;
		}

		public void setTheoryStandbyTime(String theoryStandbyTime) {
			this.theoryStandbyTime = theoryStandbyTime;
		}

		public String getCellphoneSize() {
			return cellphoneSize;
		}

		public void setCellphoneSize(String cellphoneSize) {
			this.cellphoneSize = cellphoneSize;
		}

		public String getClickRate() {
			return clickRate;
		}

		public void setClickRate(String clickRate) {
			this.clickRate = clickRate;
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

		public String getSreenPixDensity() {
			return sreenPixDensity;
		}

		public void setSreenPixDensity(String sreenPixDensity) {
			this.sreenPixDensity = sreenPixDensity;
		}

		/**
		 * @return the skuNum
		 */
		public String getSkuNum() {
			return skuNum;
		}

		/**
		 * @param skuNum the skuNum to set
		 */
		public void setSkuNum(String skuNum) {
			this.skuNum = skuNum;
		}

		/**
		 * @return the colorName
		 */
		public String getColorName() {
			return colorName;
		}

		/**
		 * @param colorName the colorName to set
		 */
		public void setColorName(String colorName) {
			this.colorName = colorName;
		}

		public Date getExposureDate() {
			return exposureDate;
		}

		public void setExposureDate(Date exposureDate) {
			this.exposureDate = exposureDate;
		}

		public String getExposure() {
			return exposure;
		}

		public void setExposure(String exposure) {
			this.exposure = exposure;
		}

		public String getIsQuotationHot() {
			return isQuotationHot;
		}

		public void setIsQuotationHot(String isQuotationHot) {
			this.isQuotationHot = isQuotationHot;
		}

}