package com.qualitest.demo.dao;

import com.qualitest.demo.model.CarImage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/*
 * Created by UA C on 28.08.2017.
 */

@Repository
public class CarImageDao {
    @PersistenceContext
    EntityManager em;


    public CarImage getCarImgById(int id) {
        TypedQuery<CarImage> query = em.createQuery("SELECT ci from CarImage ci where ci.car.id=" + id, CarImage.class);
        return query.getSingleResult();
    }
}
