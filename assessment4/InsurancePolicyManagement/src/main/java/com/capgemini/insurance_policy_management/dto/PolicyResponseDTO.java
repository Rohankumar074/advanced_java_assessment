package com.capgemini.insurance_policy_management.dto;

public class PolicyResponseDTO {

	private Long id;
    private String policyNumber;
    private String policyType;
    private Double premiumAmount;
    private CustomerResponseDTO customer;
    
       
	public PolicyResponseDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public Double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public CustomerResponseDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerResponseDTO customer) {
		this.customer = customer;
	}
    
}
