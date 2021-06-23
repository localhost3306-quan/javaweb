package com.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.UserDao;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.model.Product;
import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/user/list" })
public class UserListController extends HttpServlet {
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		List<User> userList = userService.getAll();
//		req.setAttribute("userList", userList);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/UserList.jsp");
//		dispatcher.forward(req, resp);

		/*
		 * ProductDao pDao = new ProductDaoImpl(); List<Product> pList =
		 * pDao.search(""); req.setAttribute("productList", pList);
		 * 
		 * UserDao uDao = new UserDaoImpl(); List<User> uList = uDao.search("");
		 * req.setAttribute("userList", uList);
		 * 
		 * RequestDispatcher dispatcher =
		 * req.getRequestDispatcher("/view/admin/UserList.jsp"); dispatcher.forward(req,
		 * resp);
		 */

		UserDao uDao = new UserDaoImpl();
		List<User> userList = uDao.search("");
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/UserList.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");

		UserDao uDao = new UserDaoImpl();
		List<User> userLists = uDao.search(keyword);
		req.setAttribute("userList", userLists);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/UserList.jsp");
		dispatcher.forward(req, resp);
	}
}

/*
 * protected void doPost(HttpServletRequest req, HttpServletResponse resp)
 * throws ServletException, IOException {
 * 
 * String keyword = req.getParameter("keyword");
 * 
 * ProductDao productDao = new ProductDaoImpl(); List<Product> products =
 * productDao.search(keyword); req.setAttribute("productList", products);
 * 
 * RequestDispatcher dispatcher =
 * req.getRequestDispatcher("/views/admin/product/searchProduct.jsp");
 * dispatcher.forward(req, resp);
 * 
 * 
 * 
 * String keyword = req.getParameter("keyword"); UserDao uDao = new
 * UserDaoImpl(); List<User> uList = uDao.search(keyword);
 * req.setAttribute("userList", uList); RequestDispatcher dispatcher =
 * req.getRequestDispatcher("/view/admin/UserList.jsp"); dispatcher.forward(req,
 * resp); }
 */
