package com.capgemini.online_order_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.online_order_management_system.model.OrderItem;

public interface OrderRepository extends JpaRepository<OrderItem, Long> {

}
