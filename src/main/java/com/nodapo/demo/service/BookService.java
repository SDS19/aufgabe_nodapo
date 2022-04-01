package com.nodapo.demo.service;

import com.nodapo.demo.entity.Book;
import com.nodapo.demo.entity.Order;
import com.nodapo.demo.entity.Stock;

import java.util.List;

public interface BookService {

    boolean sale(Order[] orders);

    Stock addBook(Stock stock, Book newBook);

    List<Stock> filter(Book book);

    List<Stock> compare(Book book);
}
