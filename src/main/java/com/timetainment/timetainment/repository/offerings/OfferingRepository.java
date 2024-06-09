package com.timetainment.timetainment.repository.offerings;

import com.timetainment.timetainment.model.offerings.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OfferingRepository extends JpaRepository<Offering, Long> {
}
