package com.qualitest.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
 * Created by UA C on 14.08.2017.
 */
@Data
@Entity
@Table(name = "user_data")
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

    @OneToMany  (mappedBy = "userData" ,fetch = FetchType.LAZY)
    private List<Car> carInUse;

}
