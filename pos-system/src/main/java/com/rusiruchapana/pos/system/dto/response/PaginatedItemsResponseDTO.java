package com.rusiruchapana.pos.system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedItemsResponseDTO {

    private List<ItemResponseDTO> itemResponseDTOList;
    private Double itemAmounts;
}
