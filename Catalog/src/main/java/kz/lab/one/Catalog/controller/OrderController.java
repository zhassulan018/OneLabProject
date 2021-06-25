package kz.lab.one.Catalog.controller;

import kz.lab.one.Catalog.models.Order;
import kz.lab.one.Catalog.models.User;
import kz.lab.one.Catalog.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/orders")
    List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/orders/{id}")
    List<Order> getAllOrdersById(@PathVariable Long id){
        return orderRepository.findAllByUserId(id);
    }

    @PostMapping("/order")
    Order updatePizza(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
