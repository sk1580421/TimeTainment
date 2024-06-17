package com.timetainment.timetainment.configuration;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");


        // for cross origin server site


//        http.securityContext((securityContext)->securityContext.requireExplicitSave(false));

        // for JSessionId
//        http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).

//        for JsonWebToken
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
//        cors((request)->request.configurationSource(new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//
//                CorsConfiguration config = new CorsConfiguration();
//                config.setAllowedOrigins(Collections.singletonList("http://localhost....com"));
//                config.setAllowedMethods(Collections.singletonList("*"));
//                config.setAllowCredentials(true);
//                config.setAllowedHeaders(Collections.singletonList("*"));
//                config.setExposedHeaders(List.of("Authorization"));
//                config.setMaxAge(3600L);
//                return config;
//            }
//        }));


        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/api/v1/users/register","/actuator/**").permitAll());
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/","/home").authenticated());
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/").hasAuthority("VIEWSSLASH"));
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/api/v1/users/register").hasRole("USER"));
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/home").hasAnyAuthority("VIEWHOME"));
        http.csrf((csrf)->csrf.csrfTokenRequestHandler(requestAttributeHandler).ignoringRequestMatchers("/api/v1/users/register")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                        .addFilterAfter(new CsrfCookieFilter(),BasicAuthenticationFilter.class)
                .addFilterBefore(new RequestValidationBeforeFilter(),BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(),BasicAuthenticationFilter.class)
//                        .addFilterAt()
                ;
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
