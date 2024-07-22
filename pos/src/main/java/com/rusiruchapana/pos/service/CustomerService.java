package com.rusiruchapana.pos.service;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.dto.request.CustomerUpdateRequest;


public interface CustomerService {


    public CustomerDTO addCustomer(CustomerDTO customerDTO);

    public CustomerDTO updateCustomer(CustomerUpdateRequest customerUpdateRequest);
}
