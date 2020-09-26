package com.canton.service;

import com.canton.dao.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    String getBook();
    String deleteBook(String book);
}
