package com.timetainment.timetainment.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorityOutputDTO {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String authority;
    private String email;
}
