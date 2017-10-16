package com.qualitest.demo.services;

import com.qualitest.demo.configurations.AdminAuth;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/*
 * Created by UA C on 12.08.2017.
 */
@Component
public class TokenAuthService {
    @Autowired
    TokenHandler tokenHandler;
    @Autowired
    UserService userService;

    public final String AUTH_TOKEN="X-Auth-Token";
    public Optional<Authentication> getAuthentication(@NonNull HttpServletRequest servletRequest) {

        return Optional.ofNullable(servletRequest.getHeader(AUTH_TOKEN) )
                .flatMap(tokenHandler::extractUserId)
                .flatMap(userService::findById)
                .map(AdminAuth::new);
    }
}
