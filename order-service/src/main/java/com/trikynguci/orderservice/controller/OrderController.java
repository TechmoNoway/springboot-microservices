package com.trikynguci.orderservice.controller;

import com.trikynguci.orderservice.UserClient;
import com.trikynguci.orderservice.dto.UserDto;
import com.trikynguci.orderservice.dto.response.OrderResponse;
import com.trikynguci.orderservice.model.Order;
import com.trikynguci.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    public OrderController(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){
        Order order = orderRepository.findById(id).orElseThrow();

        UserDto user = userClient.getUserById(order.getUserId());

        return new OrderResponse(order.getId(), order.getProduct(), order.getPrice(), user);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }




}
