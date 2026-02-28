package com.capgemini.MovieManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.MovieManagementSystem.model.Movie;
import com.capgemini.MovieManagementSystem.service.MovieService;

@Controller // [cite: 19]
@RequestMapping("/movies") // [cite: 20]
public class MovieController {

    @Autowired
    private MovieService movieService;

    // GET → Fetch data (Read Movies) [cite: 40, 53]
    @GetMapping // [cite: 21]
    public String viewHomePage(Model model) {
        model.addAttribute("listMovies", movieService.getAllMovies());
        return "movie-list"; // Rendered Thymeleaf page [cite: 51]
    }

    // Accept movie details from a form (Create Movie) [cite: 38, 39]
    @GetMapping("/showNewMovieForm") // [cite: 21]
    public String showNewMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    // POST → Submit data [cite: 54]
    @PostMapping("/save") // [cite: 22]
    public String saveMovie(@ModelAttribute("movie") Movie movie) { // [cite: 24]
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Fetch movie by ID and allow modification (Update Movie) [cite: 43, 44, 45]
    @GetMapping("/showFormForUpdate/{id}") // [cite: 21]
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) { // [cite: 23]
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    // PUT → Update data [cite: 55]
    @PutMapping("/update/{id}")
    public String updateMovie(@PathVariable(value = "id") Integer id, @ModelAttribute("movie") Movie movie) {
        movie.setId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // DELETE → Delete data by ID and redirect [cite: 46, 47, 48, 56]
    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable(value = "id") Integer id) { // [cite: 23]
        movieService.deleteMovie(id);
        return "redirect:/movies"; // [cite: 48]
    }
}