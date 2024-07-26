package com.rusiruchapana.pos.system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {

    private Long id;
    private String name;
    private String adress;
    private Double salary;
    private ArrayList contactNumbers;
    private String nic;
    private Boolean activeStatus;
}
