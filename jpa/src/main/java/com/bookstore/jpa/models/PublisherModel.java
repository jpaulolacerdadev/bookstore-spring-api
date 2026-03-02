package com.bookstore.jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //Cria a coluna de ID já com o Auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    /**
     * Representa os livros associados a esta editora.
     * O acesso WRITE_ONLY evita a serialização da coleção nas respostas JSON,
     * prevenindo recursão infinita durante a conversão das entidades.
     * O carregamento LAZY é utilizado para melhorar a performance,
     * buscando os livros apenas quando necessário.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy ="publisher", fetch = FetchType.LAZY)
    private Set<BookModel> books = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }
}
