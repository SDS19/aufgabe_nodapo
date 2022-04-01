package com.nodapo.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {
    private String id;
    private String shopId;
    private String shopName;
    private String bookId;
    private String bookTitle;
    private Integer stock;
    private Integer soldout;
    private BigDecimal price;//tatsächliche Verkaufspreis

    @Override
    public String toString() {
        return "Stock{" +
                "\n id='" + id + '\'' +
                ",\n shopId='" + shopId + '\'' +
                ",\n shopName='" + shopName + '\'' +
                ",\n bookId='" + bookId + '\'' +
                ",\n bookTitle='" + bookTitle + '\'' +
                ",\n stock=" + stock +
                ",\n soldout=" + soldout +
                ",\n price=" + price +
                "\n}";
    }
}
