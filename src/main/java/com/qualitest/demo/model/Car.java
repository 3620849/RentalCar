package com.qualitest.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by UA C on 14.08.2017.
 */
@Getter
@Setter
@Entity
public class Car {
    @Id
    private int id;
    @JsonIgnore
    @ManyToOne
    private UserData userData;
    private String vendor;
    private String model;
    private int year;
}
