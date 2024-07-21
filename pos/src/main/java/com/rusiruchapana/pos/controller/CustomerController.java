package com.rusiruchapana.pos.controller;

import com.rusiruchapana.pos.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @GetMapping("/text-1")
    public String getText(){
        return "Rusiru chapana";
    }

    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO.getCustomerName());
        System.out.println(customerDTO.getContactNumbers());

        return null;
    }
}
