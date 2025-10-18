package com.infi.moviecinema.dto;


import jakarta.validation.constraints.*;

public class TheatreDTO {

    private Long id;

    @NotBlank(message = "{theatre.name.blank}")
    @Size(max = 100, message = "{theatre.name.length}")
    private String name;

    @NotBlank(message = "{theatre.city.blank}")
    @Size(max = 100, message = "{theatre.city.length}")
    private String city;
}
