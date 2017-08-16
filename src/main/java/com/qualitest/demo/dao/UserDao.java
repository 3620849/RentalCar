package com.qualitest.demo.dao;

import com.qualitest.demo.model.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by UA C on 26.07.2017.
 */
@Repository
public class UserDao {


    @PersistenceContext
    EntityManager em;

      /*@Autowired
    @Qualifier("transactionManager")
    protected PlatformTransactionManager txManager;

    @PostConstruct
    private void init(){
        TransactionTemplate tmpl = new TransactionTemplate(txManager);
        tmpl.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

                User user = new User();

        user.setUsername("333");
        user.grantRole(Role.ADMIN );
        user.grantRole(Role.USER );
        PasswordEncoder pe = new BCryptPasswordEncoder();
        user.setPassword(pe.encode("123"));
        em.persist(user);

                Car car = new Car();

                car.setVendor("BMW");
                car.setModel("X6");
                car.setYear(2017);

                em.persist(car);

                UserData userData = new UserData();
                userData.setUser(user);
                userData.setUserFamily("Shanin");
                userData.setUserName("Dima");
                List<Car> lc = new ArrayList<Car>();

                lc.add(car);
                userData.setCarInUse(lc);
                em.persist( userData);
            }
        });
    }*/
    @Transactional
    public UserData getUserDataByUserId(@NonNull int id){
        TypedQuery<UserData> query =  em.createQuery("SELECT ud FROM UserData ud WHERE ud.user ='"+id+"'",UserData.class);
        return query.getSingleResult();
    }
    @Transactional
    public User findUserByName(@NonNull String name){
    TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = '"+name+"'",User.class);
        User user = null;
        try {
            user = query.getSingleResult();
        }catch (NoResultException e){
            throw new UsernameNotFoundException("USER NOT FOUND");
        }


    return user;

}

    public Optional<User> findById(int id) {
        return Optional.ofNullable(em.find(User.class,id));
    }

    @Transactional
    public void addUser(@NonNull User user) {
        em.persist(user);
    }
}
