package com.timetainment.timetainment.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserOutputDTO {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String username;
    @NotBlank
    private String role;
    @NotBlank
    private String email;
    @Digits(integer = Integer.BYTES, fraction = 0)
    private int status;
}
