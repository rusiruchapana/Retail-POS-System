package com.rusiruchapana.pos.service;

import com.rusiruchapana.pos.dto.CustomerDTO;
import javassist.NotFoundException;

import java.util.List;


public interface CustomerService {


    public CustomerDTO addCustomer(CustomerDTO customerDTO);

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws NotFoundException;

    public CustomerDTO getCustomer(Long id) throws NotFoundException;

    public List<CustomerDTO> getAllCustomers() throws NotFoundException;

    public Boolean deleteCustomer(Long id) throws NotFoundException;

    public List<CustomerDTO> find_by_names(String name) throws NotFoundException;
}
