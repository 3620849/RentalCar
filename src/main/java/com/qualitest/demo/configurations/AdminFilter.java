package com.qualitest.demo.configurations;

import com.qualitest.demo.model.User;
import com.qualitest.demo.services.TokenAuthService;
import com.qualitest.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by UA C on 12.08.2017.
 * filter wich intercapts all request and change credentials
 */

public class AdminFilter extends GenericFilterBean{
    private final TokenAuthService tokenAuthService;

    public AdminFilter(TokenAuthService tokenAuthService) {
        this.tokenAuthService = tokenAuthService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(
                tokenAuthService.getAuthentication((HttpServletRequest)servletRequest).orElse(null)
        );
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
