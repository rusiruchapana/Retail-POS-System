package com.rusiruchapana.pos.system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountOfActiveStatusInItems {

    private int ActiveCount;
    private int InactiveCount;


}
