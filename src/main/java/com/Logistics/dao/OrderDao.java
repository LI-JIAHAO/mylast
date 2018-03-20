package com.Logistics.dao;


import com.Logistics.entity.Order;
import com.Logistics.entity.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    int save(Order order);

    List<Order> listOrdersByCustomerId(@Param("customerId") Integer customerId, @Param("pager") Pager<Order> pager);

    int countByCustomerId(Integer customerId);

}
