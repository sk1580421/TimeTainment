package com.timetainment.timetainment.dto.booking;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingInputDTO {

    @NotNull(message = "offering ID is required")
    private Long offeringId;

    @NotNull(message = "User ID is required")
    private Long userId;
}
