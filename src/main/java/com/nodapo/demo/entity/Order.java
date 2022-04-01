package com.nodapo.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String id;
    private String shopId;
    private String customerId;
    private String customerName;
    private String bookId;
    private String bookTitle;
    private Integer count;
    private BigDecimal price;
}
