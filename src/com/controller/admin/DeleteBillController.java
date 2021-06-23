package com.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BillDao;
import com.dao.impl.BillDaoImpl;
import com.service.BillService;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/bill/delete" })
public class DeleteBillController extends HttpServlet {
	BillDao b = new BillDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		b.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/bill/list");
	}
}
