package com.primeiroprojetoSpring.curso.sprig.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.primeiroprojetoSpring.curso.sprig.entities.enuns.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_pedido")
public class Order  implements Serializable {
    private static  final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;
    private Integer orderStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;

    //Fazendo o relacionamento da tabela
    //Aqui estamos estabelecendo uma relação muitos para 1, visto que poderemos ter muitos pedidos para 1 usuário
    @ManyToOne
    @JoinColumn(name = "client_id")  //juntando a coluna, e passando a chave estrangeira
    private User client;

    public Order(){}

    public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, client);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
