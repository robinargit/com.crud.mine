package com.crud.mine.com.crud.mine.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductUtils {

    public ProductUtils() {
    }

    public static ResponseEntity<String> getResponseEntity(String responseMessages, HttpStatus httpStatus){
        return  new ResponseEntity<String>("{\"message\":\""+responseMessages+"\"}", httpStatus);
    }
}
