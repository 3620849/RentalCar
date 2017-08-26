package com.qualitest.demo.dbTestFiller;

import com.qualitest.demo.dao.UserDataDao;
import com.qualitest.demo.model.*;
import com.qualitest.demo.services.UserDataService;
import com.qualitest.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Created by UA C on 25.08.2017.
 */

@Service
public class StorageTestService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    UserService userService;
    @Autowired
    UserDataDao userDataDao;



    @Autowired
    @Qualifier("transactionManager")
    protected PlatformTransactionManager txManager;

    @PostConstruct
    private void init(){
        ArrayList<User> arrUser  = new ArrayList<>();

        User user = new User();
        user.setUsername("1@1.com");
        user.setPassword("1");
        user.grantRole(Role.ROLE_USER);
        userService.addNewUser(user);

        User user2 = new User();
        user2.setUsername("2@2.com");
        user2.setPassword("2");
        user2.grantRole(Role.ROLE_ADMIN);
        userService.addNewUser(user2);

        User user3 = new User();
        user3.setUsername("3@3.com");
        user3.setPassword("3");
        user3.grantRole(Role.ROLE_ANONYMOUS);
        userService.addNewUser(user3);
        arrUser.add(user);
        arrUser.add(user2);
        arrUser.add(user3);

        TransactionTemplate tmpl = new TransactionTemplate(txManager);
        tmpl.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                ArrayList<String> arr  = new ArrayList<>();
                arr.add("Infinity DSd 2017");
                arr.add("BMW X6 2015");
                arr.add("Ford H32 2015");
                arr.add("Ford H32red 2015");
                arr.add("Acura MDX 2017");
                arr.add("BMW X5 2017");
                arr.add("Mercedes GL 2016");



               for(int i=0;i<7;++i) {
                   Car car = create7cars(arr,i);
                   em.persist(car);

                   if(i<3){
                   UserData userData = new UserData();
                   userData.setUser(arrUser.get(i));
                   userData.setUserName("John");
                   List<Car> cl = new LinkedList<>();
                   car.setId(i+1);
                   cl.add(car);
                   userData.setCarInUse(cl);
                   userData.setUserPhone("5536921");
                   userDataDao.addUserData(userData);
                   }
               }
            };
        });
    }
    public Car create7cars( ArrayList<String> arr,int num){

        ClassLoader classLoader = getClass().getClassLoader();
        String [] elem = arr.get(num).split(" ");
        File file = new File(classLoader.getResource("carImg/"+num+".png").getFile());
        byte[] img = null;
        Car car = new Car();
        try {
            img = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        car.setVendor(elem[0]);
        car.setModel(elem[1]);
        car.setYear(Integer.parseInt(elem[2]));
        car.setDescription("cool car "+num);
        car.setImage(img);
        return car;
    }
}
