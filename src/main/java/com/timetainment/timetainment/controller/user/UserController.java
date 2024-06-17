package com.timetainment.timetainment.controller.user;

import com.timetainment.timetainment.dto.user.AuthorityInputDTO;
import com.timetainment.timetainment.dto.user.AuthorityOutputDTO;
import com.timetainment.timetainment.dto.user.UserInputDTO;
import com.timetainment.timetainment.dto.user.UserOutputDTO;
import com.timetainment.timetainment.service.user.UserService;
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

    @PostMapping("/register")
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody @Valid UserInputDTO userDTO) {
        UserOutputDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @PostMapping("/create-authority")
    public ResponseEntity<AuthorityOutputDTO> createAuthority(@RequestBody @Valid AuthorityInputDTO authorityInputDTO) {
        AuthorityOutputDTO createdAuthority = userService.createAuthority(authorityInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthority);
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

