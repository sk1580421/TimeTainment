package com.timetainment.timetainment.service;

import com.timetainment.timetainment.dto.UserInputDTO;
import com.timetainment.timetainment.dto.UserOutputDTO;
import com.timetainment.timetainment.model.User;
import com.timetainment.timetainment.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserOutputDTO createUser(UserInputDTO userInputDTO) {
        User user = modelMapper.map(userInputDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserOutputDTO.class);
    }

    public void deleteUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            log.info("User with id {} deleted successfully", id);
        } else {
            log.warn("User with id {} not found, delete operation failed", id);
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    public UserOutputDTO getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return modelMapper.map(user, UserOutputDTO.class);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

}
