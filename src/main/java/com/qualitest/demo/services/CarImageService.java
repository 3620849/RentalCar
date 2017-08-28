package com.qualitest.demo.services;

import com.qualitest.demo.dao.CarImageDao;
import com.qualitest.demo.model.CarImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by UA C on 28.08.2017.
 */
@Service
public class CarImageService {
    @Autowired
    CarImageDao carImageDao;

    public CarImage getCarImgById(int id) {
        return carImageDao.getCarImgById(id);
    }
}
