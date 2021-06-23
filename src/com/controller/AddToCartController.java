package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.ProductDaoImpl;
import com.model.BillProduct;
import com.model.Product;

@WebServlet(urlPatterns = "/addtocart")
public class AddToCartController extends HttpServlet{
	ProductDaoImpl productDao = new ProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pid");
		Product product = productDao.get(Integer.parseInt(pId));

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session
		if (obj == null) {// tao moi
			// Tao mat hang
			BillProduct billProduct = new BillProduct();
			billProduct.setProduct(product);
			billProduct.setQuantity(1);
		//billProduct.setUnitPrice(Integer.parseInt(product.getDescription()));
			billProduct.setUnitPrice(product.getPrice());
			// gio hang co nhieu mat hang
			Map<String, BillProduct> map = new HashMap<>();
			map.put(pId, billProduct);// them mat hang vao ds

			session.setAttribute("cart", map);// luu tam vao session
		} else {
			Map<String, BillProduct> map = (Map<String, BillProduct>) obj;

			BillProduct billProduct = map.get(pId);

			if (billProduct == null) {
				billProduct = new BillProduct();
				billProduct.setProduct(product);
				billProduct.setQuantity(1);
//				billProduct.setUnitPrice(Integer.parseInt(product.getPrice()));
				billProduct.setUnitPrice(product.getPrice());
				map.put(pId, billProduct);
			} else {

				billProduct.setQuantity(billProduct.getQuantity() + 1);
			}

			session.setAttribute("cart", map);// luu tam vao session
		}

		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
