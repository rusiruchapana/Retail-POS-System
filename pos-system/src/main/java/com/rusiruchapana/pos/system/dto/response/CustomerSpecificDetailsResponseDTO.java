package com.rusiruchapana.pos.system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSpecificDetailsResponseDTO {

    private Long id;
    private String adress;
    private Double salary;

}
