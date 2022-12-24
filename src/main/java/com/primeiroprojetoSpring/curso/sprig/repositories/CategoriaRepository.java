package com.primeiroprojetoSpring.curso.sprig.repositories;

import com.primeiroprojetoSpring.curso.sprig.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
