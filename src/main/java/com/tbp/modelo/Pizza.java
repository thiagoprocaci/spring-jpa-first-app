
package com.tbp.modelo;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "preco", nullable = false)
    private Double preco;

    public Pizza(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    public Pizza() {
        
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
    
    
    
}
