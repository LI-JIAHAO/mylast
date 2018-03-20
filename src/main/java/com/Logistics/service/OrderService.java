package com.Logistics.service;


import com.Logistics.entity.Order;
import com.Logistics.entity.Pager;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderService {

    int save(Order order);

    Pager<Order> listOrdersByCustomerId(Integer customerId, Pager<Order> pager);

}
