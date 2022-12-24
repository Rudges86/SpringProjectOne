package com.primeiroprojetoSpring.curso.sprig.repositories;

import com.primeiroprojetoSpring.curso.sprig.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
