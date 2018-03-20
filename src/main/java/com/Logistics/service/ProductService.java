package com.Logistics.service;


import com.Logistics.entity.Product;

import java.util.List;

public interface ProductService {

    Product getById(Integer id);
    List<Product> listAll();
    Product getByIdTitle(Integer id, String title);
    int save(Product product);
    int save1(Product product, String title);
    int update(Product product);
    int removeById(Integer id);
    List<Product> listByCriteria(String title, String des);
    List<Product> listByIds(Integer[] ids);
    int batchSave(List<Product> productList);
    int batchUpdate(List<Product> productList);

}
