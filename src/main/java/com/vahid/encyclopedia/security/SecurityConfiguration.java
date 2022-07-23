package com.vahid.encyclopedia.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("security")
public class SecurityConfiguration {
    
    private Jwt jwt;

    @Data
    public static class Jwt {
        private String secret;
        private long expiration;
    }
}
