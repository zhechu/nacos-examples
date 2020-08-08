package com.alibaba.nacos.example.spring.cloud.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProperties {

    String name;

    Integer age;

}
