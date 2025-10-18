package com.infi.moviecinema.service;


import java.util.List;

import com.infi.moviecinema.dto.ShowDTO;

public interface TheatreService {
    List<ShowDTO> getShowsByMovie(Long movieId);
}
