package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BillDao;
import com.dao.BillProductDao;
import com.dao.impl.BillDaoImpl;
import com.dao.impl.BillProductDaoImpl;
import com.model.Bill;
import com.model.BillProduct;
import com.model.User;



@WebServlet(urlPatterns = "/member/addorder")
public class AddToOrderController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();
	BillProductDao billProductDao = new BillProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session

		if (obj != null) {
			Map<String, BillProduct> map = (java.util.Map<String, BillProduct>) obj;

			Bill bill = new Bill();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			bill.setDate(sdf.format(new java.util.Date()));

			// lay dang nhap
			User customer = (User) session.getAttribute("account");
			bill.setBuyer(customer);

			billDao.insert(bill);// save bill trc de lay id
			// Tim mat hang
			long total = 0;
			for (Entry<String, BillProduct> entry : map.entrySet()) {
				BillProduct billProduct = entry.getValue();

				billProduct.setBill(bill);// set bill id vao day

				billProductDao.insert(billProduct);
				// tinh tong gia
				total += billProduct.getQuantity() * billProduct.getUnitPrice();
			}

			/// cap nhat lai bill de co tong gia tien
			bill.setTotalBill(total);
			billDao.edit(bill);

			// chuyen ve trang thanh cong
			// xoa session gio hang vi da tao don hang thanh cong, giai phong bo nho
			session.removeAttribute("cart");
			resp.sendRedirect(req.getContextPath() + "/member/bill");
		} else {
			// tra ve trang chu neu gio hang rong
			resp.sendRedirect(req.getContextPath() + "/client/product/search");
		}

	}
}
