package com.qualitest.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by UA C on 27.07.2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAutority implements GrantedAuthority {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @Id
    private User user;

    @NotNull
    @Id
    private String authority;
    @Override
    public String getAuthority() {
        return authority;
    }
}
