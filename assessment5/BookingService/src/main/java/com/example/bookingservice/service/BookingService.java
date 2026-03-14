package com.example.bookingservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookingservice.client.MovieClient;
import com.example.bookingservice.model.Booking;
import com.example.bookingservice.model.MovieDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookingService {

    @Autowired
    private MovieClient movieClient;

    private final List<Booking> bookings = new ArrayList<>();
    private final Random random = new Random();

    @CircuitBreaker(name = "movieService", fallbackMethod = "fallbackBookTicket")
    public Booking createBooking(Booking bookingRequest) {
        
        MovieDTO movie = movieClient.getMovieById(bookingRequest.getMovieId());

        bookingRequest.setBookingId(random.nextInt(1000) + 100);
        bookingRequest.setTotalAmount(movie.getPrice() * bookingRequest.getTickets());
        bookingRequest.setStatus("SUCCESS");
        
        bookings.add(bookingRequest);
        return bookingRequest;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public Booking fallbackBookTicket(Booking bookingRequest, Throwable throwable) {
        Booking fallbackBooking = new Booking();
        fallbackBooking.setBookingId(null);
        fallbackBooking.setMovieId(bookingRequest.getMovieId());
        fallbackBooking.setTickets(bookingRequest.getTickets());
        fallbackBooking.setStatus("FAILED: Movie Service is currently unavailable (" + throwable.getMessage() + ").");
        return fallbackBooking;
    }
}