package com.swinglife.model;

public class ModelField {

	Integer id;
	String name;
	String type;
	String remark;
	String columnName;
	Integer idAuto;
	Integer isNull;
	Integer modelId;
	Integer isAccess;
	Integer isBack;
	Integer isAddEdit;
	String upName;

	public String getUpName() {
		return upName;
	}

	public void setUpName(String upName) {
		this.upName = upName;
	}

	public Integer getIsAddEdit() {
		return isAddEdit;
	}

	public void setIsAddEdit(Integer isAddEdit) {
		this.isAddEdit = isAddEdit;
	}

	public Integer getIsAccess() {
		return isAccess;
	}

	public void setIsAccess(Integer isAccess) {
		this.isAccess = isAccess;
	}

	public Integer getIsBack() {
		return isBack;
	}

	public void setIsBack(Integer isBack) {
		this.isBack = isBack;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}

	public Integer getIsNull() {
		return isNull;
	}

	public void setIsNull(Integer isNull) {
		this.isNull = isNull;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
