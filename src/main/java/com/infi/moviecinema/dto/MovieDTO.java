package com.infi.moviecinema.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class MovieDTO {

    private Long id;

    @NotBlank(message = "{movie.name.blank}")
    @Size(min = 2, max = 100, message = "{movie.name.length}")
    private String name;

    @NotBlank(message = "{movie.genre.blank}")
    @Size(min = 3, max = 50, message = "{movie.genre.length}")
    private String genre;

    @NotBlank(message = "{movie.language.blank}")
    @Size(min = 2, max = 30, message = "{movie.language.length}")
    private String language;

    @DecimalMin(value = "0.0", message = "{movie.rating.range}")
    @DecimalMax(value = "5.0", message = "{movie.rating.range}")
    private Double rating;

    @Size(max = 10, message = "{movie.censor.length}")
    private String censorRating;

    @Size(max = 2000, message = "{movie.description.length}")
    private String description;

    @PastOrPresent(message = "{movie.releaseDate.future}")
    private LocalDate releaseDate;

    @NotBlank(message = "{movie.image.blank}")
    @Size(max = 255, message = "{movie.image.length}")
    private String imageUrl;
}
