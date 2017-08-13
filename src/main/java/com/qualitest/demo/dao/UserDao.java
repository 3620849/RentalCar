package com.qualitest.demo.dao;

import com.qualitest.demo.model.User;
import com.qualitest.demo.model.UserAutority;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by UA C on 26.07.2017.
 */
@Repository
public class UserDao {
    @PersistenceContext
    EntityManager em;
    public User findUserByName(@NonNull String name){
    TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = '"+name+"'",User.class);
        User user = null;
        try {
            user = query.getSingleResult();
        }catch (NoResultException e){
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
   // System.out.println(user + "userAut="+user.getAuthorities().get(0).getAuthority());

    return user;

}
    public Optional<User> findById(int id) {
        return Optional.ofNullable(em.find(User.class,id));
    }
}
