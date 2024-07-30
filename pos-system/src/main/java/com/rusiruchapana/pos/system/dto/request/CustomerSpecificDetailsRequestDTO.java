package com.rusiruchapana.pos.system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSpecificDetailsRequestDTO {

    private String name;
    private Double salary;
    private String nic;

}
