package com.example.gotogradus.auth;

import com.example.gotogradus.dtos.AuthOrRegisterResponseDto;
import com.example.gotogradus.dtos.AuthRequestDto;
import com.example.gotogradus.dtos.CheckPhoneNumberRequestDto;
import com.example.gotogradus.dtos.RegisterRequestDto;
import com.example.gotogradus.models.User;
import com.example.gotogradus.repositories.UsersRepository;
import com.example.gotogradus.services.UsersService;
import com.example.gotogradus.utils.RedisUtil;
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
    private RedisUtil redisUtil;

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

        String code = redisUtil.get(authRequestDto.getPhoneNumber());

        if (code == null) {
            throw new UsernameNotFoundException("User not found");
        }

        if (!authRequestDto.getSmsCode().equals(code)) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = usersService.findByPhoneNumber(authRequestDto.getPhoneNumber()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String jwtToken = jwtService.generateToken(user);

        return AuthOrRegisterResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return usersService.findByPhoneNumber(phoneNumber).isPresent();
    }
}
