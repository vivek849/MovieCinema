package com.infi.moviecinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infi.moviecinema.dto.SeatDTO;
import com.infi.moviecinema.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "*")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // US07: Get seat layout for a show
    @GetMapping("/show/{showId}")
    public ResponseEntity<List<SeatDTO>> getSeatsByShow(@PathVariable Long showId) {
        return ResponseEntity.ok(seatService.getSeatsByShow(showId));
    }

    // Update seat status (e.g., when selected)
    @PutMapping("/{seatId}/status")
    public ResponseEntity<SeatDTO> updateSeatStatus(
            @PathVariable Long seatId,
            @RequestParam String status) {
        return ResponseEntity.ok(seatService.updateSeatStatus(seatId, status));
    }
}
