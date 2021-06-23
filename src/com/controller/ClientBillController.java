package com.controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BillDao;
import com.dao.BillProductDao;
import com.dao.ProductDao;
import com.dao.impl.BillDaoImpl;
import com.dao.impl.BillProductDaoImpl;
import com.dao.impl.CategoryDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.model.Bill;
import com.model.Category;
import com.model.Product;
import com.model.User;

@WebServlet(urlPatterns = "/member/bill")
public class ClientBillController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// lay dang nhap
		User customer = (User) session.getAttribute("account");

		/// tim don hang cua user dang dang nhap

		List<Bill> billl = billDao.search(customer.getId());
		System.out.println(customer.getId());
		System.out.println(customer.getUsername());
		req.setAttribute("bills", billl);

		for (Bill bill : billl) {
			System.out.println(bill.getDate());
			System.out.println(bill.getTotalBill());
			System.out.println(bill.getId());
			System.out.println(bill.getBuyer().getUsername());
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Bill.jsp");
		dispatcher.forward(req, resp);
	}

}
