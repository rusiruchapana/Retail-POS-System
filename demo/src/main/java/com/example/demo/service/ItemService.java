package com.example.demo.service;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {

    ItemResponseDTO create(ItemRequestDTO itemRequestDTO);


    List<ItemResponseDTO> readAll();
}
