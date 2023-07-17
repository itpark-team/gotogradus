package com.example.gotogradus.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class SmsApiWorker {

    private RestTemplate restTemplate;

    public void send(String phoneNumber, String smsCode) {

        String url = String.format("https://smsc.ru/sys/send.php?login=itpark32&psw=itpark32ru&phones=%s&mes=%s", phoneNumber, smsCode);

        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
    }
}
