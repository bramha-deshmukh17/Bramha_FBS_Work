package com.services;

import com.bean.Product;
import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    Product getProductById(int id);

    List<Product> getAllProducts();
}