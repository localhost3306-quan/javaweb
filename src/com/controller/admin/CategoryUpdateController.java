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

import com.dao.CategoryDao;
import com.dao.impl.CategoryDaoImpl;
import com.model.Category;
import com.model.User;
import com.service.CategoryService;
import com.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/update" })
public class CategoryUpdateController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* String id = req.getParameter("id"); */
		int id = Integer.parseInt(req.getParameter("id"));
		Category category = cateService.get(id);

		/* Category category = cateService.get(Integer.parseInt(id)); */
		req.setAttribute("category", category);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/UpdateCategory.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * Category category = new Category();
		 * 
		 * category.setId(Integer.parseInt(req.getParameter("id")));
		 * category.setName(req.getParameter("name")); cateService.edit(category);
		 */
		// doc du lieu tu form gui len
		String id = req.getParameter("id");
		String name = req.getParameter("name");

		// System.out.println(Integer.parseInt(age));

		Category category = new Category();
		category.setId(Integer.parseInt(id));
		category.setName(name);

		CategoryDao categorydao = new CategoryDaoImpl();
		categorydao.edit(category);

		// / chuyen huong
		// server tra ve 1 duong dan url
		// client se goi sang duong dan moi

		resp.sendRedirect(req.getContextPath() + "/admin/category/list");

	}
}
