package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class AbstractModel {
	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiledDate;
	private String createdBy;
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiledDate() {
		return modifiledDate;
	}

	public void setModifiledDate(Timestamp modifiledDate) {
		this.modifiledDate = modifiledDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
