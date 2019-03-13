package com.tbp.model;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nome")
    String name;
    @Column(name = "idade")
    Integer age;
    @ManyToOne
    @JoinColumn(name = "id_passatempo")
    Hobby favoriteHobby;

    @Column(name = "senha")
    String password;
    @Column(name = "username", unique = true)
    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Hobby getFavoriteHobby() {
        return favoriteHobby;
    }

    public void setFavoriteHobby(Hobby favoriteHobby) {
        this.favoriteHobby = favoriteHobby;
    }
}
