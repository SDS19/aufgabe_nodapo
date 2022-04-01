package com.nodapo.demo.dao;

import com.nodapo.demo.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao {

    int insert(Customer customer);

    Customer getCustomer(String customerId);

    int update(Customer customer);
}
