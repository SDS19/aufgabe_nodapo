package com.nodapo.demo.dao;

import com.nodapo.demo.entity.Book;
import com.nodapo.demo.entity.Order;
import com.nodapo.demo.entity.Shop;
import com.nodapo.demo.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopDao {

    int insert(Shop shop);

    Shop getShop(String shopId);

    int updateShop(Shop shop);

    List<Stock> filter(Book book);

    int addBook(Stock stock);

    Stock getStock(Stock stock);

    int updateStock(Stock stock);

    List<Stock> getStockbyBook(Book book);

    int addOrder(Order order);
}
