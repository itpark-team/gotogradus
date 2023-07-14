package com.example.gotogradus.services;

import com.example.gotogradus.models.User;
import com.example.gotogradus.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {
    private UsersRepository usersRepository;

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return usersRepository
                .findByPhoneNumber(phoneNumber);
    }

    public void addNew(User user){
        usersRepository.save(user);
    }
}
