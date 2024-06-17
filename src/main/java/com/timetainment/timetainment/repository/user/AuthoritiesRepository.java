package com.timetainment.timetainment.repository.user;

import com.timetainment.timetainment.model.usermodel.Authorities;
import com.timetainment.timetainment.model.usermodel.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
    // Custom query methods (if any) can be defined here
}