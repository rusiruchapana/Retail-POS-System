package com.rusiruchapana.pos.system.util;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;
import com.rusiruchapana.pos.system.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDTOToEntity(ItemRequestDTO itemRequestDTO);
    ItemResponseDTO entityToResponseDTO(Item item);
    List<ItemResponseDTO> entityToDTO(List<Item> itemList);
}
