package com.crud.mine.com.crud.mine.serviceImpl;

import com.crud.mine.com.crud.mine.Constant.ProductConstant;
import com.crud.mine.com.crud.mine.POJO.Product;
import com.crud.mine.com.crud.mine.Utils.ProductUtils;
import com.crud.mine.com.crud.mine.dao.ProductDao;
import com.crud.mine.com.crud.mine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;


    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {

        try {

            if (validateNewProduct(requestMap, false)) {

                //Product product = getProductFromMap(requestMap, false);
                productDao.save(getProductFromMap(requestMap, false));
                return ProductUtils.getResponseEntity(ProductConstant.DATA_INSERTED, HttpStatus.OK);

            } else {
                return ProductUtils.getResponseEntity(ProductConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ProductUtils.getResponseEntity(ProductConstant.SOMETHING_WENT_WRONG_SERVICE_IMPL, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private boolean validateNewProduct(Map<String, String> requestMap, Boolean validateId) {

        if (requestMap.containsKey("name") && requestMap.containsKey("price") && requestMap.containsKey("Description")) {
            if (validateId && requestMap.containsKey("product_id")) {
                return true;
            } else if (!validateId) {
                return true;
            }
        }
        return false;

    }


    private Product getProductFromMap(Map<String, String> requestMap, Boolean isAdd) {

        Product product = new Product();
        if (isAdd) {
            product.setId(Integer.parseInt(requestMap.get("product_id")));
        }
        product.setName(requestMap.get("name"));
        product.setPrice(Float.parseFloat(requestMap.get("price")));
        product.setDescription(requestMap.get("Description"));

        return product;


    }


    @Override
    public ResponseEntity<List<Product>> getAllProduct() {

        try {

            return new ResponseEntity<List<Product>>(productDao.findAll(), HttpStatus.OK);


        } catch (Exception e) {

            e.printStackTrace();
        }

        return new ResponseEntity<List<Product>>(new ArrayList<Product>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateProduct(Map<String, String> requestMap) {
        try {

            if (validateNewProduct(requestMap,true)) {

                Optional optional = productDao.findById(Integer.parseInt(requestMap.get("product_id")));

                if (!optional.isEmpty()) {
                    productDao.save(getProductFromMap(requestMap, true));

                    return ProductUtils.getResponseEntity(ProductConstant.DATA_UPDATED, HttpStatus.OK);

                } else {
                    return ProductUtils.getResponseEntity(ProductConstant.DATA_NOT_FOUND, HttpStatus.BAD_REQUEST);
                }

            } else {
                return ProductUtils.getResponseEntity(ProductConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return ProductUtils.getResponseEntity(ProductConstant.SOMETHING_WENT_WRONG_SERVICE_IMPL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteProduct(int product_id) {
        try {
            if(product_id>=0){
                productDao.deleteById(product_id);

                return ProductUtils.getResponseEntity(ProductConstant.PRODUCT_DELETED, HttpStatus.OK);

            }else{
                return ProductUtils.getResponseEntity(ProductConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return ProductUtils.getResponseEntity(ProductConstant.SOMETHING_WENT_WRONG_SERVICE_IMPL, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
