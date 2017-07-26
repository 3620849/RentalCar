package com.qualitest.demo.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UA C on 24.07.2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "User")
public  class User implements UserDetails {
    @Id
    private int Id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserAutority> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    //helper method to set roles for this user
    public void grantRole(Role role) {
        if (authorities == null) {
            authorities = new ArrayList<UserAutority>();
        }
        authorities.add(new UserAutority(this,role.name()));
    }
}
