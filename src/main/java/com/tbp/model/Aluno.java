package com.tbp.model;

import javax.persistence.*;


@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id") // id da tabela aluno
public class Aluno extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "idturma")
    Turma turma;
    @Column(name = "matricula")
    String matricula;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}