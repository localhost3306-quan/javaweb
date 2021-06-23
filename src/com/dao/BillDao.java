package com.dao;

import java.util.List;

import com.model.Bill;

public interface BillDao {
	void insert(Bill bill);

	void edit(Bill bill);

	void delete(int id);

	Bill get(String name);

	Bill get(int id);

	List<Bill> getAll();

	List<Bill> search(int userId);

}
