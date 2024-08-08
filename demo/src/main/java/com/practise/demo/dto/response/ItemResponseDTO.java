package com.practise.demo.dto.response;
import com.practise.demo.enums.MeasuringUnits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    private Long itemId;
    private String itemName;
    private MeasuringUnits measuringUnit;
    private Double balanceQty;
    private Double suplierPrice;
    private Double sellingPrice;
    private Boolean activeStatus;
}
