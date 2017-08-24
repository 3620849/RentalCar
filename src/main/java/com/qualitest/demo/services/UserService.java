package com.qualitest.demo.services;


import com.qualitest.demo.dao.UserDao;
import com.qualitest.demo.dao.UserDataDao;
import com.qualitest.demo.model.User;
import com.qualitest.demo.model.UserData;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * Created by UA C on 24.07.2017.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        //here shoud be method wich retrieve user from db and mathc it
        return userDao.findUserByName(user);
    }

    public  Optional<User> findById(int id) {
       return userDao.findById(id);
    }

    public void addNewUser(@NonNull User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
        UserData userData = new UserData();
        userData.setUser(userDao.findUserByName(user.getUsername()));
        userDataDao.addUserData(userData);
    }
}
