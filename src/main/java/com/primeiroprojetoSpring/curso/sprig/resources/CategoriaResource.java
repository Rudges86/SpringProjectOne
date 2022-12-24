package com.primeiroprojetoSpring.curso.sprig.resources;

import com.primeiroprojetoSpring.curso.sprig.entities.Categoria;
import com.primeiroprojetoSpring.curso.sprig.entities.Order;
import com.primeiroprojetoSpring.curso.sprig.service.CategoriaService;
import com.primeiroprojetoSpring.curso.sprig.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categoria = service.findAll();
        return ResponseEntity.ok().body(categoria);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);

    }
}
