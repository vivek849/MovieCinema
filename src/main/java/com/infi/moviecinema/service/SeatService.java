package com.infi.moviecinema.service;


import java.util.List;

import com.infi.moviecinema.dto.SeatDTO;

public interface SeatService {
    List<SeatDTO> getSeatsByShow(Long showId);
    SeatDTO updateSeatStatus(Long seatId, String status);
}
