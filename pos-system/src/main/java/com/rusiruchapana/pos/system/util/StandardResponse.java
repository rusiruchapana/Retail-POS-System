package com.rusiruchapana.pos.system.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse {

    private Long code;
    private String message;
    private Object object;
}
