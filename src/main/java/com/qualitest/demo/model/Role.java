package com.qualitest.demo.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by UA C on 24.07.2017.
 */
@Getter
public enum Role {
    USER,ADMIN,ROLE_ANONYMOUS;
}
