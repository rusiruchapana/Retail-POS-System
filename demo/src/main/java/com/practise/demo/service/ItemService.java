package com.practise.demo.service;

import com.practise.demo.dto.request.ItemResquestDTO;
import com.practise.demo.dto.response.ItemResponseDTO;

public interface ItemService {
    ItemResponseDTO create(ItemResquestDTO itemResquestDTO);
}
