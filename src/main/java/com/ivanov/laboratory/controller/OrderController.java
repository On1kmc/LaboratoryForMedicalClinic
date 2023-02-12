package com.ivanov.laboratory.controller;

import com.ivanov.laboratory.models.Order;
import com.ivanov.laboratory.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new-order")
public class OrderController {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> measuring(@RequestBody Order order, BindingResult bindingResult) {
        orderService.saveOrder(order);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
