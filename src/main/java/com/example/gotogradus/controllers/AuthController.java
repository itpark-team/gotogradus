package com.example.gotogradus.controllers;

import com.example.gotogradus.auth.AuthOrRegisterService;
import com.example.gotogradus.dtos.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;

//    @PostMapping("/register")
//    public AuthOrRegisterResponseDto register(@RequestBody RegisterRequestDto registerRequestDto) {
//        return authOrRegisterService.register(registerRequestDto);
//    }

    @PostMapping("/check-phone-number")
    public ResponseEntity<CheckPhoneNumberResponseDto> checkPhoneNumber(@RequestBody CheckPhoneNumberRequestDto checkPhoneNumberRequestDto) {
        boolean userExist = authOrRegisterService.checkPhoneNumber(checkPhoneNumberRequestDto);

        if (!userExist) {
            return new ResponseEntity<>(CheckPhoneNumberResponseDto.builder().build(), HttpStatusCode.valueOf(403));
        }



        return new ResponseEntity<>(CheckPhoneNumberResponseDto.builder().code("1234").build(), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/authenticate")
    public AuthOrRegisterResponseDto authenticate(@RequestBody AuthRequestDto authRequestDto) {
        return authOrRegisterService.authenticate(authRequestDto);
    }
}
