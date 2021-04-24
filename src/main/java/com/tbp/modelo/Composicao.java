
package com.tbp.modelo;

import javax.persistence.*;

@Entity
@Table(name = "pizza_ingrediente")
public class Composicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_pizza", nullable = false)
    private Pizza pizza;
    @ManyToOne
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingrediente ingrediente;
    
    public Composicao() {
        
    }

    public Composicao(Pizza pizza, Ingrediente ingrediente) {
        this.pizza = pizza;
        this.ingrediente = ingrediente;
    }

    public Integer getId() {
        return id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }
    
    
    
        
}
