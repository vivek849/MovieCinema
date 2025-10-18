package com.infi.moviecinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infi.moviecinema.dto.BookingDTO;
import com.infi.moviecinema.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // US08: Create a new booking
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }

    // US08: Get booking details by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingDetails(@PathVariable Long bookingId) {
        return ResponseEntity.ok(bookingService.getBookingDetails(bookingId));
    }
}
