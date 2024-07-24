package com.rusiruchapana.pos.service;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.dto.request.CustomerUpdateRequest;

import java.util.List;


public interface CustomerService {


    public CustomerDTO addCustomer(CustomerDTO customerDTO);

    public CustomerDTO updateCustomer(CustomerUpdateRequest customerUpdateRequest);

    public CustomerDTO getCustomer(Long id);

    public List<CustomerDTO> getAllCustomers();
}
