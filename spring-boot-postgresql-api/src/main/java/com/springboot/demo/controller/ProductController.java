package com.springboot.demo.controller;


import com.springboot.demo.entity.Product;
import com.springboot.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveBook(product);
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllBooks();
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteBook(id);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateBook(product);
	}
	
}
