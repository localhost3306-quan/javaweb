package com.service;

import java.util.List;

import com.model.Bill;

public interface BillService {
	void insert(Bill bill);

	void edit(Bill bill);

	void delete(int id);

	Bill get(int id);
	
	List<Bill> getAll();

	List<Bill> search(int userId);
}
