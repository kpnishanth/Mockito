package com.nishanth.firstspringproject.configuration;

import com.mysql.cj.protocol.AuthenticationProvider;
import com.mysql.cj.protocol.a.NativeAuthenticationProvider;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/book/nishanth").permitAll()
                .antMatchers("/book/Liji").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new MyDataBaseUserDetailsService();
    }

    @Bean
    public PasswordEncoder getPasswordEncorder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



}
