package com.example.movieservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.movieservice.model.Movie;

@Service
public class MovieService {
	
	private final List<Movie> movies = Arrays.asList(
	        new Movie(1, "Inception", "English", 250)
	    );

	    public List<Movie> getAllMovies() {
	        return movies;
	    }

	    public Optional<Movie> getMovieById(int id) {
	        return movies.stream()
	                     .filter(m -> m.getId() == id)
	                     .findFirst();
	    }

}
