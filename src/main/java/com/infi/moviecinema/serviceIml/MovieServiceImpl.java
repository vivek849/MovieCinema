package com.infi.moviecinema.serviceIml;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infi.moviecinema.dto.MovieDTO;
import com.infi.moviecinema.dto.RatingDTO;
import com.infi.moviecinema.entity.Movie;
import com.infi.moviecinema.entity.Rating;
import com.infi.moviecinema.repository.MovieRepository;
import com.infi.moviecinema.repository.RatingRepository;
import com.infi.moviecinema.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;
    private final RatingRepository ratingRepo;
    private final ModelMapper mapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepo, RatingRepository ratingRepo, ModelMapper mapper) {
        this.movieRepo = movieRepo;
        this.ratingRepo = ratingRepo;
        this.mapper = mapper;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepo.findAll()
                .stream()
                .map(m -> mapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + id));
        return mapper.map(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> searchMovies(String name) {
        return movieRepo.findByNameContainingIgnoreCase(name)
                .stream()
                .map(m -> mapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> filterMovies(String genre, Double rating, String language) {
        return movieRepo.findByGenreAndLanguageAndRatingGreaterThanEqual(genre, language, rating)
                .stream()
                .map(m -> mapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }

    public RatingDTO rateMovie(RatingDTO dto) {
        Rating rating = mapper.map(dto, Rating.class);
        Rating saved = ratingRepo.save(rating);
        return mapper.map(saved, RatingDTO.class);
    }

	@Override
	public MovieDTO addMovie(MovieDTO movieDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
