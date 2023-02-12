package com.ivanov.laboratory.services;

import com.ivanov.laboratory.Repo.OrderRepo;
import com.ivanov.laboratory.dto.OrderDTO;
import com.ivanov.laboratory.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    private final TaskService taskService;

    private final AnalyzeService analyzeService;

    @Autowired
    public OrderService(OrderRepo orderRepo, TaskService taskService, AnalyzeService analyzeService) {
        this.orderRepo = orderRepo;
        this.taskService = taskService;
        this.analyzeService = analyzeService;
    }


    public void saveOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setAnalyzeList(analyzeService.getAnalyzesById(orderDTO.getAnalyzeIds()));
        orderRepo.save(order);
        taskService.createTaskListToOrder(order);
    }


}
