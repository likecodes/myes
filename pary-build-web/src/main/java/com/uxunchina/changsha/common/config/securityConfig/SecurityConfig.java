package com.uxunchina.changsha.common.config.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.Filter;

/**
 * spring security配置类
 * Created by leo on 2017/7/5.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
   private Filter customSecurityInterceptor;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    private AccessDeniedHandler customAccessDeniedHandler;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/**/**/js/**",
                "/**/**/css/**",
                "/**/**/img/**",
                "/**/**/html/**",
                "/**/**/favicon.ico");
        //防止拦截css,js，image文件
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService); //user Details Service验证.
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll(true)
                .and()
                .logout()
                .permitAll();//任何请求,登录后可以访问
        http.addFilterBefore(customSecurityInterceptor, FilterSecurityInterceptor.class);
        http.exceptionHandling().accessDeniedPage("/html/403.html");
    }
}
