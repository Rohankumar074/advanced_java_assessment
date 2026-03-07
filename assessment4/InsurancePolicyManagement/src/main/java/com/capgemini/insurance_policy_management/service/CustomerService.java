package com.capgemini.insurance_policy_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capgemini.insurance_policy_management.dto.CustomerRequestDTO;
import com.capgemini.insurance_policy_management.dto.CustomerResponseDTO;
import com.capgemini.insurance_policy_management.entity.Customer;
import com.capgemini.insurance_policy_management.exception.CustomerNotFoundException;
import com.capgemini.insurance_policy_management.mapper.CustomerMapper;
import com.capgemini.insurance_policy_management.repository.CustomerRepository;


@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        Customer customer = customerMapper.toEntity(dto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        return customerMapper.toDto(customer);
    }

}
