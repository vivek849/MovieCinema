package com.infi.moviecinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infi.moviecinema.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameContainingIgnoreCase(String name);
    List<Movie> findByGenreAndLanguageAndRatingGreaterThanEqual(String genre, String language, Double rating);
}
