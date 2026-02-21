package com.capgemini.storage_service_system;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Primary
@Scope("singleton")
public class CloudStorageService implements StorageService {
	
	
	/**
	 * 
	 */
	public CloudStorageService() {
		super();
		System.out.println("CloudStorageService  Bean Created");
	}

	@Override
	public void storeFile(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("File stored in Cloud Storage: "+fileName);
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("CloudStorageService Bean Initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("CloudStorageService Bean Destroyed");
	}

}
