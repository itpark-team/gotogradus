package com.example.gotogradus.controllers;

import com.example.gotogradus.dtos.RequestOrderDto;
import com.example.gotogradus.services.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrdersController {
    private OrdersService ordersService;

    @PostMapping("make-order")
    public void makeOrder(@RequestBody RequestOrderDto requestOrderDto) {
        ordersService.makeOrder(requestOrderDto);
    }
}
