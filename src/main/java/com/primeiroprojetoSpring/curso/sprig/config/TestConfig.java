package com.primeiroprojetoSpring.curso.sprig.config;

import com.primeiroprojetoSpring.curso.sprig.entities.User;
import com.primeiroprojetoSpring.curso.sprig.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//Vai fazer o database seeding, vai servir para ir populando o banco de dados

@Configuration
@Profile("test")
//macete de implemntar a interfface, CommandLineRunner, para instar os objetos na hora que a aplicação for criadda
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria","maria@gmail.com","79456","maria123");
        User u2 = new User(null,"Chica","chiquinha@gmail.com","989891","chiquinha123");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }


}
