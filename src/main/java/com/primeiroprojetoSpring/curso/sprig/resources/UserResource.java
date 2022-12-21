package com.primeiroprojetoSpring.curso.sprig.resources;

import com.primeiroprojetoSpring.curso.sprig.entities.User;
import com.primeiroprojetoSpring.curso.sprig.service.Userservice;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private Userservice service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> findAll(){
    List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

}
