package com.timetainment.timetainment.model.offerings;


import com.timetainment.timetainment.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Offering extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String location;
    private double price;
    private int availability;
    private int capacity;
    private String imageUrl;
    private String category;
    private int duration;

}

