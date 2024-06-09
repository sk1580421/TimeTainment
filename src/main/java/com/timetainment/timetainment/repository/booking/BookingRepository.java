package com.timetainment.timetainment.repository.booking;

import com.timetainment.timetainment.model.booking.Booking;
import com.timetainment.timetainment.model.offerings.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
