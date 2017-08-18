package com.qualitest.demo.dao;

import com.qualitest.demo.model.User;
import com.qualitest.demo.model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by UA C on 18.08.2017.
 */
@Repository
public class UserDataDao {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addUserData(UserData userData){
        em.persist(userData);
    }
}
