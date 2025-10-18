package com.infi.moviecinema.dto;

import jakarta.validation.constraints.*;

public class SeatDTO {

    private Long id;

    @NotNull(message = "{seat.showId.required}")
    private Long showId;

    @NotBlank(message = "{seat.number.blank}")
    @Size(max = 10, message = "{seat.number.length}")
    private String seatNumber;

    @Size(max = 20, message = "{seat.type.length}")
    private String seatType;

    @Pattern(regexp = "AVAILABLE|BOOKED", message = "{seat.status.pattern}")
    private String status;
}
