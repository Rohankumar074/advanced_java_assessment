package com.capgemini.storage_service_system;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Scope("prototype")
@Lazy
public class LocalStorageService implements StorageService {
	
	
	/**
	 * 
	 */
	public LocalStorageService() {
		super();
		System.out.println("LocalStorageService Bean Created");
	}

	@Override
	public void storeFile(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("File stored in Local Storage: "+fileName);
		
	}

}
