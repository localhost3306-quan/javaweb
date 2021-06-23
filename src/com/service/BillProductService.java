package com.service;

import java.util.List;

import com.model.BillProduct;

public interface BillProductService {
	void insert(BillProduct billProduct);

	void edit(BillProduct billProduct);

	void delete(int id);

	BillProduct  get(int id);


	List<BillProduct> search(int billId);
}
