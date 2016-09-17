package com.sanji.sjzx.model;

public class Dict {
    private String id;

    private String dictName;

    private String dictValue;

    private String dictGroup;
    
    private String dictId;
    
    private String standard;
    private String netsuitType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictGroup() {
        return dictGroup;
    }

    public void setDictGroup(String dictGroup) {
        this.dictGroup = dictGroup == null ? null : dictGroup.trim();
    }

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getNetsuitType() {
		return netsuitType;
	}

	public void setNetsuitType(String netsuitType) {
		this.netsuitType = netsuitType;
	}
}