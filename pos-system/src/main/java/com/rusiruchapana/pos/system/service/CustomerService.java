package com.rusiruchapana.pos.system.service;

import com.rusiruchapana.pos.system.dto.request.CustomerNameRequestByQueryDTO;
import com.rusiruchapana.pos.system.dto.request.CustomerRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerNameResponseDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    public List<CustomerResponseDTO> getAllCustomers();

    public String deleteCustomer(Long id);
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO, Long id);

    public List<CustomerResponseDTO> getActiveCustomers();

    public List<CustomerNameResponseDTO> getActiveCustomersNames();

    String updateCustomersByQuery(CustomerNameRequestByQueryDTO customerNameRequestByQueryDTO, Long id);
}
