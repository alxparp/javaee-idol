package org.example.service;

import org.example.annotation.Added;
import org.example.annotation.Removed;
import org.example.entity.Book;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InventoryService {

    @Inject
    private Logger logger;

    List<Book> inventory = new ArrayList<>();

    public void addBook(@Observes @Added Book book) {
        logger.info("Adding book " + book.getTitle() + " to inventory");
        inventory.add(book);
    }

    public void removeBook(@Observes @Removed Book book) {
        logger.info("Removing book " + book.getTitle() + " from inventory");
        inventory.remove(book);
    }

}
