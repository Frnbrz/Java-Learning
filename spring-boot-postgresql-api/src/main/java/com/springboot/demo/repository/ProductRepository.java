package com.springboot.demo.repository;


import com.springboot.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {}
