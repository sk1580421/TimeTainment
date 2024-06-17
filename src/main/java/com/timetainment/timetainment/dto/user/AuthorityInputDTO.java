package com.timetainment.timetainment.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorityInputDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String authority;
    private String email;

}
