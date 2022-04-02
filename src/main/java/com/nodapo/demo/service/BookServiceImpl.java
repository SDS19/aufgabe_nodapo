package com.nodapo.demo.service;

import com.nodapo.demo.dao.BookDao;
import com.nodapo.demo.dao.CustomerDao;
import com.nodapo.demo.dao.ShopDao;
import com.nodapo.demo.entity.*;
import com.nodapo.demo.exception.DaoException;
import com.nodapo.demo.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookDao bookDao;
    @Resource
    private ShopDao shopDao;
    @Resource
    private CustomerDao customerDao;

    @Transactional
    @Override
    public Stock addBook(Stock newStock,Book newBook) {
        //check ISBN
        String ISBN = newBook.getISBN();
        if (bookDao.getISBN(ISBN)==0) throw new DaoException("ISBN is wrong!");

        //check duplicate in t_book
        Book oldBook = bookDao.getBookByISBN(ISBN);
        if (oldBook==null) {//no book in t_book and t_stock
            newBook.setId(UUIDUtil.getUUID());
            if (bookDao.insert(newBook)!=1) throw new DaoException("Add new book failed!");

            newStock.setId(UUIDUtil.getUUID());
            newStock.setBookId(newBook.getId());
            newStock.setBookTitle(newBook.getTitle());
            newStock.setSoldout(0);
            if (shopDao.addBook(newStock)!=1) throw new DaoException("Add new book to stock failed!");
            return shopDao.getStock(newStock);
        }

        //check duplicate in t_stock (book exists already in t_book)
        newStock.setBookId(oldBook.getId());
        Stock oldStock = shopDao.getStock(newStock);
        if (oldStock!=null) {//book in t_stock
            oldStock.setStock(oldStock.getStock()+newStock.getStock());
            shopDao.updateStock(oldStock);
            return shopDao.getStock(oldStock);
        } else {//no book in t_stock
            newStock.setId(UUIDUtil.getUUID());
            newStock.setBookTitle(oldBook.getTitle());
            newStock.setSoldout(0);
            shopDao.addBook(newStock);
            return shopDao.getStock(newStock);
        }
    }

    @Transactional
    @Override
    public boolean sale(Order[] orders) {

        //get total price (t_order)
        BigDecimal totalPrice = new BigDecimal(0);
        for (Order order:orders) {
            totalPrice = totalPrice.add(order.getPrice());
        }

        //check customer balance and update balance  (t_customer)
        Customer customer = customerDao.getCustomer(orders[0].getCustomerId());
        BigDecimal oldBalance = customer.getBalance();
        if (oldBalance.compareTo(totalPrice)<0) throw new DaoException("Insufficient account balance!");
        customer.setBalance(oldBalance.subtract(totalPrice));
        if (customerDao.update(customer)!=1) throw new DaoException("Update balance failed!");

        //update turn over (t_shop)
        Shop shop = shopDao.getShop(orders[0].getShopId());
        shop.setTurnover(shop.getTurnover().add(totalPrice));
        if (shopDao.updateShop(shop)!=1) throw new DaoException("Update turnover failed!");

        //create order (t_order) and update stock (t_stock)
        for (Order order:orders) {
            order.setId(UUIDUtil.getUUID());
            if (shopDao.addOrder(order)!=1) throw new DaoException("Create order failed!");

            Stock oldStock = new Stock();
            oldStock.setShopId(order.getShopId());
            oldStock.setBookId(order.getBookId());
            Stock newStock = shopDao.getStock(oldStock);
            newStock.setStock(newStock.getStock()-order.getCount());
            newStock.setSoldout(newStock.getSoldout()+order.getCount());
            if (shopDao.updateStock(newStock)!=1) throw new DaoException("Update stock failed!");
        }

        return true;
    }

    @Override
    public List<Stock> filter(Book book) {
        return shopDao.filter(book);
    }

    @Override
    public List<Stock> compare(Book book) {
        return shopDao.getStockbyBook(book);
    }

}
