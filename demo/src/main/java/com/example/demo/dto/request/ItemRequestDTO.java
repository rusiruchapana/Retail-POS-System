package com.example.demo.dto.request;


import com.example.demo.enums.MeasuringUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {

    private String itemName;
    private MeasuringUnit measuringUnit;
    private Double balanceQty;
    private Double suplierPrice;
    private Double sellingPrice;
}
