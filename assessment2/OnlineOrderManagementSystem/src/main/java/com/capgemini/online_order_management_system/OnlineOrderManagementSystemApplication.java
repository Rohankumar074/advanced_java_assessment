package com.capgemini.online_order_management_system;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.online_order_management_system.model.Customer;
import com.capgemini.online_order_management_system.model.Order;
import com.capgemini.online_order_management_system.model.OrderItem;
import com.capgemini.online_order_management_system.service.OrderManagementService;

@SpringBootApplication
public class OnlineOrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineOrderManagementSystemApplication.class, args);
		
	}
	
	@Bean
    CommandLineRunner run(OrderManagementService service) {
        return args -> {
            System.out.println("--- Creating Data ---");

            Customer customer = new Customer();
            customer.setCustomerName("Alice Smith");
            customer.setEmail("alice@example.com");

            Order order1 = new Order();
            order1.setOrderDate(LocalDate.now());
            order1.setTotalAmount(1500.00);

            OrderItem item1 = new OrderItem();
            item1.setProductName("Laptop");
            item1.setQuantity(1);
            item1.setPrice(1200.00);

            OrderItem item2 = new OrderItem();
            item2.setProductName("Mouse");
            item2.setQuantity(1);
            item2.setPrice(300.00);

            order1.addOrderItem(item1);
            order1.addOrderItem(item2);

            Order order2 = new Order();
            order2.setOrderDate(LocalDate.now());
            order2.setTotalAmount(200.00);

            OrderItem item3 = new OrderItem();
            item3.setProductName("Keyboard");
            item3.setQuantity(1);
            item3.setPrice(200.00);

            order2.addOrderItem(item3);

            customer.addOrder(order1);
            customer.addOrder(order2);

            service.saveCustomer(customer);
            System.out.println("Data saved successfully!\n");

            System.out.println("--- Fetching Data ---");
            List<Customer> savedCustomers = service.fetchAllCustomers();
            for (Customer c : savedCustomers) {
                System.out.println("Customer: " + c.getCustomerName() + " (" + c.getEmail() + ")");
                for (Order o : c.getOrders()) {
                    System.out.println("  -> Order ID: " + o.getOrderId() + " | Date: " + o.getOrderDate() + " | Total: $" + o.getTotalAmount());
                    for (OrderItem i : o.getOrderItems()) {
                        System.out.println("      -> Item: " + i.getProductName() + " | Qty: " + i.getQuantity() + " | Price: $" + i.getPrice());
                    }
                }
            }
        };
    }
}
