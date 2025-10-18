package com.infi.moviecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infi.moviecinema.dto.MovieDTO;
import com.infi.moviecinema.dto.RatingDTO;
import com.infi.moviecinema.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*") // allow frontend to connect
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // US01: Get all movies
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    // US02: Get movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    // US03: Search movies by name
    @GetMapping("/search")
    public ResponseEntity<List<MovieDTO>> searchMovies(@RequestParam String name) {
        return ResponseEntity.ok(movieService.searchMovies(name));
    }

    // US04: Filter movies
    @GetMapping("/filter")
    public ResponseEntity<List<MovieDTO>> filterMovies(
            @RequestParam String genre,
            @RequestParam Double rating,
            @RequestParam String language) {
        return ResponseEntity.ok(movieService.filterMovies(genre, rating, language));
    }

    // US10: Rate movie
    @PostMapping("/rate")
    public ResponseEntity<RatingDTO> rateMovie(@RequestBody RatingDTO ratingDTO) {
        return ResponseEntity.ok(movieService.rateMovie(ratingDTO));
    }
}
