package com.timetainment.timetainment.controller;

import com.timetainment.timetainment.dto.UserInputDTO;
import com.timetainment.timetainment.dto.UserOutputDTO;
import com.timetainment.timetainment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        UserOutputDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserOutputDTO> getUserById(@PathVariable Long id) {
        UserOutputDTO createdUser = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


}

