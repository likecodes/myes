package com.uxunchina.changsha.common.aut.service.impl;

import com.uxunchina.changsha.common.aut.service.impl.CustomAccessDecisionManager;
import com.uxunchina.changsha.common.aut.service.impl.CustomInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;

/**
 * 安全拦截器
 * Created by leo on 2017/7/8.
 */
@Service
public class CustomSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private CustomInvocationSecurityMetadataSourceService securityMetadataSourceService;

    @Autowired
    public void setMyAccessDecisionManager(CustomAccessDecisionManager accessDecisionManager) {
        super.setAccessDecisionManager(accessDecisionManager);
    }

//    @Autowired
//    public  void setRejectPublicInvocations(){
//        super.setRejectPublicInvocations(true);
//    }




    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }
    private void invoke(FilterInvocation fi) throws IOException, ServletException {
         //fi里面有一个被拦截的url
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSourceService;
    }
}
