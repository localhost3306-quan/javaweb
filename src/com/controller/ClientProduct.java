package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.dao.impl.CategoryDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.model.Category;
import com.model.Product;

@WebServlet(urlPatterns = "/client/product/search")
public class ClientProduct extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mac dinh lay tat ca san pham
		ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = new java.util.ArrayList<Product>();
		productList = productDao.seachByName("");
		req.setAttribute("productlistsclient", productList);

		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = new java.util.ArrayList<Category>();
		categoryList = categoryDao.search("");
		req.setAttribute("categorylistsclient", categoryList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Product.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String product = req.getParameter("searchproduct");
		ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = new java.util.ArrayList<Product>();
		productList = productDao.seachByName(product);// k co dau cach; "quan"
		req.setAttribute("productlistsclient", productList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Product.jsp");
		dispatcher.forward(req, resp);
	}
}
