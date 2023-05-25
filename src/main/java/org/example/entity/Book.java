package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@NamedQuery(name = "findBookH2G2",
        query = "SELECT b FROM Book b WHERE b.title = 'H2G2'")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String title;
    private Double price;
    @Size(min = 10, max = 2000)
    private String description;
    private String number;

    public Book() {}

    public Book(String title, Double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
