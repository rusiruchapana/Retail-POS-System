package com.rusiruchapana.pos.system.entity;

import com.rusiruchapana.pos.system.enums.MeasuringUnitTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_table")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(name = "item_name", nullable = false, length = 30)
    private String itemName;

    @Column(name = "measuring_units", nullable = false, length = 30)
    private MeasuringUnitTypes measuringUnit;

    @Column(name = "balance_qty", nullable = false, length = 30)
    private Double balanceQty;

    @Column(name = "suplier_price", nullable = false, length = 30)
    private Double suplierPrice;

    @Column(name = "selling_price", nullable = false, length = 30)
    private Double sellingPrice;

    @Column(name = "active_status", nullable = false, length = 30)
    private Boolean activeStatus;

}
