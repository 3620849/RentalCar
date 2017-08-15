package com.qualitest.demo.controllers;

import com.qualitest.demo.dao.UserDao;
import com.qualitest.demo.model.Role;
import com.qualitest.demo.model.User;
import com.qualitest.demo.services.TokenAuthService;
import com.qualitest.demo.services.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by UA C on 23.07.2017.
 */

@RestController
public class HiCtrl {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenHandler tokenHandler;

    @RequestMapping(value = "/hi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User hello() {
        return userDao.findUserByName("123");
    }

    @RequestMapping(value = "/getToken",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getIndexPage(@RequestBody User loginUser) {
        User savedUser = userDao.findUserByName(loginUser.getUsername());
        if(tokenHandler.checkMatchesPasswords(savedUser,loginUser)){

            return tokenHandler.generateTokenId(savedUser.getId() , LocalDateTime.now().plusHours(1));
        };

        return "-1";
    }
    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public User getCurrentUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        try{
            user = (User) authentication.getPrincipal();
        }catch (ClassCastException e){
            if (authentication.getPrincipal()=="anonymousUser"){
                user=new User();
                user.setUsername("anonymousUser");
                user.grantRole(Role.ROLE_ANONYMOUS);
            }
        }
        return user;
    }

}
