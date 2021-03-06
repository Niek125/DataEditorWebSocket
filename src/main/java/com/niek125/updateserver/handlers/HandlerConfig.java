package com.niek125.updateserver.handlers;

import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class HandlerConfig {
    @Bean
    public RoleHandler roleHandler() {
        return new RoleHandler(new ObjectMapper());
    }

    @Bean
    public DataHandler dataHandler() {
        return new DataHandler(new ObjectMapper());
    }

    @Bean
    public MessageHandler messageHandler() {
        return new MessageHandler(new ObjectMapper(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    @Bean
    @Autowired
    public TokenHandler tokenHandler(JWTVerifier verifier) {
        return new TokenHandler(verifier, new ObjectMapper());
    }
}
