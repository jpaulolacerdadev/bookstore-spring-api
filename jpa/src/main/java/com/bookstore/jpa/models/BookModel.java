package com.bookstore.jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //Cria a coluna de ID já com o Auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Cria a coluna do titulo do livro
    @Column(nullable = false, unique = true)
    private String title;

    //Cria a coluna de chave estrangeira
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    //Cria a relação ManytoMany com a tabela de autores
    @ManyToMany
    //Cria a tabela auxiliar e relaciona um model com o outro
    @JoinTable(
            //Cria a tabela e da nome à ela book para autor e autor para book
            name = "tb_book_author",
            //Cria a coluna que busca o book_id
            joinColumns = @JoinColumn(name = "book_id"),
            //Cria a coluna que busca o author_id
            inverseJoinColumns = @JoinColumn(name = "author_id"))
            private Set<AuthorModel> authors = new HashSet<>();

    /**
     * Cria o relacionamento com o ReviewModel
     * Cascade replica tudo que acontece com o Objeto relacionado
     * ex: apago um livro = apago junto a review
     */
    @OneToOne(mappedBy ="book",cascade = CascadeType.ALL)
    private ReviewModel review;

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

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

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public Set<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorModel> authors) {
        this.authors = authors;
    }

}
