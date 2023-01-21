package com.crud.mine.com.crud.mine.dao;

import com.crud.mine.com.crud.mine.POJO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
