package com.example.mvc.demo.mvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        return http

                .authorizeHttpRequests(auth -> {
                    auth

                            .requestMatchers(HttpMethod.POST).permitAll()
                            .requestMatchers(HttpMethod.GET).permitAll()
                            .anyRequest().permitAll();
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())
                .build();
    }
}

