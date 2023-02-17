package com.ivanov.laboratory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanov.laboratory.dto.OrderDTO;
import com.ivanov.laboratory.dto.TaskDTOForStatus;
import com.ivanov.laboratory.models.Order;
import com.ivanov.laboratory.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/new-order")
public class OrderController {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createOrder(@RequestBody OrderDTO order, BindingResult bindingResult) {

        orderService.saveOrder(order);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public HttpEntity<Object> getStatuses(@RequestParam long id) throws JsonProcessingException {
        Order order = orderService.findByOrderId(id);
        ArrayList<TaskDTOForStatus> statusList = new ArrayList<>();
        order.getTaskList().forEach(task -> {
            TaskDTOForStatus status = new TaskDTOForStatus();
            status.setName(task.getAnalyze().getName());
            status.setStatus(task.getDone());
            statusList.add(status);
        });
        ObjectMapper mapper = new ObjectMapper();
        String s;
        s = mapper.writeValueAsString(statusList);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(s, headers);
    }

}
