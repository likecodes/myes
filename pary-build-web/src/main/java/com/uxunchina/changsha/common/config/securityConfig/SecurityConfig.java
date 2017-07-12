package com.uxunchina.changsha.common.config.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


/**
 * spring security配置类
 * Created by leo on 2017/7/5.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    private AccessDecisionManager customAccessDecisionManager;

    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/**/js/**",
                "/**/**/css/**",
                "/**/**/img/**",
                "/**/**/html/**",
                "/**/**/favicon.ico");
        //防止拦截css,js，image文件

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService); //user Details Service验证
    }
    @Bean
    protected  FilterSecurityInterceptor initFilterSecurityInterceptor(){
       FilterSecurityInterceptor filterSecurityInterceptor=new  FilterSecurityInterceptor();
       filterSecurityInterceptor.setAccessDecisionManager(customAccessDecisionManager);
       filterSecurityInterceptor.setSecurityMetadataSource(securityMetadataSource);
       filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
        return filterSecurityInterceptor;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/index")
                    .failureUrl("/html/403.html")
                    .passwordParameter("password")
                    .usernameParameter("username")
                    .permitAll(true)
                    .and()
                    .logout()
                    .permitAll();
        http.exceptionHandling().accessDeniedPage("/html/403.html");
    }
}
