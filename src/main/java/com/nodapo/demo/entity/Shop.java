package com.nodapo.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Shop {
    private String id;
    private String name;
    private BigDecimal turnover;//Umsatz
}
