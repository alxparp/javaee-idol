package org.example.repository;

import org.example.entity.Book;

public interface BookDao {

    void save(Book book);

    Book findBookByTitle();

    void deleteBook(Book book);

}
