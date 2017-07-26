package com.qualitest.demo.dao;

import com.qualitest.demo.model.User;
import com.qualitest.demo.model.UserAutority;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by UA C on 26.07.2017.
 */
@Repository
public class UserDao {
    @PersistenceContext
    EntityManager em;
public Optional<User> findUserByName(@NonNull String name){

    User user = (User)em.createQuery("SELECT u FROM User u WHERE u.username ="+name).getSingleResult();
    if(user!=null){
       List<UserAutority> autorities= (List<UserAutority>)em.createQuery("SELECT ua FROM UserAutority ua WHERE ua.User.Id ="+user.getId()).getResultList();
        user.setAuthorities(autorities);
    }
    System.out.println(user);
    return Optional.ofNullable(user);

}

}
