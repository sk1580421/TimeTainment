package com.timetainment.timetainment.dto.user;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInputDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String role;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    
    @Digits(integer = Integer.BYTES, fraction = 0)
    private int enabled;

}
