package com.example.gotogradus.controllers;

import com.example.gotogradus.api.SmsApiWorker;
import com.example.gotogradus.auth.AuthOrRegisterService;
import com.example.gotogradus.dtos.*;
import com.example.gotogradus.utils.RedisUtil;
import com.example.gotogradus.utils.RandomSmsCodeUtil;
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
    private AuthOrRegisterService authOrRegisterService;
    private RandomSmsCodeUtil randomSmsCodeUtil;
    private RedisUtil redisUtil;
    private SmsApiWorker smsApiWorker;

//    @PostMapping("/register")
//    public AuthOrRegisterResponseDto register(@RequestBody RegisterRequestDto registerRequestDto) {
//        return authOrRegisterService.register(registerRequestDto);
//    }

    @PostMapping("/check-phone-number")
    public ResponseEntity checkPhoneNumber(@RequestBody CheckPhoneNumberRequestDto checkPhoneNumberRequestDto) {
        String phoneNumber = checkPhoneNumberRequestDto.getPhoneNumber();

        boolean userExist = authOrRegisterService.checkPhoneNumber(phoneNumber);

        if (!userExist) {
            return new ResponseEntity(HttpStatusCode.valueOf(403));
        }

        String smsCode = randomSmsCodeUtil.getRandomCode();
        redisUtil.set(phoneNumber, smsCode);
        //smsApiWorker.send(phoneNumber, smsCode);

        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }

    @PostMapping("/authenticate")
    public AuthOrRegisterResponseDto authenticate(@RequestBody AuthRequestDto authRequestDto) {
        return authOrRegisterService.authenticate(authRequestDto);
    }
}
