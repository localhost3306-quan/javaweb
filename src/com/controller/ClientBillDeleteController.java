package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.BillDaoImpl;
import com.dao.impl.BillProductDaoImpl;
import com.model.BillProduct;


@WebServlet(urlPatterns = "/member/bill/delete")
public class ClientBillDeleteController extends HttpServlet{
	BillProductDaoImpl billProductDao = new BillProductDaoImpl();
	BillDaoImpl billDao = new BillDaoImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billId = req.getParameter("billid");

		/// xoa het cac mat hang billproduct truoc, sau do moi xoa bill
		System.out.println("1");
	List<BillProduct> billProducts = billProductDao.search(Integer.parseInt(billId));
	System.out.println(billId);
		//List<BillProduct> billProducts = billProductDao.get(Integer.parseInt(billId));
		for (BillProduct billProduct : billProducts) {
		
			billProductDao.delete(billProduct.getId());
			
		}

		// sau do xoa bill
		billDao.delete(Integer.parseInt(billId));

		resp.sendRedirect("/ProjectWeb/member/bill");
	}
}
