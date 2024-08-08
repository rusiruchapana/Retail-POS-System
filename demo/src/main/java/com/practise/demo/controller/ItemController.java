package com.practise.demo.controller;


import com.practise.demo.dto.request.ItemResquestDTO;
import com.practise.demo.dto.response.ItemResponseDTO;
import com.practise.demo.service.ItemService;
import com.practise.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/create-item")
    public ResponseEntity<StandardResponse> createItem(@RequestBody ItemResquestDTO itemResquestDTO){
        ItemResponseDTO itemResponseDTO = itemService.create(itemResquestDTO);
        return null;
    }

}
