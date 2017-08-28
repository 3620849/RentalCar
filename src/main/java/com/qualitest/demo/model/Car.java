package com.qualitest.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

/*
 * Created by UA C on 14.08.2017.
 */
@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne (fetch = FetchType.LAZY)
    private UserData userData;
    private String vendor;
    private String model;
    private int year;
    private String description;
    /*@JsonIgnore
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="image")
    private byte[] image;*/
}
