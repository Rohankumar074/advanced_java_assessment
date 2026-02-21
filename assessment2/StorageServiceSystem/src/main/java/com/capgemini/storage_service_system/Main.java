package com.capgemini.storage_service_system;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("--- Starting Application Context ---");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        System.out.println("\n--- Application Context Loaded ---");

        System.out.println("\nFetching Default Storage Provider:");
        StorageService defaultStorage = context.getBean(StorageService.class);
        defaultStorage.storeFile("document.pdf");

        System.out.println("\nFetching LocalStorage Provider (1st time):");
        StorageService localStorage1 = (StorageService) context.getBean("localStorage");
        localStorage1.storeFile("image1.png");

        System.out.println("\nFetching LocalStorage Provider (2nd time):");
        StorageService localStorage2 = (StorageService) context.getBean("localStorage");
        localStorage2.storeFile("image2.png");

        System.out.println("\n--- Closing Application Context ---");
        context.close();
	}

}
