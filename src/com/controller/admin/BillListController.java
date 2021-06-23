package com.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BillDao;
import com.dao.impl.BillDaoImpl;
import com.model.Bill;
import com.model.User;

@WebServlet(urlPatterns = { "/admin/bill/list" })
public class BillListController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Bill> bills = billDao.getAll();
		req.setAttribute("bills", bills);
		for (Bill bill : bills) {
			System.out.println(bill.getDate());
			System.out.println(bill.getTotalBill());
			System.out.println(bill.getId());
			System.out.println(bill.getBuyer().getUsername());
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/BillList.jsp");
		dispatcher.forward(req, resp);
	}

}
