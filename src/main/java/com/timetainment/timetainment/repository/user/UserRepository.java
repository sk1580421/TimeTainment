package com.timetainment.timetainment.repository.user;

import com.timetainment.timetainment.model.usermodel.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // Custom query methods (if any) can be defined here
    List<Users> findByEmail(String email);
}