package com.example.securityandvue.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationSuccessHandler successHandler;
    private final LogoutHandler logoutHandler;

    public WebSecurityConfig(AuthenticationSuccessHandler successHandler,
                             LogoutHandler logoutHandler) {
        this.successHandler = successHandler;
        this.logoutHandler = logoutHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginProcessingUrl("/authentication")
                .successHandler(successHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutHandler)
                .permitAll()

                .and()
                .rememberMe()

                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/resource", "/user", "/logout").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin1pass").roles("USER").and()
                .withUser("user").password("password").roles("USER");
    }
}
