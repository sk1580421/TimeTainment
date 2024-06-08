package com.timetainment.timetainment.service;

import com.timetainment.timetainment.dto.UserInputDTO;
import com.timetainment.timetainment.dto.UserOutputDTO;
import com.timetainment.timetainment.model.User;
import com.timetainment.timetainment.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
