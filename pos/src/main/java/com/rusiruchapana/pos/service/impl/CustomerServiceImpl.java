package com.rusiruchapana.pos.service.impl;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.entity.Customer;
import com.rusiruchapana.pos.repo.CustomerRepo;
import com.rusiruchapana.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAdress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNicNumber(),
                customerDTO.getContactNumbers(),
                customerDTO.getActiveStatus()
        );
        customerRepo.save(customer);

        return customerDTO;
    }
}

