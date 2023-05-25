package org.example.service;

import org.example.annotation.Added;
import org.example.annotation.Loggable;
import org.example.annotation.Removed;
import org.example.entity.Digits;
import org.example.annotation.NumberOfDigits;
import org.example.entity.Book;
import org.example.generator.NumberGenerator;
import org.example.interceptor.LoggingInterceptor;
import org.example.repository.BookDao;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Transactional
@Loggable
public class BookService {

    @Inject
    private Logger log;

    @Inject
    private BookDao bookDao;

    @Inject
    @NumberOfDigits(value = Digits.EIGHT, odd = false)
    private NumberGenerator numberGenerator;

    @Inject
    @Added
    private Event<Book> bookAddedEvent;

    @Inject
    @Removed
    private Event<Book> bookRemovedEvent;

    public Book createBook(String title, Double price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        log.info("The book " + book.getTitle() + " has created!");
        bookDao.save(book);
        bookAddedEvent.fire(book);
        return book;
    }

    public Book findBookByH2G2() {
        return bookDao.findBookByTitle();
    }

    public void deleteBook(Book book) {
        bookDao.deleteBook(book);
        bookRemovedEvent.fire(book);
    }
}
