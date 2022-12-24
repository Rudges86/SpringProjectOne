package com.primeiroprojetoSpring.curso.sprig.service;

import com.primeiroprojetoSpring.curso.sprig.entities.Order;
import com.primeiroprojetoSpring.curso.sprig.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }


    public Order findById(Long id){
        Optional<Order> orderId = orderRepository.findById(id);
        return orderId.get();
    }

}
