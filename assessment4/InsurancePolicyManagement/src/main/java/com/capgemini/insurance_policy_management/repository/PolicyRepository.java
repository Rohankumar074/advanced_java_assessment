package com.capgemini.insurance_policy_management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.insurance_policy_management.entity.Policy;
import com.capgemini.insurance_policy_management.entity.PolicyType;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	
	List<Policy> findByPolicyType(PolicyType policyType);
	
	List<Policy> findByCustomerId(Long customerId);
	
	List<Policy> findByPremiumAmountBetween(Double min, Double max);
	
	@Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
	List<Policy> findPoliciesByCustomerEmail(@Param("email") String email);
	
	
	
}
