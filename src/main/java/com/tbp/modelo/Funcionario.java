
package com.tbp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "salario")
    private Double salario;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Funcionario(String nome, String cpf, Double salario, Empresa empresa) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.empresa = empresa;
    }

    public Funcionario() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
    
}
