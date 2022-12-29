package com.primeiroprojetoSpring.curso.sprig.service;

import com.primeiroprojetoSpring.curso.sprig.entities.User;
import com.primeiroprojetoSpring.curso.sprig.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    };


    public User findById(Long id){
        Optional<User> find = userRepository.findById(id);
        return find.get();
    }

    public User insert (User obj){
       return userRepository.save(obj);
    }

    public void delete (Long id ){
        userRepository.deleteById(id);
    }


    public User update (Long id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity,obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
