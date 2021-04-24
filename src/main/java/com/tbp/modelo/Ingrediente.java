package com.tbp.modelo;



import javax.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    
    public Ingrediente() {
        
    }

    public Ingrediente(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    
    
}
