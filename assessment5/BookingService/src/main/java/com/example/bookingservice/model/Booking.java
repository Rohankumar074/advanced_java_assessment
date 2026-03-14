package com.example.bookingservice.model;

public class Booking {
	
	private Integer bookingId;
    private Integer movieId;
    private Integer tickets;
    private Integer totalAmount;
    private String status;
    
    
	public Booking() {
		super();
	}


	public Booking(Integer bookingId, Integer movieId, Integer tickets, Integer totalAmount, String status) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.tickets = tickets;
		this.totalAmount = totalAmount;
		this.status = status;
	}


	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}


	public Integer getMovieId() {
		return movieId;
	}


	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}


	public Integer getTickets() {
		return tickets;
	}


	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}


	public Integer getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
    
    

}
