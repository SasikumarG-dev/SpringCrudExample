package com.example.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Product;
import com.example.crud.repository.ProductRepository;

import java.awt.Point;
import java.util.*;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	
	public Product saveProduct(Product product ) {
		return repo.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repo.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repo.findAll();
	}
	
	public Product getProductsById(int id){
		return repo.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repo.findByName(name);
	}
	
	public Optional<Product> deleteProduct(int id) {
		Optional<Product> delProduct=repo.findById(id);
		repo.deleteById(id);
		return delProduct;
		
	}
	
	public Product updateProduct(Product product) {
		Product existProduct=repo.findById(product.getId()).orElse(null);
		existProduct.setName(product.getName());
		existProduct.setPrice(product.getPrice());
		existProduct.setQuantity(product.getQuantity());
		return repo.save(existProduct);
	}
}
