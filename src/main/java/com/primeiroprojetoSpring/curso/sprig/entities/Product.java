package com.primeiroprojetoSpring.curso.sprig.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    //Foi utilizado o set, para que não seja cadastrado um pedido com várias categorias
    //O HashSet é para garantir que ela não comece nula, mas sim vazia, O Set é uma interface e não pode ser instânciado.

    @ManyToMany
    @JoinTable(name ="tb_product_category",joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name="categoria_id") )
    //JoinColumns é uma tabela, e o inverse é outra tabela
    private Set<Categoria> categorias = new HashSet<>();
    @OneToMany(mappedBy = "id.product") // é mapeado por id.product, pois na classe pk existe um tipo product
    private Set<OrdemItem> items = new HashSet<>();
    public Product(){}

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }
    @JsonIgnore
    public Set<Order> getItems() {
        Set<Order> set = new HashSet<>();
        for(OrdemItem x : items){
            set.add(x.getOrder());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(imgUrl, product.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                ", categorias=" + categorias +
                ", items=" + items +
                '}';
    }
}
