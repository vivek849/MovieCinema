package com.infi.moviecinema.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {

    private Long id;

    @NotNull(message = "{booking.userId.required}")
    private Long userId;

    @NotNull(message = "{booking.showId.required}")
    private Long showId;

    @Min(value = 1, message = "{booking.seats.min}")
    private Integer bookedSeats;

    @DecimalMin(value = "0.0", message = "{booking.price.negative}")
    private Double totalPrice;

    @Pattern(regexp = "PENDING|PAID|CANCELLED", message = "{booking.status.invalid}")
    private String status;

    private LocalDateTime createdAt;
}
