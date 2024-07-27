package com.rusiruchapana.pos.system.controller;

import com.rusiruchapana.pos.system.dto.request.CustomerRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;
import com.rusiruchapana.pos.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/create-customer")
    public CustomerResponseDTO createCustomers(@RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customerRequestDTO);
        return customerResponseDTO;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerResponseDTO> getAllCustomers(){
        List<CustomerResponseDTO> customerResponseDTOList = customerService.getAllCustomers();
        return customerResponseDTOList;
    }

    @DeleteMapping(path = "/delete-single-customer", params = "customerId")
    public String deleteCustomers(@RequestParam("customerId") Long id){
        String msg = customerService.deleteCustomer(id);
        return msg;
    }

}
