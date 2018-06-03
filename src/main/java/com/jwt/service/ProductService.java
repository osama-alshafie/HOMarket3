package com.jwt.service;

import com.jwt.model.Customer;
import com.jwt.model.Product;

import java.util.List;

public interface ProductService {


    public void AddProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(int id);

    public List<Product> getAllProducts();
    
    public List<Product> filterProductsByPrice(float min, float max);

    public Product getProductById(int productId);
    

}
