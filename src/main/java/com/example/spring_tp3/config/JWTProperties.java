package com.example.spring_tp3.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.jwt")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTProperties {

    private String secret;
    private long expires;
    private String prefix;
    private String header;
}
