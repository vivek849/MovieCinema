package com.infi.moviecinema.serviceIml;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infi.moviecinema.dto.BookingDTO;
import com.infi.moviecinema.entity.Booking;
import com.infi.moviecinema.repository.BookingRepository;
import com.infi.moviecinema.service.BookingService;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final ModelMapper mapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepo, ModelMapper mapper) {
        this.bookingRepo = bookingRepo;
        this.mapper = mapper;
    }

    @Override
    public BookingDTO createBooking(BookingDTO dto) {
        Booking booking = mapper.map(dto, Booking.class);
        booking.setCreatedAt(LocalDateTime.now());
        booking.setStatus("PENDING");
        Booking saved = bookingRepo.save(booking);
        return mapper.map(saved, BookingDTO.class);
    }

    @Override
    public BookingDTO getBookingDetails(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapper.map(booking, BookingDTO.class);
    }
}
