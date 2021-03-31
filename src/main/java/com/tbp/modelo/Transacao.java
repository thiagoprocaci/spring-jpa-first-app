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
@Table(name = "transacao")
public class Transacao {
    
    public static final String SAQUE = "saque";
    public static final String DEPOSITO = "deposito";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "valor")
    private Double valor;

    
    public Transacao() {
        
    }

    public Transacao(Conta conta, String tipo, Double valor) {
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  tipo + ", valor = " + valor;
    }
    
    
   
}
