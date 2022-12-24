package com.primeiroprojetoSpring.curso.sprig.config;

import com.primeiroprojetoSpring.curso.sprig.entities.Order;
import com.primeiroprojetoSpring.curso.sprig.entities.User;
import com.primeiroprojetoSpring.curso.sprig.entities.enuns.OrderStatus;
import com.primeiroprojetoSpring.curso.sprig.repositories.OrderRepository;
import com.primeiroprojetoSpring.curso.sprig.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.time.Instant;
import java.util.Arrays;

//Vai fazer o database seeding, vai servir para ir populando o banco de dados

@Configuration
@Profile("test")
//macete de implemntar a interfface, CommandLineRunner, para instar os objetos na hora que a aplicação for criadda
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria","maria@gmail.com","79456","maria123");
        User u2 = new User(null,"Chica","chiquinha@gmail.com","989891","chiquinha123");


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.CANCELED,u2);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
    }


}
