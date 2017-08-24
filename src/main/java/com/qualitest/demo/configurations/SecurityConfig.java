package com.qualitest.demo.configurations;

import com.qualitest.demo.services.TokenAuthService;
import com.qualitest.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * Created by UA C on 24.07.2017.
 * 1) dobavil v pom spring-boot-starter-security
 * 2)dobavil etot config class i security rabotaet
 * 3)Dlya securemetod anotatsiy dobavili @EnableGlobalMethodSecurity(prePostEnabled=true)
 *
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    TokenAuthService tokenAuthService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .addFilterBefore(new AdminFilter(tokenAuthService), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/lib/**","/js/**","/getToken","/*").permitAll()
                /*.anyRequest().authenticated()
                .and()
                .formLogin().permitAll()//esli formlogin bez loginpage to budet custom login page viskakivat*/
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }
    @Autowired
    UserService userService;
    /*Password encoder also used in userService
    */
    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGolobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder());

    }
}
