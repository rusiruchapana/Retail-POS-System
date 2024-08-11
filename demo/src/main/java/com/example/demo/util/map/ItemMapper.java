package com.example.demo.util.map;

import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item dtoToEntity(ItemRequestDTO itemRequestDTO);
    ItemResponseDTO entityToDto(Item item);
    List<ItemResponseDTO> entityToDto(List<Item> items);
}
