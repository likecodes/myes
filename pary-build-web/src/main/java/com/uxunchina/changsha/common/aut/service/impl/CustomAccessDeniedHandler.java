package com.uxunchina.changsha.common.aut.service.impl;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/10.
 */
@Service
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    public CustomAccessDeniedHandler() {
    }

    public CustomAccessDeniedHandler(String errorPage) {
        this.errorPage = errorPage;
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        //do some business logic, then redirect to errorPage url
        response.sendRedirect(errorPage);

    }
}
