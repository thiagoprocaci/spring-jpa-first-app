package com.tbp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "turma")
public class Turma  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "descricao")
    String descricao;

    @OneToMany(mappedBy = "turma")
    Set<Aluno> alunos = new HashSet<Aluno>();
    @OneToMany(mappedBy = "turma")
    Set<Alocacao> alocacoes = new HashSet<Alocacao>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Alocacao> getAlocacoes() {
        return alocacoes;
    }

    public void setAlocacoes(Set<Alocacao> alocacoes) {
        this.alocacoes = alocacoes;
    }
}

