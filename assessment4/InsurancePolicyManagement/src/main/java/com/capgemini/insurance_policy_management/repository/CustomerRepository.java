package com.capgemini.insurance_policy_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.insurance_policy_management.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
