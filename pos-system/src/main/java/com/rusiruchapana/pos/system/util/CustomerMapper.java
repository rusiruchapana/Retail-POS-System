package com.rusiruchapana.pos.system.util;

import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerSpecificDetailsResponseDTO;
import com.rusiruchapana.pos.system.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<CustomerResponseDTO> entityToDto(List<Customer> customerList);
    CustomerResponseDTO entityToDto(Customer customer);
    CustomerSpecificDetailsResponseDTO entityToSpecialDto(Customer customer);
}
