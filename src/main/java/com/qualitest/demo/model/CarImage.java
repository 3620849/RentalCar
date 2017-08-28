package com.qualitest.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

/*
 * Created by UA C on 28.08.2017.
 */
@Data
@Entity
public class CarImage {
    @Id
    @GeneratedValue
    int id;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    String alt;
    String name;
    @OneToOne(fetch = FetchType.LAZY)
    Car car;
//    @JsonIgnore
//    @OneToOne(fetch = FetchType.LAZY)
//    Car car;
}
