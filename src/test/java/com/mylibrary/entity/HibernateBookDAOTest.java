package com.mylibrary.entity;

import com.mylibrary.dao.BookDAO;
import com.mylibrary.factory.Factory;
import static junit.framework.TestCase.assertEquals;
//import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class HibernateBookDAOTest {

    private Factory instance = Factory.getInstance();

    @Test
    public void insertAndSelectEntityTest(){

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

        List<Book> bookList =  bookDAO.getAllBooks();

        Book bookRes = bookList.stream()
                .filter(b -> b.getName().equals("Skazka o Tsare Saltane"))
                .findFirst()
                .get();

        assertEquals("Skazka o Tsare Saltane", bookRes.getName());
        assertEquals(5, bookRes.getBookCount().getCount());
        assertEquals("Aleksandr", bookRes.getAutor().getFirstName());
        assertEquals("Pushkin", bookRes.getAutor().getLastName());

        List<Customer> customerList = bookRes.getCustomerList();
        assertEquals("User1", customerList.get(0).getName());

    }

}
