package com.example.gloQuora.dto;

public class CompanyDto {

	private Long companyId;
	private String name;
	private String location;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CompanyDto [companyId=" + companyId + ", name=" + name + ", location=" + location + "]";
	}

}
