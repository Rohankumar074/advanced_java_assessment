package com.capgemini.MovieManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.MovieManagementSystem.model.Movie;
import com.capgemini.MovieManagementSystem.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listMovies", movieService.getAllMovies());
        return "movie-list";
    }

    @GetMapping("/showNewMovieForm")
    public String showNewMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @PutMapping("/update/{id}")
    public String updateMovie(@PathVariable(value = "id") Integer id, @ModelAttribute("movie") Movie movie) {
        movie.setId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable(value = "id") Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}