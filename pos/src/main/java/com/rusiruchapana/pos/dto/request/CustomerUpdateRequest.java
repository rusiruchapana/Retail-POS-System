package com.rusiruchapana.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerUpdateRequest {
    private Long customerId;
    private String customerName;
    private String customerAdress;
    private Double customerSalary;
    private String nicNumber;
    private ArrayList<String> contactNumbers;
    private Boolean activeStatus;
}
