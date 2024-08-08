package com.practise.demo.util.map;

import com.practise.demo.dto.request.ItemResquestDTO;
import com.practise.demo.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDtoToEntity(ItemResquestDTO itemResquestDTO);
}
