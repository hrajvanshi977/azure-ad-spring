package com.learn.azuread.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/oauth2/**", "/login/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login()
////                .tokenEndpoint()
////                .accessTokenResponseClient(accessTokenResponseClient())
////                .and()
//                .defaultSuccessUrl("/home");
//    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth2/**", "/login/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/home");
//                .and()
//                .addFilterBefore(securityFilter, OAuth2LoginAuthenticationFilter.class);
    }

//    @Bean
//    OAuth2AccessTokenResponseClient accessTokenResponseClient() {
//        return new NimbusAuthorizationCodeTokenResponseClient();
//    }

}
