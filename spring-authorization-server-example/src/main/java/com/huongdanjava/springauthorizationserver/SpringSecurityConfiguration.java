package com.huongdanjava.springauthorizationserver;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfiguration {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    // @formatter:off
    http
        .authorizeRequests(authorizeRequests ->
            authorizeRequests
            .antMatchers("/custom-login").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/custom-login")
            .loginProcessingUrl("/login"))
        ;
    // @formatter:on

    return http.build();
  }

  @Bean
  public UserDetailsService users() {
    // @formatter:off
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("password")
        .roles("ADMIN").build();
    // @formatter:on

    return new InMemoryUserDetailsManager(user);
  }

}
