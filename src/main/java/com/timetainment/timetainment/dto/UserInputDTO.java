package com.timetainment.timetainment.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInputDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;
}
