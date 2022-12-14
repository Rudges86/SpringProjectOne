package com.primeiroprojetoSpring.curso.sprig.repositories;

import com.primeiroprojetoSpring.curso.sprig.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
