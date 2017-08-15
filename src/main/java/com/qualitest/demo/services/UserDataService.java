package com.qualitest.demo.services;

import com.qualitest.demo.dao.UserDao;
import com.qualitest.demo.model.UserData;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by UA C on 15.08.2017.
 */
@Service
public class UserDataService {
    @Autowired
    private UserDao userDao;
    public UserData getUserDataById(@NonNull int id){
        return userDao.getUserDataByUserId(id);
    }
}
