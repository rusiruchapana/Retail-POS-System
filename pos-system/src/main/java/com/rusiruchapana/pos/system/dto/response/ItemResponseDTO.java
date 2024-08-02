package com.rusiruchapana.pos.system.dto.response;

import com.rusiruchapana.pos.system.enums.MeasuringUnitTypes;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    private Long itemId;
    private String itemName;
    private MeasuringUnitTypes measuringUnit;
    private Double balanceQty;
    private Double suplierPrice;
    private Double sellingPrice;
    private Boolean activeStatus;
}
