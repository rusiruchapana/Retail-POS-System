package com.example.demo.service;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.request.UpdateItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.dto.response.PaginatedItemResponseDTO;

import java.util.List;

public interface ItemService {

    ItemResponseDTO create(ItemRequestDTO itemRequestDTO);


    List<ItemResponseDTO> readAll();

    ItemResponseDTO readById(Long itemId);


    ItemResponseDTO updateItem(UpdateItemRequestDTO updateItemRequestDTO, Long itemId);

    String deleteItem(Long itemId);

    PaginatedItemResponseDTO getItemsPaginatedly(int page, int size);
}
