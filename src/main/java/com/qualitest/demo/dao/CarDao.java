package com.qualitest.demo.dao;

import com.qualitest.demo.model.Car;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
 * Created by UA C on 15.08.2017.
 */
@Repository
public class CarDao {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<Car> getUsedCarListByUserId (@NonNull int id){
        return em.createQuery("SELECT ud.carInUse from UserData ud where ud.user ='"+id+"'",Car.class).getResultList();
    }

    public List<Car> getAllCars() {
        return em.createQuery("SELECT c from Car c",Car.class).getResultList();
    }
}
