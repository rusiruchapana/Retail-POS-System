package com.rusiruchapana.pos.util;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    List<CustomerDTO> entity_to_dto(List<Customer> customers);
    CustomerDTO entity_to_dto(Customer customer);

}
