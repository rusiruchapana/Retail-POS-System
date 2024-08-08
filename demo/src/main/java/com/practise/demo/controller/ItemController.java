package com.practise.demo.controller;


import com.practise.demo.dto.request.ItemResquestDTO;
import com.practise.demo.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    @PostMapping(path = "/create-item")
    public ResponseEntity<StandardResponse> createItem(@RequestBody ItemResquestDTO itemResquestDTO){
        return null;
    }

}
