package com.primeiroprojetoSpring.curso.sprig.resources;

import com.primeiroprojetoSpring.curso.sprig.entities.User;
import com.primeiroprojetoSpring.curso.sprig.service.Userservice;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private Userservice service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
    List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //para retornar um created no ResponseEnttity, quando utilizamos um ResponseEntity.created(), para retornarmos um 201
    //É esperado que ele retorne um cabeçalho chamado location com o enderço do novo recurso que você inseriu
    //Ai no springboot temos uma forma padrão de fazer isso
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        user = service.insert(user);
        //forma padrão de retorno
        //path, passe o caminho, buildAndExpand -> passe o id, no final passe o toUri() para ele converter para o URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

}
