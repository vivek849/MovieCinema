package com.infi.moviecinema.dto;


import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class ShowDTO {

    private Long id;

    @NotNull(message = "{show.movieId.required}")
    private Long movieId;

    @NotNull(message = "{show.theatreId.required}")
    private Long theatreId;

    @Future(message = "{show.time.future}")
    private LocalDateTime showTime;

    @DecimalMin(value = "50.0", message = "{show.price.range}")
    @DecimalMax(value = "5000.0", message = "{show.price.range}")
    private Double pricePerSeat;
}
