package com.nodapo.demo.dao;

import com.nodapo.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {

    int getISBN(String ISBN);

    int insert(Book book);

    Book getBookByISBN(String ISBN);



}
