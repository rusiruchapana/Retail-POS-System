package com.rusiruchapana.pos.system.service;

import com.rusiruchapana.pos.system.dto.request.CustomerRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;

public interface CustomerService {
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
}
