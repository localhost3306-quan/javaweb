package com.dao;

import java.util.List;

import com.model.BillProduct;
import com.model.Product;

public interface BillProductDao {
	void insert(BillProduct billProduct);

	void edit(BillProduct billProduct);

	void delete(int id);

	BillProduct get(int id);

	List<BillProduct> search(int billId);

}