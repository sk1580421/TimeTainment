package com.timetainment.timetainment.dto.booking;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingOutputDTO {

    @NotNull
    @NotNull
    private Long id;

    @NotNull
    private Long offeringId;

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime bookingDate;

    @NotNull
    private String status;
}
