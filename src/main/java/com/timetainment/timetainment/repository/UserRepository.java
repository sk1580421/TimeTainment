package com.timetainment.timetainment.repository;

import com.timetainment.timetainment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods (if any) can be defined here
}