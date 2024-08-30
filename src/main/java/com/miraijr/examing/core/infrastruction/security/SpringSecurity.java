package com.miraijr.examing.core.infrastruction.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.miraijr.examing.core.infrastruction.config.ExceptionHandlerFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurity {
  private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final ExceptionHandlerFilter exceptionHandlerFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .addFilterBefore(exceptionHandlerFilter, BasicAuthenticationFilter.class)
        .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class)
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/accounts/login").permitAll()
            .requestMatchers("/accounts/register").permitAll()
            .requestMatchers("/products/recommend").permitAll()
            .requestMatchers("/categories").permitAll()
            .anyRequest().authenticated());

    return httpSecurity.build();
  }
}
