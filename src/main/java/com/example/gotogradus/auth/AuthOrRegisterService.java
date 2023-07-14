package com.example.gotogradus.auth;

import com.example.gotogradus.dtos.AuthOrRegisterResponseDto;
import com.example.gotogradus.dtos.AuthRequestDto;
import com.example.gotogradus.dtos.CheckPhoneNumberRequestDto;
import com.example.gotogradus.dtos.RegisterRequestDto;
import com.example.gotogradus.models.User;
import com.example.gotogradus.repositories.UsersRepository;
import com.example.gotogradus.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthOrRegisterService {
    private UsersService usersService;
    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    public AuthOrRegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .name(registerRequestDto.getName())
                .phoneNumber(registerRequestDto.getPhoneNumber())
                .build();

        usersService.addNew(user);

        String jwtToken = jwtService.generateToken(user);

        return AuthOrRegisterResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthOrRegisterResponseDto authenticate(AuthRequestDto authRequestDto) {

        if (!authRequestDto.getSmsCode().equals("1234")) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = usersService.findByPhoneNumber(authRequestDto.getPhoneNumber()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authRequestDto.getPhoneNumber(),
//                        authRequestDto.getSmsCode()
//                )
//        );

        String jwtToken = jwtService.generateToken(user);

        return AuthOrRegisterResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    public boolean checkPhoneNumber(CheckPhoneNumberRequestDto checkPhoneNumberRequestDto) {
        return usersService.findByPhoneNumber(checkPhoneNumberRequestDto.getPhoneNumber()).isPresent();
    }
}
