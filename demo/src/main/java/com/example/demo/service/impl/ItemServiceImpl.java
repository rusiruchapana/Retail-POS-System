package com.example.demo.service.impl;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.entity.Item;
import com.example.demo.enums.MeasuringUnit;
import com.example.demo.repository.ItemRepo;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;


    @Override
    public ItemResponseDTO create(ItemRequestDTO itemRequestDTO) {
        Item item = new Item();
        item.setItemName(itemRequestDTO.getItemName());
        item.setMeasuringUnit(itemRequestDTO.getMeasuringUnit());
        item.setBalanceQty(itemRequestDTO.getBalanceQty());
        item.setSuplierPrice(itemRequestDTO.getSuplierPrice());
        item.setSellingPrice(itemRequestDTO.getSellingPrice());
        item.setActiveStatus(true);

        itemRepo.save(item);

        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        itemResponseDTO.setItemId(item.getItemId());
        itemResponseDTO.setItemName(item.getItemName());
        itemResponseDTO.setMeasuringUnit(item.getMeasuringUnit());
        itemResponseDTO.setBalanceQty(item.getBalanceQty());
        itemResponseDTO.setSuplierPrice(item.getSuplierPrice());
        itemResponseDTO.setSellingPrice(item.getSellingPrice());
        itemResponseDTO.setActiveStatus(item.getActiveStatus());

        return itemResponseDTO;
    }
}
