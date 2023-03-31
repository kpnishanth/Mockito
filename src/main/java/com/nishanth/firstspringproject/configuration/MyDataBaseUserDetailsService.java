package com.nishanth.firstspringproject.configuration;

import com.nishanth.firstspringproject.domain.User;
import com.nishanth.firstspringproject.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.provisioning.UserDetailsManagerResourceFactoryBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.net.PasswordAuthentication;

@Configuration
public class MyDataBaseUserDetailsService implements UserDetailsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    UserDetails userDetails;
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userMapper = jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USERNAME=?",new Object[]{username},new UserMapper());
        this.userDetails=userDetails;
        return new com.nishanth.firstspringproject.domain.UserDetails(userMapper.getUserName(),userMapper.getPassword(),userMapper.getExpirationDate()==null);

    }




}
