package com.example.demo.service;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.entity.Item;

public interface ItemService {


    ItemResponseDTO create(ItemRequestDTO itemRequestDTO);
}
