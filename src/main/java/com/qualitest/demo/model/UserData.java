package com.qualitest.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
 * Created by UA C on 14.08.2017.
 */
@Getter
@Setter
@Entity
public class UserData {
    @GeneratedValue
    @Id
    private int id;
    private String userName;
    private String userFamily;
    private String userPhone;
    @OneToOne
    @JoinColumn(unique=true)
    private User user;

    @OneToMany // (mappedBy = "userData")
    private List<Car> carInUse;

}
