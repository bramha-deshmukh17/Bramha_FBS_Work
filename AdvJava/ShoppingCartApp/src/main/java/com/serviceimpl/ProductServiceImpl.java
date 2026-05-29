package com.serviceimpl;

import com.aspect.ObjectCreater;
import com.services.ProductService;
import com.DAO.ProductDAO;
import com.bean.Product;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO = ObjectCreater.createObject("productDAO", ProductDAO.class);

    @Override
    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}