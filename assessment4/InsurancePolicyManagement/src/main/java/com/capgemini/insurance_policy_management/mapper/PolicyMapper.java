package com.capgemini.insurance_policy_management.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.insurance_policy_management.dto.PolicyRequestDTO;
import com.capgemini.insurance_policy_management.dto.PolicyResponseDTO;
import com.capgemini.insurance_policy_management.entity.Policy;
import com.capgemini.insurance_policy_management.entity.PolicyType;

@Component
public class PolicyMapper {
	
	@Autowired
	CustomerMapper customerMapper;
	
	public Policy toEntity(PolicyRequestDTO policyRequestDTO) {
		Policy policy=new Policy();
		policy.setPolicyNumber(policyRequestDTO.getPolicyNumber());
		policy.setPolicyType(PolicyType.valueOf(policyRequestDTO.getPolicyType().toUpperCase()));
		policy.setPremiumAmount(policyRequestDTO.getPremiumAmount());
		policy.setCoverageAmount(policyRequestDTO.getCoverageAmount());
		policy.setStartDate(policyRequestDTO.getStartDate());
		policy.setEndDate(policyRequestDTO.getEndDate());
		policy.setId(policyRequestDTO.getCustomerId());
		return policy;		
	}
	
	public PolicyResponseDTO toDto(Policy policy) {
		PolicyResponseDTO policyResponseDTO=new PolicyResponseDTO();
		policyResponseDTO.setId(policy.getId());
		policyResponseDTO.setPolicyNumber(policy.getPolicyNumber());
		policyResponseDTO.setPolicyType(policy.getPolicyType().toString());
		policyResponseDTO.setPremiumAmount(policy.getPremiumAmount());
		policyResponseDTO.setCustomer(customerMapper.toDto(policy.getCustomer()));
		return policyResponseDTO;
	}

}
