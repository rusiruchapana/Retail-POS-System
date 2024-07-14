package com.rusiruchapana.pos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    private Long customerId;
    private String customerName;
    private String customerAdress;
    private Double salary;
    private ArrayList contactNumbers;
    private String NicNumber;
    private Boolean activeStatus;

}
