package com.Logistics.service.impl;

import com.Logistics.dao.CustomerDao;
import com.Logistics.entity.Customer;
import com.Logistics.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao ;

    @Override
    public Customer login(Customer customer) {
        return customerDao.login(customer);
    }

    @Override
    public List<Customer> findCustomers(Map<String, Object> map) {
        return customerDao.findCustomers(map);
    }

    @Override
    public int updateCustomer(Customer customer) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if ("controller".equals(customer.getUserName())) {
            return 0;
        }
        return customerDao.updateCustomer(customer);
    }

    @Override
    public Long getTotalCustomer(Map<String, Object> map) {
        return customerDao.getTotalCustomer(map);
    }

    @Override
    public int addCustomer(Customer customer) {
        if (customer.getUserName() == null || customer.getPassword() == null || getTotalCustomer(null) > 90) {
            return 0;
        }
        return customerDao.addCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if (2 == id) {
            return 0;
        }
        return customerDao.deleteCustomer(id);
    }

}
