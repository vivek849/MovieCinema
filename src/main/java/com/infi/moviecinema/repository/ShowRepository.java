package com.infi.moviecinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infi.moviecinema.entity.Show;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId);
}
