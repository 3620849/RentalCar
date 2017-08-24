package com.qualitest.demo.controllers;

import com.qualitest.demo.model.Car;
import com.qualitest.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Created by UA C on 24.08.2017.
 */
@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarService carService;

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/getAllCars" , method = RequestMethod.GET)
    public ResponseEntity<List<Car>>getAllCars(){
        return new ResponseEntity<>(carService.getAllCarsList(), HttpStatus.OK);
    }
}
