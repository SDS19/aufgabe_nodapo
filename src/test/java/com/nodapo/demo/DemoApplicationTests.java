package com.nodapo.demo;

import com.nodapo.demo.dao.BookDao;
import com.nodapo.demo.dao.CustomerDao;
import com.nodapo.demo.dao.ShopDao;
import com.nodapo.demo.entity.*;
import com.nodapo.demo.service.BookService;
import com.nodapo.demo.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private ShopDao shopDao;
    @Resource
    private CustomerDao customerDao;

    @Test
    public void addShop(){
        Shop shop = new Shop();
        shop.setId(UUIDUtil.getUUID());
        shop.setName("shop_2");
        shop.setTurnover(new BigDecimal("100"));
        Assert.assertEquals(1,shopDao.insert(shop));
    }
    @Test
    public void addCustomer(){
        Customer customer = new Customer();
        customer.setId(UUIDUtil.getUUID());
        customer.setName("a");
        customer.setBalance(new BigDecimal("100"));
        Assert.assertEquals(1,customerDao.insert(customer));
    }

    /*============================== function test ==============================*/

    @Resource
    private BookService service;

    @Test//Bücher hinzufügen + Entfernen von Duplikaten
    public void addBook(){
        //{title,price,pageCount,genre,ISBN} except "id"
        Book book = new Book();
        book.setTitle("123");
        book.setPrice(new BigDecimal("123"));
        book.setPageCount(123);
        book.setGenre("123");
        book.setISBN("123");

        //{shopId,shopName,stock,price} except "id","bookId","bookTitle","soldout(0)"
        Stock stock = new Stock();
        stock.setShopId("958033615a5244b4b8a4ba71abd9072b");
        stock.setShopName("shop_2");
        stock.setStock(321);
        stock.setPrice(new BigDecimal("321"));

        System.out.println(service.addBook(stock,book).toString());
    }

    @Test//Verkauf customer_1 -> shop_2 -> book_4 + book_5
    public void sale(){
        Order order_1 = new Order();
        order_1.setShopId("958033615a5244b4b8a4ba71abd9072b");
        order_1.setCustomerId("a8382974be924405879038bc56d69057");
        order_1.setCustomerName("customer_1");
        order_1.setBookId("9e14185518ad4dd4a7cbd9f5a89d811b");
        order_1.setBookTitle("book_5");
        order_1.setCount(5);
        order_1.setPrice(new BigDecimal(50* order_1.getCount()));

        Order order_2 = new Order();
        order_2.setShopId("958033615a5244b4b8a4ba71abd9072b");
        order_2.setCustomerId("a8382974be924405879038bc56d69057");
        order_2.setCustomerName("customer_1");
        order_2.setBookId("4259d13859a947fb84a8cc579f6531d1");
        order_2.setBookTitle("book_4");
        order_2.setCount(4);
        order_2.setPrice(new BigDecimal(40* order_2.getCount()));

        Order[] orders = {order_1,order_2};

        Assert.assertEquals(true,service.sale(orders));
    }

    @Test//Filtern von Büchern
    public void filter() {
        Book book = new Book();
        book.setGenre("com");
        System.out.println(service.filter(book).toString());
    }

    @Test//Vergleich
    public void compare(){
        //get request parameter from frontend
        Book book = new Book();
        book.setTitle("4");
        System.out.println(service.compare(book).toString());
    }



}
