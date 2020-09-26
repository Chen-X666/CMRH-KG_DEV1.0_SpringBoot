package com.canton.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {

    @Test
    void getAllBook() {
        BookServiceImpl bookService = new BookServiceImpl();
        //bookService.getAllBook();
        System.out.println(bookService.getAllBook());
    }
}