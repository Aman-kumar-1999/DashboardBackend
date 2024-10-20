package com.codea2z.dashboard.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * 
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * 
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * import org.springframework.security.crypto.password.NoOpPasswordEncoder;
 * import org.springframework.security.crypto.password.PasswordEncoder;
 */


import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * @EnableWebSecurity
 * 
 * @Configuration
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled = true) public class
 * MySecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { // TODO Auto-generated method stub
 * auth.inMemoryAuthentication().withUser("DashBoardUser").password(
 * "DashBoardUser@1234").roles("USER"); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * 
 * http .csrf() .disable();
 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
 * 
 * 
 * 
 * 
 * http.headers().cacheControl();
 * 
 * 
 * }
 * 
 * @Bean public PasswordEncoder encoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * 
 * }
 */
