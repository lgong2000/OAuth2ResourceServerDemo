package edu.iastate.cssm.oauth2resourceserverdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager users() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

        UserDetails user;
        user = User.builder()
                .username("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();
        users.createUser(user);

        user = User.builder()
                .username("user")
                .password("{noop}password")
                .roles("USER")
                .build();
        users.createUser(user);

        return users;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
        ;
        return http.build();
    }
}
