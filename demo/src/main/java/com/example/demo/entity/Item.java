package com.example.demo.entity;

import com.example.demo.enums.MeasuringUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_name")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private MeasuringUnit measuringUnit;

    @Column(nullable = false)
    private Double balanceQty;

    @Column(nullable = false)
    private Double suplierPrice;

    @Column(nullable = false)
    private Double sellingPrice;

    @Column(nullable = false)
    private Boolean activeStatus;

}
