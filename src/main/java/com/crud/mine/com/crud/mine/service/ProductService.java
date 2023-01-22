package com.crud.mine.com.crud.mine.service;

import com.crud.mine.com.crud.mine.POJO.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap);

    public ResponseEntity<List<Product>> getAllProduct();

    public ResponseEntity<String> updateProduct(Map<String, String> requestMap);

    public ResponseEntity<String> deleteProduct(int product_id);
}
