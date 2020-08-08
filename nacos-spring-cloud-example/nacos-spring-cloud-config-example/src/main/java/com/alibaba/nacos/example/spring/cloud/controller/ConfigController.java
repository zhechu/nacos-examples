package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.nacos.example.spring.cloud.config.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${user.name}")
    private String userName;

    @Value("${log.level}")
    private String logLevel;

    @Autowired
    private UserProperties userProperties;

    @GetMapping("/get")
    public String get() {
        return userName;
    }

    @GetMapping("/getAll")
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", userProperties.getName());
        map.put("age", userProperties.getAge());
        map.put("logLevel", logLevel);
        return map;
    }

}