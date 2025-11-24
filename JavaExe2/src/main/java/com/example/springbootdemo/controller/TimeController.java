package com.example.springbootdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/time")
public class TimeController {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final ZoneId SHANGHAI_ZONE = ZoneId.of("Asia/Shanghai");

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getServerTime() {
        LocalDateTime shanghaiTime = LocalDateTime.now(SHANGHAI_ZONE);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", System.currentTimeMillis());
        response.put("datetime", shanghaiTime.format(formatter));
        response.put("timezone", SHANGHAI_ZONE.getId());

        return ResponseEntity.ok().body(response);
    }
}