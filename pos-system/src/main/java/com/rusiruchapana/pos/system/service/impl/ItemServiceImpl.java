package com.rusiruchapana.pos.system.service.impl;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CountOfActiveStatusInItems;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;
import com.rusiruchapana.pos.system.entity.Item;
import com.rusiruchapana.pos.system.exception.EntryDuplicationException;
import com.rusiruchapana.pos.system.repository.ItemRepo;
import com.rusiruchapana.pos.system.service.ItemService;
import com.rusiruchapana.pos.system.util.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;



    @Override
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO) {
        Item item = itemMapper.requestDTOToEntity(itemRequestDTO);
        item.setActiveStatus(true);

        itemRepo.save(item);
        System.out.println(itemRepo.existsById(item.getItemId()));
        return itemMapper.entityToResponseDTO(item);
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<Item> itemList = itemRepo.findAll();
        return itemMapper.entityToDTO(itemList);
    }

    @Override
    public List<ItemResponseDTO> getActiveItems(boolean b) {
        List<Item> itemList = itemRepo.findAllByActiveStatusEquals(b);
        return itemMapper.entityToDTO(itemList);
    }

    @Override
    public CountOfActiveStatusInItems activeInactiveCount() {
        List<Item> itemList = itemRepo.findAll();
        List<Item> activeItemList = itemRepo.findAllByActiveStatusEquals(true);

        int totalItemsCount = itemList.size();
        int activeItemsCount = activeItemList.size();
        int inactiveItemsCount = (totalItemsCount-activeItemsCount);

        CountOfActiveStatusInItems countOfActiveStatusInItems = new CountOfActiveStatusInItems(
                activeItemsCount,
                inactiveItemsCount
        );
        return countOfActiveStatusInItems;
    }


}

