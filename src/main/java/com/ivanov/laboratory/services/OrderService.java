package com.ivanov.laboratory.services;

import com.ivanov.laboratory.Repo.OrderRepo;
import com.ivanov.laboratory.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    public List<Order> getOrderList() {
       return orderRepo.findAll();
    }

    public void saveOrder(Order order) {
        orderRepo.save(order);
    }
}
