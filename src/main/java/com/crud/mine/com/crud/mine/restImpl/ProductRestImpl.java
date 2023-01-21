package com.crud.mine.com.crud.mine.restImpl;

import com.crud.mine.com.crud.mine.Constant.ProductConstant;
import com.crud.mine.com.crud.mine.Utils.ProductUtils;
import com.crud.mine.com.crud.mine.rest.ProductRest;
import com.crud.mine.com.crud.mine.service.ProductService;
import com.crud.mine.com.crud.mine.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductRestImpl implements ProductRest {

    @Autowired
    ProductService productService;


    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
       try{
          return productService.addNewProduct(requestMap);

       }catch (Exception e){
           e.printStackTrace();

       }

        return ProductUtils.getResponseEntity(ProductConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
