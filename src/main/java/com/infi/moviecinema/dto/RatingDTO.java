package com.infi.moviecinema.dto;


import jakarta.validation.constraints.*;

public class RatingDTO {

    private Long id;

    @NotNull(message = "{rating.movieId.required}")
    private Long movieId;

    @NotNull(message = "{rating.userId.required}")
    private Long userId;

    @Min(value = 1, message = "{rating.stars.range}")
    @Max(value = 5, message = "{rating.stars.range}")
    private Integer stars;
}
