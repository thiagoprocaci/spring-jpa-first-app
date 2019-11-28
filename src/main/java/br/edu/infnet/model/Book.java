package br.edu.infnet.model;

import javax.persistence.*;

@Entity
@Table(name = "livro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nome")
    String name;
    @Column(name = "ano_lancamento")
    Integer year;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    Author author;
    @ManyToOne
    @JoinColumn(name = "id_editora")
    Publisher publisher;

    public Book() {
    }

    public Book(String name, Integer year, Author author, Publisher publisher) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.publisher = publisher;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

}
