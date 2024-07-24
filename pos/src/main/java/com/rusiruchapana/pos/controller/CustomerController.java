package com.rusiruchapana.pos.controller;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.dto.request.CustomerUpdateRequest;
import com.rusiruchapana.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/test")
    public String getText(){
        return "Rusiru chapana";
    }

    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = customerService.addCustomer(customerDTO);

        return customerDTO1;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        CustomerDTO customerDTO = customerService.updateCustomer(customerUpdateRequest );

        return null;
    }

    @GetMapping(path = "/get_customer/{customer_id}")
    public CustomerDTO get_one_customer(@PathVariable("customer_id") Long id){
        
        CustomerDTO customerDTO = customerService.getCustomer(id);
        return customerDTO;
    }



}
