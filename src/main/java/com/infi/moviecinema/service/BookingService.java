package com.infi.moviecinema.service;

import com.infi.moviecinema.dto.BookingDTO;

public interface BookingService {
    BookingDTO createBooking(BookingDTO dto);
    BookingDTO getBookingDetails(Long bookingId);
}
