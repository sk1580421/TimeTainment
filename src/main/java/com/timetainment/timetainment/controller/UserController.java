package com.timetainment.timetainment.controller;

import com.timetainment.timetainment.dto.UserInputDTO;
import com.timetainment.timetainment.dto.UserOutputDTO;
import com.timetainment.timetainment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody @Valid UserInputDTO userDTO) {
        System.out.println("Inside createUser api");
        UserOutputDTO createdUser = userService.createUser(userDTO);
        System.out.println(createdUser.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}

