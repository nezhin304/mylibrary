package com.mylibrary.dao;


import com.mylibrary.entity.Book;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateBookDAO implements BookDAO {

    private final SessionFactory sessionFactory;

    public HibernateBookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertBook(Book book) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Book> getAllBooks() {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> result = entityManager.createQuery( "from Book ", Book.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public void deleteAllBooks() {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE FROM books");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
