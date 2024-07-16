package com.rusiruchapana.pos.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

import java.util.ArrayList;


@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @Column(name = "customer_id",length = 45)
    private Long customerId;
    @Column(name = "customer_name",nullable = false,length = 100)
    private String customerName;
    @Column(name = "customer_adress",length = 100)
    private String customerAdress;
    @Column(name = "customer_salary",length = 10)
    private Double customerSalary;
    @Column(name = "nic_number",nullable = false,unique = true)
    private String nicNumber;
    @Convert(converter = ContactNumbersConverter.class)
    private ArrayList<String> contactNumbers;

    @Column(name = "active_status")
    private Boolean activeStatus;

}
