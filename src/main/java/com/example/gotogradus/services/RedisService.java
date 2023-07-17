package com.example.gotogradus.services;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisService {
    private RedisTemplate<String, String> redisTemplate;

    public void add(String key, String value) {
        redisTemplate.opsForValue().append(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
