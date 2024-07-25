package com.rusiruchapana.pos.controller;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.service.CustomerService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/test")
    public String getText() {
        return "Rusiru chapana";
    }

    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerDTO1 = customerService.addCustomer(customerDTO);
        return customerDTO1;
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO) throws NotFoundException {
        CustomerDTO customerDTO1 = customerService.updateCustomer(customerDTO);
        return null;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerDTO> get_all_customers() throws NotFoundException {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return customerDTOList;
    }

    @GetMapping(path = "/get-customer/{customer_id}")
    public CustomerDTO get_one_customer(@PathVariable("customer_id") Long id) throws NotFoundException {
        CustomerDTO customerDTO = customerService.getCustomer(id);
        return customerDTO;
    }

    @DeleteMapping(path = "/delete-customer", params = "customer_id")
    public String delete_one_customer(@RequestParam("customer_id") Long id) throws NotFoundException {
        Boolean is_deleted = customerService.deleteCustomer(id);
        return "Deleted";
    }

    @GetMapping(path = "/get_customers_by_name" , params = "customer_name")
    public List<CustomerDTO> get_all_by_name(@RequestParam("customer_name") String name) throws NotFoundException {
        List<CustomerDTO> customerDTOList = customerService.find_by_names(name);
        return customerDTOList;
    }


}
