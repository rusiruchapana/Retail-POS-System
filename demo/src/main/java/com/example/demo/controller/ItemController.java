package com.example.demo.controller;



import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.service.ItemService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/item-create")
    public ResponseEntity<StandardResponse> create(@RequestBody ItemRequestDTO itemRequestDTO){

        return null;
    }

}
