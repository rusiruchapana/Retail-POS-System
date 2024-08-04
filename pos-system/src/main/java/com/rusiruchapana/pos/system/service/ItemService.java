package com.rusiruchapana.pos.system.service;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CountOfActiveStatusInItems;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;
import com.rusiruchapana.pos.system.dto.response.PaginatedItemsResponseDTO;

import java.util.List;

public interface ItemService {
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO);
    public List<ItemResponseDTO> getAllItems();

    public List<ItemResponseDTO> getActiveItems(boolean b);

    public CountOfActiveStatusInItems activeInactiveCount();

    public PaginatedItemsResponseDTO getPaginatedItems(int page, int size);

    public PaginatedItemsResponseDTO getActiveItemsPaginatedly(int page, int size);
}
