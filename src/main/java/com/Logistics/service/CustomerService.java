package com.Logistics.service;

import com.Logistics.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    /**
     * @param customer
     * @return
     */
    public Customer login(Customer customer);

    /**
     * @param map
     * @return
     */
    public List<Customer> findCustomers(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalCustomer(Map<String, Object> map);


    /**
     * @param customer
     * @return
     */
    public int updateCustomer(Customer customer);

    /**
     * @param customer
     * @return
     */
    public int addCustomer(Customer customer);

    /**
     * @param id
     * @return
     */
    public int deleteCustomer(Integer id);
}
