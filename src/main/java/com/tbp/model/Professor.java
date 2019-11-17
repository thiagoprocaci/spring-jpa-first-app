package com.tbp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "id") // id da tabela professor
public class Professor extends Pessoa  {

    @Column(name = "formacao")
    String formacao;
    @ManyToMany
    @JoinTable(name = "disciplina_professor",
            joinColumns = { @JoinColumn(name = "idprofessor") },
            inverseJoinColumns = { @JoinColumn(name = "iddisciplina") })
    Set<Disciplina> disciplinas = new HashSet<Disciplina>();

    @OneToMany(mappedBy = "professor")
    Set<Alocacao> alocacaoSet = new HashSet<Alocacao>();

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Set<Alocacao> getAlocacaoSet() {
        return alocacaoSet;
    }

    public void setAlocacaoSet(Set<Alocacao> alocacaoSet) {
        this.alocacaoSet = alocacaoSet;
    }
}