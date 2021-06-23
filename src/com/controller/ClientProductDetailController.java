package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.impl.CategoryDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.model.Category;
import com.model.Product;



@WebServlet(urlPatterns = "/product/detail")
public class ClientProductDetailController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.get(Integer.parseInt(id));
		req.setAttribute("productlistsclient", product);
		System.out.println(product.getName());
		// lay danh sách sp
//		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
//		List<Category> categoryList = categoryDao.search("");
//		req.setAttribute("categorylistsclient", categoryList);
//        //san pham khac
//		ProductDaoImpl productDaos = new ProductDaoImpl();
//		List<Product> productLists = new ArrayList<Product>();
//		productLists = productDaos.search("");
//		req.setAttribute("productlistsclients", productLists);

		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/ProductDetail.jsp");
		dispatcher.forward(req, resp);
	}

}
