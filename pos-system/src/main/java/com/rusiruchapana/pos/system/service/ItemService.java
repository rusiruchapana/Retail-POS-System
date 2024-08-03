package com.rusiruchapana.pos.system.service;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO);
    public List<ItemResponseDTO> getAllItems();

    public List<ItemResponseDTO> getActiveItems(boolean b);
}
