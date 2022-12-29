package com.primeiroprojetoSpring.curso.sprig.config;

import com.primeiroprojetoSpring.curso.sprig.entities.*;
import com.primeiroprojetoSpring.curso.sprig.entities.enuns.OrderStatus;
import com.primeiroprojetoSpring.curso.sprig.repositories.*;
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

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null,"Fulano");
        Categoria cat2 = new Categoria(null,"Sicrano");
        Categoria cat3 = new Categoria(null,"Beltrano");

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        User u1 = new User(null,"Maria","maria@gmail.com","79456","maria123");
        User u2 = new User(null,"Chica","chiquinha@gmail.com","989891","chiquinha123");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.CANCELED,u2);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));

        Product p1 = new Product(null,"The Lord of the Rings","lorem ipsum",500.5,"");
        Product p2 = new Product(null,"PC gamer","lorem ipsum",90.5,"");
        productRepository.saveAll(Arrays.asList(p1,p2));


        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);

        productRepository.saveAll(Arrays.asList(p1,p2));

        OrdemItem oi1 = new OrdemItem(o1,p1,2,p1.getPrice());
        OrdemItem oi2 = new OrdemItem(o2,p2,1,p2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),o1);
        //nas relações 1 para 1 não fazemos o save do repository na dependente
        o1.setPayment(pay1);
        //salvo em memória no o1 e o jpa tratara de salvar o pedido
        orderRepository.save(o1);
    }


}
