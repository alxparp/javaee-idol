package org.example.repository;

import org.example.entity.Book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @PostConstruct
    public void init() {
        System.out.println("Open entity manager factory");
        emf = Persistence.createEntityManagerFactory("idolPostgres");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Close entity manager factory");
        em.close();
        emf.close();
    }

    @Override
    public void save(Book book) {
        tx.begin();
        em.persist(book);
        tx.commit();
    }

    @Override
    public Book findBookByTitle() {
        return em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    }

    @Override
    public void deleteBook(Book book) {
        tx.begin();
        em.remove(book);
        tx.commit();
    }
}
