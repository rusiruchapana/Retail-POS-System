package com.rusiruchapana.pos.system.dto.request;

import com.rusiruchapana.pos.system.enums.MeasuringUnitTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {

    private String itemName;
    private MeasuringUnitTypes measuringUnit;
    private Double balanceQty;
    private Double suplierPrice;
    private Double sellingPrice;

}
