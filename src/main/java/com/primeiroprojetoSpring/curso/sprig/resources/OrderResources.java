package com.primeiroprojetoSpring.curso.sprig.resources;
import com.primeiroprojetoSpring.curso.sprig.entities.Order;
import com.primeiroprojetoSpring.curso.sprig.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderResources {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> order = service.findAll();
        return ResponseEntity.ok().body(order);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);

    }

}
