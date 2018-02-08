package com.model;
import java.util.Date;

public class Company {
	private String id;
    private Date registrationDate;
    private String name;
    private String status;
    private String companyClass;
    private String category;
    private String authorizedCapital;
    private String paidupCapital;
    private String state;
    private String registrar;
    private String businessActivity;
    private String officeAddress;
    private String subCategory;
	public String getAuthorizedCapital() {
		return authorizedCapital;
	}
	public String getBusinessActivity() {
		return businessActivity;
	}
	public String getCategory() {
		return category;
	}
	public String getCompanyClass() {
		return companyClass;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public String getPaidupCapital() {
		return paidupCapital;
	}
	public String getRegistrar() {
		return registrar;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public String getState() {
		return state;
	}
	public String getStatus() {
		return status;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setAuthorizedCapital(String authorizedCapital) {
		this.authorizedCapital = authorizedCapital;
	}
	public void setBusinessActivity(String businessActivity) {
		this.businessActivity = businessActivity;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCompanyClass(String companyClass) {
		this.companyClass = companyClass;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setPaidupCapital(String paidupCapital) {
		this.paidupCapital = paidupCapital;
	}
	public void setRegistrar(String registrar) {
		this.registrar = registrar;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", registrationDate=" + registrationDate + ", name=" + name + ", status=" + status
				+ ", companyClass=" + companyClass + ", category=" + category + ", authorizedCapital="
				+ authorizedCapital + ", paidupCapital=" + paidupCapital + ", state=" + state + ", registrar="
				+ registrar + ", businessActivity=" + businessActivity + ", officeAddress=" + officeAddress
				+ ", subCategory=" + subCategory + "]";
	}
	
	
}
