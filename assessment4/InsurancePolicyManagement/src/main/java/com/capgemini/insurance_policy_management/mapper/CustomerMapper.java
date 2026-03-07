package com.capgemini.insurance_policy_management.mapper;

import org.springframework.stereotype.Component;

import com.capgemini.insurance_policy_management.dto.CustomerRequestDTO;
import com.capgemini.insurance_policy_management.dto.CustomerResponseDTO;
import com.capgemini.insurance_policy_management.entity.Customer;

@Component
public class CustomerMapper {
	
	public Customer toEntity(CustomerRequestDTO customerRequestDTO) {
		Customer customer=new Customer();
		customer.setName(customerRequestDTO.getName());
		customer.setEmail(customerRequestDTO.getEmail());
		customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
		customer.setAddress(customerRequestDTO.getAddress());
		return customer;
	}
	
	public CustomerResponseDTO toDto(Customer customer) {
		CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
		customerResponseDTO.setId(customer.getId());
		customerResponseDTO.setName(customer.getName());
		customerResponseDTO.setEmail(customer.getEmail());
		return customerResponseDTO;
		

	}

}
