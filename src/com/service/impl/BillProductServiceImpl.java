package com.service.impl;

import java.util.List;

import com.dao.BillProductDao;
import com.dao.impl.BillProductDaoImpl;
import com.model.BillProduct;
import com.service.BillProductService;
import com.service.BillService;

public class BillProductServiceImpl implements BillProductService {
	BillProductDao billProductDao = new BillProductDaoImpl();

	@Override
	public void insert(BillProduct billProduct) {
		billProductDao.insert(billProduct);

	}

	@Override
	public void edit(BillProduct newbillProduct) {
		BillProduct oldBillProduct = billProductDao.get(newbillProduct.getId());
		oldBillProduct.setBill(newbillProduct.getBill());
		oldBillProduct.setProduct(newbillProduct.getProduct());
		oldBillProduct.setQuantity(newbillProduct.getQuantity());
		oldBillProduct.setUnitPrice(newbillProduct.getUnitPrice());

		billProductDao.edit(oldBillProduct);
	}

	@Override
	public void delete(int id) {
		billProductDao.delete(id);
	}

	@Override
	public BillProduct get(int id) {
		return billProductDao.get(id);
	}

	@Override
	public List<BillProduct> search(int billId) {
		return billProductDao.search(billId);
	}

}
