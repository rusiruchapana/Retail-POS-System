package com.example.demo.service.impl;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.request.UpdateItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.entity.Item;
import com.example.demo.enums.MeasuringUnit;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ItemRepo;
import com.example.demo.service.ItemService;
import com.example.demo.util.map.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {



    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public ItemResponseDTO create(ItemRequestDTO itemRequestDTO) {

            Item item = itemMapper.dtoToEntity(itemRequestDTO);
            item.setActiveStatus(true);
            itemRepo.save(item);

            ItemResponseDTO itemResponseDTO = itemMapper.entityToDto(item);
            return itemResponseDTO;
    }

    @Override
    public List<ItemResponseDTO> readAll() {
        List<Item> items = itemRepo.findAll();
        List<ItemResponseDTO> itemResponseDTOS = itemMapper.entityToDto(items);
        return itemResponseDTOS;
    }

    @Override
    public ItemResponseDTO readById(Long itemId) {
        Optional<Item> item = itemRepo.findById( itemId);
        if(item.isPresent()){
            throw new NotFoundException("Not found in the db.");
        }else{
            ItemResponseDTO itemResponseDTO = itemMapper.entityToDto(item.get());
            return itemResponseDTO;
        }

    }

    @Override
    public ItemResponseDTO updateItem(UpdateItemRequestDTO updateItemRequestDTO, Long itemId) {
        Optional<Item> item = itemRepo.findById(itemId);
        if(item.isPresent()){
            Item item1 = item.get();
            item1.setItemName(updateItemRequestDTO.getItemName());
            item1.setMeasuringUnit(updateItemRequestDTO.getMeasuringUnit());
            item1.setBalanceQty(updateItemRequestDTO.getBalanceQty());
            item1.setSuplierPrice(updateItemRequestDTO.getSuplierPrice());
            item1.setSellingPrice(updateItemRequestDTO.getSellingPrice());
            item1.setActiveStatus(updateItemRequestDTO.getActiveStatus());

            itemRepo.save(item1);
            ItemResponseDTO itemResponseDTO = itemMapper.entityToDto(item1);
            return itemResponseDTO;

        }else {
            throw new NotFoundException("Not found in db.");
        }

    }

    @Override
    public String deleteItem(Long itemId) {
        Optional<Item> item = itemRepo.findById(itemId);
        if(item.isPresent()){
            itemRepo.deleteById(itemId);
            return "Succesfully deleted.";
        }else {
            throw new NotFoundException("Not found in db.");
        }
    }


}
