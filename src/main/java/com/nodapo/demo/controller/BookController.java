package com.nodapo.demo.controller;

import com.nodapo.demo.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @PostMapping
    public boolean addBook(){


        return true;
    }
}
