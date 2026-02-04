package com.tinylibrary.config;

import com.tinylibrary.security.CustomAccesDeniedHandler;
import com.tinylibrary.security.CustomAuthenticationEntryPoint;
import com.tinylibrary.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomAccesDeniedHandler customAccesDeniedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          CustomAccesDeniedHandler customAccesDeniedHandler,
                          CustomAuthenticationEntryPoint customAuthenticationEntryPoint){
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customAccesDeniedHandler = customAccesDeniedHandler;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );


        http.exceptionHandling(ex ->
                ex.authenticationEntryPoint(customAuthenticationEntryPoint)
                        .accessDeniedHandler(customAccesDeniedHandler)
        );

        http.authorizeHttpRequests(auth ->

                auth

                        //login de los usuarios
                        .requestMatchers("/api/tinyLibrary/login").permitAll()
                        //Autenticación de usuarios
                        .requestMatchers("/api/tinyLibrary/user/me").authenticated()
                        //Autenticación book
                        .requestMatchers( HttpMethod.GET, "/api/tinyLibrary/book/**")
                        .hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/tinyLibrary/book/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/tinyLibrary/book/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/tinyLibrary/book/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/tinyLibrary/book/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/tinyLibrary/user/**").hasAnyRole("ADMIN")

                        //Autenticacion del apartado de borrow
                        .requestMatchers(HttpMethod.GET, "/api/tinyLibrary/borrow/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/tinyLibrary/borrow/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/tinyLibrary/book/**").hasAnyRole("ADMIN")
                        .anyRequest().denyAll()
        ).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
