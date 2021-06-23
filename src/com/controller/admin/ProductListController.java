package com.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.model.Product;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * List<Product> proList = productService.getAll(); req.setAttribute("proList",
		 * proList); RequestDispatcher dispatcher =
		 * req.getRequestDispatcher("/view/admin/view/list-product.jsp");
		 * dispatcher.forward(req, resp); }
		 */

		ProductDao pDao = new ProductDaoImpl();
		List<Product> pList = pDao.seachByName("");
		req.setAttribute("productList", pList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/ProductList.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");

		ProductDao productDao = new ProductDaoImpl();
		List<Product> products = productDao.seachByName(keyword);
		req.setAttribute("productList", products);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/ProductList.jsp");
		dispatcher.forward(req, resp);
	}
}
