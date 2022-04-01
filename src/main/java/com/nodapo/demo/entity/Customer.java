package com.nodapo.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Customer {
    private String id;
    private String name;
    private BigDecimal balance;//Geldsumme
}
