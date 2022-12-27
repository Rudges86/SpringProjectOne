package com.primeiroprojetoSpring.curso.sprig.repositories;

import com.primeiroprojetoSpring.curso.sprig.entities.OrdemItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrdemItem,Long> {
}
