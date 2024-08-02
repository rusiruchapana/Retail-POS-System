package com.rusiruchapana.pos.system.service;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;

public interface ItemService {
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO);
}
