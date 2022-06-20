package com.example.demo;

import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //wstrzykuje pobranego usera
    private UserDetailServiceImpl userDetailService;

    //wstrzykuje pobranego usera przez konstruktor
    @Autowired
    public WebSecurityConfig(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // podkładamy naszego pobranego usera
        // i mamy możliwość tworzenia nowych użytkowników
        // którzy będą zapisywani do bazy danych
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();

        http.authorizeRequests()
                .antMatchers("/hello").authenticated()
                .antMatchers("/for-admin").hasAuthority("ROLE_ADMIN")  //lub  .hasRole("ADMIN")
                .antMatchers("/for-user").hasAuthority("ROLE_USER")    //lub  .hasRole("ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/hello");  // po zalogowaniu przechodzi automatycznie na endpoin /hello
    }


}
