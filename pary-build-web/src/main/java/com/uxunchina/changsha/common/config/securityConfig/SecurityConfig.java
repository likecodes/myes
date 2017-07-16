package com.uxunchina.changsha.common.config.securityConfig;

import com.uxunchina.changsha.common.aut.service.impl.CustomInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.ArrayList;
import java.util.List;


/**
 * spring security配置类
 * Created by leo on 2017/7/5.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService customUserDetailsService;


    @Autowired
    private CustomInvocationSecurityMetadataSourceService securityMetadataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    ApplicationContext context;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/**/**/js/**",
                "/**/**/css/**",
                "/**/**/img/**",
                "/**/**/fonts/**",
                "/**/**/**.html",//任意目录的HTML放行
                "/**/**/favicon.ico");
        //防止拦截css,js，image文件

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService); //user Details Service验证
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("/**/**/login**").anonymous()
                    .anyRequest()
                .authenticated()
        .and()
             .formLogin()
                .loginPage("/html/login.html")
                .loginProcessingUrl("/login")
                    .passwordParameter("password")
                    .usernameParameter("username")
                .successForwardUrl("/login/success").permitAll()
                 .failureUrl("/login/failure").permitAll()
              .and()
                .logout()
                   .permitAll();//任何请求,登录后可以访问
        http.exceptionHandling().accessDeniedPage("/html/403.html");

        RoleVoter roleVoter=new RoleVoter();
        AuthenticatedVoter authenticatedVoter=new AuthenticatedVoter();
        securityMetadataSource.addconfigAttribute("/login/success",
                authenticatedVoter.IS_AUTHENTICATED_FULLY);
        securityMetadataSource.addconfigAttribute("/login/failure",
                authenticatedVoter.IS_AUTHENTICATED_ANONYMOUSLY);
        List<AccessDecisionVoter<?>> voters=new ArrayList<>(2);
        voters.add(roleVoter);
        voters.add(authenticatedVoter);
        AffirmativeBased affirmativeBased=new AffirmativeBased(voters);
        affirmativeBased.setAllowIfAllAbstainDecisions(false);
        FilterSecurityInterceptor filterSecurityInterceptor=new  FilterSecurityInterceptor();
        filterSecurityInterceptor.setAccessDecisionManager(affirmativeBased);
        filterSecurityInterceptor.setSecurityMetadataSource(securityMetadataSource);
        filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
        http.addFilterBefore(filterSecurityInterceptor,FilterSecurityInterceptor.class);
}
}
