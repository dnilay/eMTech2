package com.example.myorderservice.controller;

import com.example.myorderservice.Order;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/orders/{orderId}")
    public Order getOrderById(@PathVariable("orderId") int orderId)
    {
        Order order=null;
        for(Order o: list)
        {
            if(o.getOrderId()==orderId)
            {
                order=o;

                break;
            }

        }
        return order;
    }


}
