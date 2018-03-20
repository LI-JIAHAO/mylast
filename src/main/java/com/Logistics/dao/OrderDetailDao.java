package com.Logistics.dao;


import com.Logistics.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {

    int save(OrderDetail orderDetail);

    int batchSave(List<OrderDetail> orderDetailList);

}
