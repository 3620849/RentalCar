package com.qualitest.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by UA C on 14.08.2017.
 */
@Getter
@Setter
@Entity
public class UserData {

    @Id
    private int id;
    private String userName;
    private String userFamily;
    private String userPhone;
    @OneToOne
    private User user;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany/*(mappedBy = "userData")*/
    private List<Car> carInUse;

}
