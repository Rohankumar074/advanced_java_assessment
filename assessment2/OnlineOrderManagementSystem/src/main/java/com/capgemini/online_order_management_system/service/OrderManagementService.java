package com.capgemini.online_order_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.online_order_management_system.model.Customer;
import com.capgemini.online_order_management_system.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderManagementService {
	
	private final CustomerRepository customerRepository;

    public OrderManagementService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

}
