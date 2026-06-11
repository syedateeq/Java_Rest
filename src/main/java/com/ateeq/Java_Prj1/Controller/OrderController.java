package com.ateeq.Java_Prj1.Controller;

import com.ateeq.Java_Prj1.model.Order;
import com.ateeq.Java_Prj1.repository.OrderRepository;
import com.ateeq.Java_Prj1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/place")
    public String placeOrder(
            @RequestParam int customerId,
            @RequestParam int menuItemId,
            @RequestParam int quantityOrdered
    ) {
        return orderService.placeOrder(customerId, menuItemId, quantityOrdered);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}