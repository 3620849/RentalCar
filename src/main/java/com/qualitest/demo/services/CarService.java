package com.qualitest.demo.services;

import com.qualitest.demo.dao.CarDao;
import com.qualitest.demo.model.Car;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by UA C on 15.08.2017.
 */
@Service
public class CarService {
    @Autowired
    CarDao carDao;
    public List<Car>getAllCarsList (){
        return carDao.getAllCars();
    }

    public List<Car>getUsedCarListByUserId (int id){
        return carDao.getUsedCarListByUserId(id);
    }



}
