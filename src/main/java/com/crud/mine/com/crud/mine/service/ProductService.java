package com.crud.mine.com.crud.mine.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductService {

    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap);
}
