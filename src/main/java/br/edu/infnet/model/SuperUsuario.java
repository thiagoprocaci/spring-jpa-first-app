package br.edu.infnet.model;

import javax.persistence.*;

@Entity
@Table(name = "super_user" )
@Inheritance(strategy = InheritanceType.JOINED)
public class SuperUsuario { // representa os atributos que ambos usuarios tem

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "username", unique = true)
    String username;
    @Column(name = "email", unique = true)
    String email;
    @Column(name = "password")
    String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
