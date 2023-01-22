package com.crud.mine.com.crud.mine.rest;

import com.crud.mine.com.crud.mine.POJO.Product;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/product")
@CrossOrigin(origins = "*")
public interface ProductRest {


    @PostMapping(path = "/addNewProduct") // localhost:8081/product/addNewProduct
    public ResponseEntity<String> addNewProduct(@RequestBody(required = true) Map<String, String> requestMap);


    @GetMapping(path = "/getAllProduct") //localhost:8081/product/getAllProduct
    public ResponseEntity<List<Product>> getAllProduct();

    @PostMapping(path = "/updateProduct") // localhost:8081/product/updateProduct
    public ResponseEntity<String> updateProduct(@RequestBody(required = true) Map<String, String> requestMap);


    @DeleteMapping(path = "/deleteProduct/{product_id}") // localhost:8081/product/deleteProduct/1
    public ResponseEntity<String> deleteProduct(@PathVariable int product_id);

}
