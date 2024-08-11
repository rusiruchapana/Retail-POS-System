package com.example.demo.service;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;

public interface ItemService {

    ItemResponseDTO create(ItemRequestDTO itemRequestDTO);
}
