package com.Logistics.dao;

import com.Logistics.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerDao {

    /**
     * 登录
     *
     * @param customer
     * @return
     */
    public Customer login(Customer customer);

    /**
     * 查找用户列表
     *
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
     * 实体修改
     *
     * @param customer
     * @return
     */
    public int updateCustomer(Customer customer);

    /**
     * 添加用户
     *
     * @param customer
     * @return
     */
    public int addCustomer(Customer customer);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteCustomer(Integer id);
}
