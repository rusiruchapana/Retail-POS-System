package com.rusiruchapana.pos.service;

import com.rusiruchapana.pos.dto.CustomerDTO;
import org.springframework.stereotype.Service;


public interface CustomerService {


    CustomerDTO addCustomer(CustomerDTO customerDTO);
}
