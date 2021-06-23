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

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/client/product/category") // ?cid=111
public class ClientSearchCategoryController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String categoryId = req.getParameter("cid");

		// mac dinh lay tat ca san pham
		ProductDaoImpl productDao = new ProductDaoImpl();
		List<Product> pList = productDao.seachByCategory(Integer.parseInt(categoryId));
		req.setAttribute("productlistsclient", pList);

		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.search("");
		req.setAttribute("categorylistsclient", categoryList);
		
		//search sản phẩm trong category
		ProductDaoImpl productDaos = new ProductDaoImpl();
		List<Product> productLists = new java.util.ArrayList<Product>();
		productLists = productDaos.search("");
		req.setAttribute("productlistsclients", productLists);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Product.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String product = req.getParameter("searchproducts");
		ProductDaoImpl productDaos = new ProductDaoImpl();
		List<Product> productLists = new java.util.ArrayList<Product>();
		productLists = productDaos.search(product);// k co dau cach; "quan"
		req.setAttribute("productlistsclients", productLists);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Product.jsp");
		dispatcher.forward(req, resp);
	}
}
