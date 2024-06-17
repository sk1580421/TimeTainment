package com.timetainment.timetainment.model.booking;
import com.timetainment.timetainment.model.BaseEntity;
import com.timetainment.timetainment.model.offerings.Offering;
import com.timetainment.timetainment.model.usermodel.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter @Setter @ToString
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offering_id", referencedColumnName = "id")
    private Offering offering;  // Changed to singular form for clarity

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    private LocalDateTime bookingDate;
    private String status;
}

