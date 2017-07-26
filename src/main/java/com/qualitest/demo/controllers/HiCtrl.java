package com.qualitest.demo.controllers;

import com.qualitest.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by UA C on 23.07.2017.
 */

@RestController
public class HiCtrl {
    @Autowired
    public UserDao userDao;

    @RequestMapping(value = "/hi", method= RequestMethod.GET,produces = "text/json")
    @ResponseBody
    public void hello(){
         userDao.findUserByName("");
    }
}
