package com.springboot.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.demo.entity.Product;
import com.springboot.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveBook(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllBooks() {
		return productRepository.findAll();
	}
	
	public String deleteBook(int id) {
		productRepository.deleteById(id);
		return "deleted book with id "+id;
	}
	
	public Product updateBook(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setUnidades(product.getUnidades());
		existingProduct.setPrecio(product.getPrecio());
		existingProduct.setFecha_caducidad(product.getFecha_caducidad());
		return productRepository.save(existingProduct);
	}
	
	
}
