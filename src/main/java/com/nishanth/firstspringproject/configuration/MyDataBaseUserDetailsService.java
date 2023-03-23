package com.nishanth.firstspringproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class MyDataBaseUserDetailsService implements UserDetailsService {
    @Override
    @Bean
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new JdbcUserDetailsManager().loadUserByUsername(username);
    }

    @Bean
    public PasswordEncoder getPasswordEncorder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
