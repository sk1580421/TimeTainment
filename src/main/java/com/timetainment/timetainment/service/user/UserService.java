package com.timetainment.timetainment.service.user;

import com.timetainment.timetainment.dto.user.AuthorityInputDTO;
import com.timetainment.timetainment.dto.user.AuthorityOutputDTO;
import com.timetainment.timetainment.dto.user.UserInputDTO;
import com.timetainment.timetainment.dto.user.UserOutputDTO;
import com.timetainment.timetainment.model.usermodel.Authorities;
import com.timetainment.timetainment.model.usermodel.Users;
import com.timetainment.timetainment.repository.user.AuthoritiesRepository;
import com.timetainment.timetainment.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository,AuthoritiesRepository authoritiesRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.modelMapper = modelMapper;
    }

    public UserOutputDTO createUser(UserInputDTO userInputDTO) {
        Users users = modelMapper.map(userInputDTO, Users.class);
        String hashPwd = passwordEncoder.encode(users.getPassword());
        users.setPassword(hashPwd);
        users = userRepository.save(users);
        return modelMapper.map(users, UserOutputDTO.class);
    }

    public AuthorityOutputDTO createAuthority(AuthorityInputDTO authorityInputDTO) {
        Authorities authorities = modelMapper.map(authorityInputDTO, Authorities.class);
        authorities = authoritiesRepository.save(authorities);
        return modelMapper.map(authorities, AuthorityOutputDTO.class);
    }

    public void deleteUserById(Long id) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            userRepository.delete(users);
            log.info("User with id {} deleted successfully", id);
        } else {
            log.warn("User with id {} not found, delete operation failed", id);
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    public UserOutputDTO getUserById(Long id) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            return modelMapper.map(users, UserOutputDTO.class);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

}
