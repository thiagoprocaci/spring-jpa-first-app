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
    @ManyToOne
    @JoinColumn(name = "id_pais")
    Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
