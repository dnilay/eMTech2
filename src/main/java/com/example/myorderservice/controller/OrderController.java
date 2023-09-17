package com.example.myorderservice.controller;

import com.example.myorderservice.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

private List<Order> list=null;
    {
        list=new ArrayList<Order>();
        list.add(new Order(1,"Pen"));
        list.add(new Order(2,"pencil"));
    }



    @GetMapping("/orders")
    public List<Order> getAllOrders()
    {
        return list;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order)
    {
        list.add(order);
        return order;
    }


}
