package com.infi.moviecinema.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    private Long id;

    @NotBlank(message = "{user.name.blank}")
    @Size(min = 2, max = 50, message = "{user.name.length}")
    private String name;

    @Email(message = "{user.email.invalid}")
    @NotBlank(message = "{user.email.blank}")
    @Size(max = 100, message = "{user.email.length}")
    private String email;

    @Size(min = 6, max = 255, message = "{user.password.length}")
    private String password;
}
