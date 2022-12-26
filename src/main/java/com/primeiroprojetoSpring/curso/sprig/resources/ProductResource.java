package com.primeiroprojetoSpring.curso.sprig.resources;

import com.primeiroprojetoSpring.curso.sprig.entities.Product;
import com.primeiroprojetoSpring.curso.sprig.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> prod = productService.findAll();
        return ResponseEntity.ok().body(prod);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Long id){
        Product prod = productService.findById(id);
        return ResponseEntity.ok().body(prod);
    }

}
