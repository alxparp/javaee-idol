package org.example;

import org.example.entity.Book;
import org.example.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        BookService bookService = container.instance().select(BookService.class).get();
        bookService.createBook("H2G2", 13.5, "Geeky scifi Book");
        Book book = bookService.findBookByH2G2();

        System.out.println("######### " + book.getDescription());

        weld.shutdown();
    }
}