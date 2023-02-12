package com.ivanov.laboratory.utils;

import com.ivanov.laboratory.models.Task;
import com.ivanov.laboratory.services.OrderService;
import com.ivanov.laboratory.utils.Analyzators.Analyzator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.util.*;

public class ProcessingAnalyze implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private OrderService orderService;

    @Autowired
    private List<Analyzator> analyzatorList;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Queue<Task> queue = new LinkedList<>(ordersToTasks());
        while (true) {
            if (!queue.isEmpty()) {
                System.out.println(queue.poll().getAnalyze().getName());
            }
        }
    }

    public List<Task> ordersToTasks() {
        List<Task> taskList = new ArrayList<>();
        orderService.getOrderList().forEach(order -> {
            order.getAnalyzeList().forEach(analyze -> {
                taskList.add(new Task(analyze));
            });
        });
        return taskList;
    }

}
