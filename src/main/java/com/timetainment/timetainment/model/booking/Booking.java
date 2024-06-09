package com.timetainment.timetainment.model.booking;
import com.timetainment.timetainment.model.BaseEntity;
import com.timetainment.timetainment.model.offerings.Offering;
import com.timetainment.timetainment.model.usermodel.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Data
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offering_id", referencedColumnName = "id")
    private Offering offering;  // Changed to singular form for clarity

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private LocalDateTime bookingDate;
    private String status;
}

