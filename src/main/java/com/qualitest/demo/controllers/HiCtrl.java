package com.qualitest.demo.controllers;

import com.qualitest.demo.dao.UserDao;
import com.qualitest.demo.model.Role;
import com.qualitest.demo.model.User;
import com.qualitest.demo.services.TokenAuthService;
import com.qualitest.demo.services.TokenHandler;
import com.qualitest.demo.services.UserService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger LOGGER = LoggerFactory.getLogger(HiCtrl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenHandler tokenHandler;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User hello() {
        return userDao.findUserByName("123");
    }

    @RequestMapping(value = "/getToken",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
        public String getAuthToken(@RequestBody User loginUser){
        LOGGER.debug("/getToken : method getAuthToken user: "+ loginUser.getUsername());
        User savedUser = null;
        try {
            savedUser = userDao.findUserByName(loginUser.getUsername());
            if(tokenHandler.checkMatchesPasswords(savedUser,loginUser)){
                return tokenHandler.generateTokenId(savedUser.getId() , LocalDateTime.now().plusHours(1));
            };
        } catch (NullPointerException e){
            return "-1";
        }
        return "-1";
    }
    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public User getCurrentUser(){
        LOGGER.debug("/getCurrentUser : method getCurrentUser ");
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
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user){
        LOGGER.debug("/register : method register , user: "+user.getUsername());
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.grantRole(Role.ROLE_USER);
        userService.addNewUser(user);
    }
}
