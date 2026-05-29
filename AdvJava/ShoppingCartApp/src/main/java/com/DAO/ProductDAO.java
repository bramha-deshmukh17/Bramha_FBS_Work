package com.DAO;

import com.bean.Product;
import java.util.List;

public interface ProductDAO {
    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    Product getProductById(int id);

    List<Product> getAllProducts();
}