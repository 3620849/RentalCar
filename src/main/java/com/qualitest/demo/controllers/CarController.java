package com.qualitest.demo.controllers;

import com.qualitest.demo.model.Car;
import com.qualitest.demo.model.CarImage;
import com.qualitest.demo.services.CarImageService;
import com.qualitest.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    CarImageService carImageService;

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/getAllCars" , method = RequestMethod.GET)
    public ResponseEntity<List<Car>>getAllCars(){
        return new ResponseEntity<>(carService.getAllCarsList(), HttpStatus.OK);
    }
    @PreAuthorize("permitAll")
    @RequestMapping(value = "/getCarImgById/{id}" , method = RequestMethod.GET)
    public ResponseEntity<CarImage> getCarImgById(@PathVariable("id")int id){
        return new ResponseEntity<>(carImageService.getCarImgById(id),HttpStatus.OK);
    }
}
