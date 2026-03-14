package com.example.bookingservice.model;

public class MovieDTO {
	
	private Integer id;
    private String name;
    private String language;
    private Integer price;
    
    
	public MovieDTO() {
		super();
	}


	public MovieDTO(Integer id, String name, String language, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}
    
    

}
