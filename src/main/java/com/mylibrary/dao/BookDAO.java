package com.mylibrary.dao;

import com.mylibrary.entity.Book;

import java.util.List;

public interface BookDAO {

    void insertBook(Book book);

    List<Book> getAllBooks();

    void deleteAllBooks();
}
