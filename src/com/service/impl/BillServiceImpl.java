package com.service.impl;

import java.util.List;

import com.dao.BillDao;
import com.dao.impl.BillDaoImpl;
import com.model.Bill;
import com.service.BillService;

public class BillServiceImpl implements BillService {
	BillDao billDao = new BillDaoImpl();

	@Override
	public List<Bill> search(int userId) {
		return billDao.search(userId);
	}

	@Override
	public void insert(Bill bill) {
		billDao.insert(bill);

	}

	@Override
	public List<Bill> getAll() {
		return billDao.getAll();
	}

	@Override
	public Bill get(int id) {
		return billDao.get(id);
	}

	@Override
	public void edit(Bill newBill) {
		Bill oldBill = billDao.get(newBill.getId());
		oldBill.setDate(newBill.getDate());
		oldBill.setBuyer(newBill.getBuyer());

		billDao.edit(oldBill);

	}

	@Override
	public void delete(int id) {
		billDao.delete(id);
	}

}
