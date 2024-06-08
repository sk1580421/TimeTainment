package com.timetainment.timetainment.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}