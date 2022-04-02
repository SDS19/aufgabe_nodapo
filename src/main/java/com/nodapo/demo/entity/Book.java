package com.nodapo.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Book {
    private String id;
    private String title;
    private Integer pageCount;//Seitenzahl
    private String genre;//Adventure, Biography, Comic, Fantasy
    private String ISBN;
    private BigDecimal price;//Listenpreis

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && price.intValue()==book.price.intValue() && Objects.equals(pageCount, book.pageCount) && Objects.equals(genre, book.genre);
    }
}
