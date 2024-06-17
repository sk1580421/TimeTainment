package com.timetainment.timetainment.service.Accounts;


import com.timetainment.timetainment.dto.user.UserInputDTO;
import com.timetainment.timetainment.exception.CustomerAlreadyExistsException;
import com.timetainment.timetainment.model.usermodel.Users;
import com.timetainment.timetainment.repository.accounts.AccountsRepository;
import com.timetainment.timetainment.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsService {

    private AccountsRepository accountsRepository;
    private UserRepository userRepository;
    private final ModelMapper modelMapper;


}