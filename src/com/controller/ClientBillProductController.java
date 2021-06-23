package com.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BillProductDao;
import com.dao.impl.BillDaoImpl;
import com.dao.impl.BillProductDaoImpl;
import com.model.Bill;
import com.model.BillProduct;




@WebServlet(urlPatterns = "/member/billproduct")
public class ClientBillProductController extends HttpServlet {
	BillProductDao billProductDao = new BillProductDaoImpl();
	BillDaoImpl billDao = new BillDaoImpl();
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String billId = req.getParameter("billid");
	
	Bill bill = billDao.get(Integer.parseInt(billId));
	req.setAttribute("bill", bill);
	
	List<BillProduct> billProducts = billProductDao.search(Integer.parseInt(billId));
	req.setAttribute("billProducts", billProducts);
	
	RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/BillDetail.jsp");
	dispatcher.forward(req, resp);
}
}
