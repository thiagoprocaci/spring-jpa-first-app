package com.tbp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "nome")
    String nome;
    @ManyToMany
    @JoinTable(name = "disciplina_professor",
            joinColumns = { @JoinColumn(name = "iddisciplina") },
            inverseJoinColumns = { @JoinColumn(name = "idprofessor") })
    Set<Professor> professores = new HashSet<Professor>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }
}
