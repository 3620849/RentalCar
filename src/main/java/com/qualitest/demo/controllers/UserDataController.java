package com.qualitest.demo.controllers;

import com.qualitest.demo.model.Car;
import com.qualitest.demo.model.User;
import com.qualitest.demo.model.UserData;
import com.qualitest.demo.services.CarService;
import com.qualitest.demo.services.UserDataService;
import com.qualitest.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by UA C on 15.08.2017.
 */
@RestController
@RequestMapping("/api")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/getUserInfo/{id}", method = RequestMethod.GET)
    public User getUserInfo (@PathVariable("id") int id){
        return userService.findById(id).get();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.id == #id")
    @RequestMapping(value = "/getUserData/{id}", method = RequestMethod.GET)
    public UserData getUserData (@PathVariable("id") int id){
        return userDataService.getUserDataById(id);
    }
    @RequestMapping(value = "/getCarList/{id}", method = RequestMethod.GET)
    public List<Car> getCarList (@PathVariable("id") int id){
        return carService.getUsedCarListByUserId(id);
    }
}
