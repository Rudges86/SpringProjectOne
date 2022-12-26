package com.primeiroprojetoSpring.curso.sprig.repositories;

import com.primeiroprojetoSpring.curso.sprig.entities.Categoria;
import com.primeiroprojetoSpring.curso.sprig.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
