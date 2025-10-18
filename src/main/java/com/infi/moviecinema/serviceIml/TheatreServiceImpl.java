package com.infi.moviecinema.serviceIml;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infi.moviecinema.dto.ShowDTO;
import com.infi.moviecinema.repository.ShowRepository;
import com.infi.moviecinema.service.TheatreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final ShowRepository showRepo;
    private final ModelMapper mapper;

    @Autowired
    public TheatreServiceImpl(ShowRepository showRepo, ModelMapper mapper) {
        this.showRepo = showRepo;
        this.mapper = mapper;
    }

    @Override
    public List<ShowDTO> getShowsByMovie(Long movieId) {
        return showRepo.findByMovieId(movieId)
                .stream()
                .map(show -> mapper.map(show, ShowDTO.class))
                .collect(Collectors.toList());
    }
}
