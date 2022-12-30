package com.primeiroprojetoSpring.curso.sprig.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.primeiroprojetoSpring.curso.sprig.entities.pk.OrdemItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

//Aqui é feito o relacionamento com a chave composta, funciona como uma tabela intermediária
//Importante, quando nesse caso não temos um order direto, para evitar problema de mão dupla no jpa, vamos passar o
//@JSONignore no get Order
@Entity
@Table(name = "tb_order_item")
public class OrdemItem implements Serializable {
    private static final long serialVersionUID = 1L;
    //Essa é a anotation para chave composta
    @EmbeddedId
    //Como é a chave composta tem que instanciar para não dar erro de nullpointexception
    private OrdemItemPK id = new OrdemItemPK();
    private Integer quantidade;
    private Double preco;

    public OrdemItem(){}

    public OrdemItem(Order order, Product product,Integer quantidade, Double preco) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnor

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }


    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // para isso aqui aparecer no JSON, e o que vale na plataforma java  enterprise, é o get, então passa o get em qualquer metódo
    public Double getSubTotal(){
        return preco * quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return Objects.equals(id, ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
