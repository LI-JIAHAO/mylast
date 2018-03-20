package com.Logistics.service.impl;


import com.Logistics.dao.ProductDao;
import com.Logistics.entity.Product;
import com.Logistics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> listAll() {
        return productDao.listAll();
    }

    @Override
    public Product getByIdTitle(Integer id, String title) {
        return productDao.getByIdTitle(id, title);
    }

    @Override
    public int save(Product product) {
        return productDao.save(product);
    }

    @Override
    public int save1(Product product, String title) {
        return productDao.save1(product, title);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public int removeById(Integer id) {
        return productDao.removeById(id);
    }

    @Override
    public List<Product> listByCriteria(String title, String des) {
        return productDao.listByCriteria(title, des);
    }

    @Override
    public List<Product> listByIds(Integer[] ids) {
        return productDao.listByIds(ids);
    }

    @Transactional // 开启事务管理
    @Override
    public int batchSave(List<Product> productList) {
        return productDao.batchSave(productList);
    }

    /**
     * 此方法不可行，在项目中不会出现类似的情况
     * @param productList
     * @return
     */
    @Transactional
    @Override
    public int batchUpdate(List<Product> productList) {
        return productDao.batchUpdate(productList);
    }
}
