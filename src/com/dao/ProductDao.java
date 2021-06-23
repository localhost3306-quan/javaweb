package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	void insert(Product product);

	void edit(Product product);

	void delete(int id);

	Product get(int id);

	List<Product> getAll();
	List<Product> search(String name);
	
	List<Product> seachByCategory(int category_id);
	
	List<Product> seachByName(String productName);
}
