package com.infi.moviecinema.service;

import java.util.List;

import com.infi.moviecinema.dto.MovieDTO;
import com.infi.moviecinema.dto.RatingDTO;

public interface MovieService {
    MovieDTO addMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies();
    RatingDTO rateMovie(RatingDTO ratingDTO);
    MovieDTO getMovieById(Long id);
    List<MovieDTO> searchMovies(String name);
    List<MovieDTO> filterMovies(String genre, Double rating, String language);
}

