package com.rusiruchapana.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @GetMapping("/text-1")
    public String getText(){
        return "Rusiru chapana";
    }
}
