package com.example.gotogradus.repositories;

import com.example.gotogradus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
