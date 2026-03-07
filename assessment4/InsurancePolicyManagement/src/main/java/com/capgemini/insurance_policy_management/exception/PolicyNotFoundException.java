package com.capgemini.insurance_policy_management.exception;

public class PolicyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PolicyNotFoundException(String msg) {
		super(msg);
	}
	
	

}
