package com.mylibrary.factory;

import com.mylibrary.dao.BookDAO;
import com.mylibrary.dao.HibernateBookDAO;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class Factory {

    private final static Factory INSTANCE = new Factory();

    private final SessionFactory sessionFactory;

    private Factory() {

        sessionFactory = (SessionFactory) Persistence
                .createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static Factory getInstance(){
        return INSTANCE;
    }

    public BookDAO getBookDAO() {
        return new HibernateBookDAO(sessionFactory);
    }
}
