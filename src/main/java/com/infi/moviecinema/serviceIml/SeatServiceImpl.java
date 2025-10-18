package com.infi.moviecinema.serviceIml;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infi.moviecinema.dto.SeatDTO;
import com.infi.moviecinema.entity.Seat;
import com.infi.moviecinema.repository.SeatRepository;
import com.infi.moviecinema.service.SeatService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepo;
    private final ModelMapper mapper;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepo, ModelMapper mapper) {
        this.seatRepo = seatRepo;
        this.mapper = mapper;
    }

    @Override
    public List<SeatDTO> getSeatsByShow(Long showId) {
        return seatRepo.findByShowId(showId)
                .stream()
                .map(seat -> mapper.map(seat, SeatDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SeatDTO updateSeatStatus(Long seatId, String status) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        seat.setStatus(status);
        Seat updated = seatRepo.save(seat);
        return mapper.map(updated, SeatDTO.class);
    }
}
