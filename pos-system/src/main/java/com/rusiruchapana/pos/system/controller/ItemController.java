package com.rusiruchapana.pos.system.controller;

import com.rusiruchapana.pos.system.dto.request.ItemRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CountOfActiveStatusInItems;
import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;
import com.rusiruchapana.pos.system.dto.response.PaginatedItemsResponseDTO;
import com.rusiruchapana.pos.system.service.ItemService;
import com.rusiruchapana.pos.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/all-items")
    public ResponseEntity<StandardResponse> getAllItems(){
        List<ItemResponseDTO> itemResponseDTOList = itemService.getAllItems();
        return new ResponseEntity<>(
                new StandardResponse(200L, "Recieved all items.",itemResponseDTOList),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/items-by-status" , params = "status")
    public ResponseEntity<StandardResponse> getAllItemsByStatus(@RequestParam("status") String state){
        if(state.equalsIgnoreCase("active") || state.equalsIgnoreCase("inactive")){
            if(state.equalsIgnoreCase("active")){
                List<ItemResponseDTO> itemResponseDTOList = itemService.getActiveItems(true);
                return new ResponseEntity<>(
                        new StandardResponse(200L, "Active items", itemResponseDTOList),
                        HttpStatus.OK
                );
            }

            List<ItemResponseDTO> itemResponseDTOList = itemService.getActiveItems(false);
            return new ResponseEntity<>(
                    new StandardResponse(200L, "Inactive items.", itemResponseDTOList),
                    HttpStatus.OK
            );

        }else {
                List<ItemResponseDTO> itemResponseDTOList = itemService.getAllItems();
                return new ResponseEntity<>(
                        new StandardResponse(200L, "All items", itemResponseDTOList),
                        HttpStatus.OK
                );
        }
    }

    @GetMapping(path = "/state-count")
    public ResponseEntity<StandardResponse> countOfState(){
        System.out.println("sdsd");
        CountOfActiveStatusInItems count = itemService.activeInactiveCount();
        return new ResponseEntity<>(
                new StandardResponse(200L,"Counts",count),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/items-paginated" , params = {"page","size"})
    public ResponseEntity<StandardResponse> getItemsPaginatedly(
            @RequestParam("page")int page ,
            @RequestParam("size")int size)
    {
        PaginatedItemsResponseDTO paginatedItemsResponseDTO = itemService.getPaginatedItems(page,size);
        return new ResponseEntity<>(
                new StandardResponse(200L, "Succesfully get.", paginatedItemsResponseDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/active-items-paginatedly" , params = {"page","size"})
    public ResponseEntity<StandardResponse> getActiveItemsPaginatedly(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        System.out.println("sdsds");
        PaginatedItemsResponseDTO paginatedItemsResponseDTO = itemService.getActiveItemsPaginatedly(page , size);
        return new ResponseEntity<>(
                new StandardResponse(200L, "Sucessfully get", paginatedItemsResponseDTO),
                HttpStatus.OK
        );
    }

}
