package com.timetainment.timetainment.dto.offerings;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class OfferingOutputDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @PositiveOrZero(message = "Price must be a positive number or zero")
    private double price;

    @Min(value = 0, message = "Availability cannot be negative")
    private int availability;

    @Min(value = 0, message = "Capacity cannot be negative")
    private int capacity;

    private String imageUrl;

    @NotBlank(message = "Category is required")
    private String category;

    @Positive(message = "Duration must be a positive number")
    private int duration;

}