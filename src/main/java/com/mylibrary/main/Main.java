package com.mylibrary.main;

import com.mylibrary.dao.BookDAO;
import com.mylibrary.entity.Autor;
import com.mylibrary.entity.Book;
import com.mylibrary.entity.BookCount;
import com.mylibrary.entity.Customer;
import com.mylibrary.factory.Factory;

public class Main {

    private static Factory instance = Factory.getInstance();


    public static void main(String[] args) {

        BookDAO bookDAO = instance.getBookDAO();
        bookDAO.deleteAllBooks();

        Book book = new Book();
        book.setName("Skazka o Tsare Saltane");

        BookCount bookCount = new BookCount();
        bookCount.setBook(book);
        bookCount.setCount(5);

        Autor autor = new Autor();
        autor.setFirstName("Aleksandr");
        autor.setLastName("Pushkin");
        autor.addBook(book);

        Customer customer = new Customer();
        customer.setName("User1");
        customer.addBook(book);


        book.setBookCount(bookCount);
        book.setAutor(autor);
        book.addCustomer(customer);

        bookDAO.insertBook(book);


        Book book1 = new Book();
        book1.setName("Voina i Mir");

        BookCount bookCount1 = new BookCount();
        bookCount1.setCount(7);
        bookCount1.setBook(book1);

        Autor autor1 = new Autor();
        autor1.setFirstName("Lev");
        autor1.setLastName("Tolstoy");
        autor1.addBook(book1);

        Customer customer1 = new Customer();
        customer1.setName("User2");
        customer1.addBook(book1);

        book1.setBookCount(bookCount1);
        book1.setAutor(autor1);
        book1.addCustomer(customer1);

        bookDAO.insertBook(book1);
    }
}
