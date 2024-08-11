package com.example.demo.service.impl;


import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.entity.Item;
import com.example.demo.enums.MeasuringUnit;
import com.example.demo.repository.ItemRepo;
import com.example.demo.service.ItemService;
import com.example.demo.util.map.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
