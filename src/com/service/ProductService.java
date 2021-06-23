package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	void insert(Product product);

	void edit(Product product);

	void delete(int id);

	Product get(int id);

	List<Product> getAll();

	List<Product> search(String username);
	
	List<Product> seachByCategory(int category_id);
	
	List<Product> seachByName(String productName);
}
