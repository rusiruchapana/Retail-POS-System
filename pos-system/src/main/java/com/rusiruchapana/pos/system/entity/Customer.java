package com.rusiruchapana.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_table")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_name",nullable = false)
    private String name;

    @Column(name = "customer_adress",nullable = false)
    private String adress;

    @Column(name = "customer_salary",nullable = false)
    private Double salary;

    @Column(name = "customer_contact_numbers",nullable = false)
    @Convert(converter = ListToJsonConverter.class)
    private ArrayList contactNumbers;

    @Column(name = "customer_nic",nullable = false,unique = true)
    private String nic;

    @Column(name = "customer_active",nullable = false)
    private Boolean activeStatus;
}
