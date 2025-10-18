package com.infi.moviecinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infi.moviecinema.dto.ShowDTO;
import com.infi.moviecinema.service.TheatreService;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@CrossOrigin(origins = "*")
public class TheatreController {

    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    // US05–US06: Get shows by movie ID
    @GetMapping("/shows/{movieId}")
    public ResponseEntity<List<ShowDTO>> getShowsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(theatreService.getShowsByMovie(movieId));
    }
}
