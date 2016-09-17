package com.sanji.sjzx.model;

import java.util.List;

public class AdminInfoMsg {
    private String id;

    private String userId;

    private String type;

    private String regions;
    
    private List<String> regionsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions == null ? null : regions.trim();
    }

	/**
	 * @return the regionsList
	 */
	public List<String> getRegionsList() {
		return regionsList;
	}

	/**
	 * @param regionsList the regionsList to set
	 */
	public void setRegionsList(List<String> regionsList) {
		this.regionsList = regionsList;
	}
    
    
}