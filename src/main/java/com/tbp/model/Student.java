package com.tbp.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id") // id da tabela aluno
public class Student extends Person {

    @Column(name = "matricula")
    String number;
    @ManyToOne
    @JoinColumn(name = "id_sala")
    @JsonIgnore
    Room room;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}