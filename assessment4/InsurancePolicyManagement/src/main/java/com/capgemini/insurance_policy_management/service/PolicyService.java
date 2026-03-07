package com.capgemini.insurance_policy_management.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capgemini.insurance_policy_management.dto.PolicyRequestDTO;
import com.capgemini.insurance_policy_management.dto.PolicyResponseDTO;
import com.capgemini.insurance_policy_management.entity.Customer;
import com.capgemini.insurance_policy_management.entity.Policy;
import com.capgemini.insurance_policy_management.entity.PolicyStatus;
import com.capgemini.insurance_policy_management.entity.PolicyType;
import com.capgemini.insurance_policy_management.exception.CustomerNotFoundException;
import com.capgemini.insurance_policy_management.exception.PolicyNotFoundException;
import com.capgemini.insurance_policy_management.mapper.PolicyMapper;
import com.capgemini.insurance_policy_management.repository.CustomerRepository;
import com.capgemini.insurance_policy_management.repository.PolicyRepository;

@Service
public class PolicyService {
	
	private final CustomerRepository customerRepository;
	private final PolicyRepository policyRepository;
	private final PolicyMapper policyMapper;
	
	public PolicyService(PolicyRepository policyRepository, PolicyMapper policyMapper,CustomerRepository customerRepository) {
		super();
		this.policyRepository = policyRepository;
		this.policyMapper = policyMapper;
		this.customerRepository=customerRepository;
	}
	
	public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
		Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + dto.getCustomerId()));
        Policy policy = policyMapper.toEntity(dto);
        policy.setCustomer(customer);
        policy.setStatus(PolicyStatus.ACTIVE);
        Policy savedPolicy = policyRepository.save(policy);
        return policyMapper.toDto(savedPolicy);
	}
	
	public Page<PolicyResponseDTO> getAllPolicies(Pageable pageable) {
		return policyRepository.findAll(pageable)
				.map(policyMapper::toDto);
	}
	
	public PolicyResponseDTO getPolicyById(Long id) {
		Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        return policyMapper.toDto(policy);
	}
	
	public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {
        Policy existingPolicy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        existingPolicy.setPolicyNumber(dto.getPolicyNumber());
        existingPolicy.setPolicyType(PolicyType.valueOf(dto.getPolicyType().toUpperCase()));
        existingPolicy.setPremiumAmount(dto.getPremiumAmount());
        existingPolicy.setCoverageAmount(dto.getCoverageAmount());
        existingPolicy.setStartDate(dto.getStartDate());
        existingPolicy.setEndDate(dto.getEndDate());
        if (!existingPolicy.getCustomer().getId().equals(dto.getCustomerId())) {
            Customer newCustomer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + dto.getCustomerId()));
            existingPolicy.setCustomer(newCustomer);
        }
        Policy updatedPolicy = policyRepository.save(existingPolicy);
        return policyMapper.toDto(updatedPolicy);
    }
	
	public void cancelPolicy(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        policy.setStatus(PolicyStatus.CANCELLED);
        policyRepository.save(policy);
    }
	
	public List<PolicyResponseDTO> getPoliciesByType(String type) {
        PolicyType policyType = PolicyType.valueOf(type.toUpperCase());
        List<Policy> policies = policyRepository.findByPolicyType(policyType);
        return policies.stream()
                .map(policyMapper::toDto)
                .collect(Collectors.toList());
    }
	
	public List<PolicyResponseDTO> getPoliciesByPremiumRange(Double min, Double max) {
        List<Policy> policies = policyRepository.findByPremiumAmountBetween(min, max);
        return policies.stream()
                .map(policyMapper::toDto)
                .collect(Collectors.toList());
    }
	
	public List<PolicyResponseDTO> getPoliciesByCustomerEmail(String email) {
		List<Policy> policies = policyRepository.findPoliciesByCustomerEmail(email);
		return policies.stream()
				.map(policyMapper::toDto)
				.collect(Collectors.toList());
	}
	

}
