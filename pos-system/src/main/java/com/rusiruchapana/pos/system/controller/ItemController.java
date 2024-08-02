package com.rusiruchapana.pos.system.controller;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;
import com.rusiruchapana.pos.system.service.ItemService;
import com.rusiruchapana.pos.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @GetMapping(path = "/greeting")
    public void greeting(){
        System.out.println("Test");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> itemSaved(@RequestBody ItemRequestDTO itemRequestDTO){

        ItemResponseDTO itemResponseDTO = itemService.saveItem(itemRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201L, "Item succesfully saved", itemResponseDTO),
                HttpStatus.CREATED
        );
    }
}
