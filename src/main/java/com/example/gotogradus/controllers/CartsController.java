package com.example.gotogradus.controllers;

import com.example.gotogradus.dtos.InsertToCartDto;
import com.example.gotogradus.dtos.ShowUserCartDto;
import com.example.gotogradus.services.CartsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartsController {
    private CartsService cartsService;

    @PostMapping("add-new")
    public void addNew(@RequestBody InsertToCartDto insertToCartDto) {
        cartsService.addNew(insertToCartDto);
    }

    @GetMapping("get-by-userid/{userId}")
    public List<ShowUserCartDto> getCartByUserId(@PathVariable int userId) {
        return cartsService.getCartByUserId(userId);
    }
}
