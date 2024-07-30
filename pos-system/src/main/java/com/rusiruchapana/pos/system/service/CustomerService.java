package com.rusiruchapana.pos.system.service;

import com.rusiruchapana.pos.system.dto.request.CustomerNameRequestByQueryDTO;
import com.rusiruchapana.pos.system.dto.request.CustomerRequestDTO;
import com.rusiruchapana.pos.system.dto.request.CustomerSpecificDetailsRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerNameResponseDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerSpecificDetailsResponseDTO;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    public List<CustomerResponseDTO> getAllCustomers();

    public String deleteCustomer(Long id);
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO, Long id);

    public List<CustomerResponseDTO> getActiveCustomers();

    public List<CustomerNameResponseDTO> getActiveCustomersNames();

    String updateCustomersByQuery(CustomerNameRequestByQueryDTO customerNameRequestByQueryDTO, Long id);

    public CustomerResponseDTO getCustomersByNic(String nic);

    public CustomerSpecificDetailsResponseDTO getDetails(Long id);

    public void updateSpecificCustomerDetails(CustomerSpecificDetailsRequestDTO customerSpecificDetailsRequestDTO, Long id);

    public String findActiveOrNot(Long id);
}
