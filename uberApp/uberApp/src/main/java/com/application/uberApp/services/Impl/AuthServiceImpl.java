package com.application.uberApp.services.Impl;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.SignUpDTO;
import com.application.uberApp.dto.UserDTO;
import com.application.uberApp.entities.User;
import com.application.uberApp.entities.enums.Roles;
import com.application.uberApp.exceptions.RuntimeConflictException;
import com.application.uberApp.repositories.UserRepository;
import com.application.uberApp.services.AuthService;
import com.application.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDTO signup(SignUpDTO signUpDTO) {
        User user = userRepository.findByEmail(signUpDTO.getEmail()).orElse(null);
        if(user!=null){
            throw new RuntimeConflictException("User already exists with email "+signUpDTO.getEmail());
        }


        User mappedUser=modelMapper.map(signUpDTO,User.class);
        mappedUser.setRole(Set.of(Roles.RIDER));
        User savedUser=userRepository.save(mappedUser);

        //Create user related entites
        riderService.createNewRider(savedUser);
        // TODO add wallet related service




        return modelMapper.map(savedUser,UserDTO.class);
    }

    @Override
    public DriverDTO onboardDriver(Long userId) {
        return null;
    }
}
