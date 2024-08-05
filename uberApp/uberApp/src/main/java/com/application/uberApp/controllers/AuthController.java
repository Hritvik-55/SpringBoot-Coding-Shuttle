package com.application.uberApp.controllers;

import com.application.uberApp.dto.SignUpDTO;
import com.application.uberApp.dto.UserDTO;
import com.application.uberApp.services.Impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    public UserDTO signUp(SignUpDTO signUpDTO){
        return authService.signup(signUpDTO);
    }
}
