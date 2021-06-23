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

import com.model.Category;
import com.model.Product;
import com.model.User;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = { "/admin/product/update" })
public class ProductUpdateController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		List<Category> categories = categoryService.getAll();

		req.setAttribute("categories", categories);

		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/UpdateProduct.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);

			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					product.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("name")) {
					product.setName(item.getString());
					;
				} else if (item.getFieldName().equals("cate")) {
					product.setCategory(categoryService.get(item.getString()));
				} else if (item.getFieldName().equals("des")) {
					product.setDescription(item.getString());
					;
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Long.parseLong(item.getString()));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {// neu co file d
						final String dir = "F:\\upload";
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(dir + "/" + fileName);
						item.write(file);

						product.setImage(fileName);

					} else {

						product.setImage(null);
					}
				}
			}
			productService.edit(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/list");*/
		try {
			// tao doi tuong de luu tam thoi file upload len vao
			DiskFileItemFactory factory = new DiskFileItemFactory();

			/// doi thanh duong dan toi thu muc, luu tam thoi file upload len
			factory.setRepository(new File("C:\\Users\\pc\\eclipse-workspace\\ProjectWeb\\uploads"));
			/// TREN WINDOW THI D:\\files (thu muc files trong o D)

			// nho truyen factory vao consrtuctor
			// doc request tu client gui len trong form upload
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			/// danh sach cac truong input tu form client
			// duoc goi la fileitem
			List<FileItem> fieldList = servletFileUpload.parseRequest(req);

			Product product = new Product();
			// lay ra tung input
			for (FileItem item : fieldList) {
				System.out.println("1");
				if (item.getFieldName().equals("id")) {
					product.setId(Integer.parseInt(item.getString()));
					System.out.println("id: " + product.getId());
				}

				System.out.println("2");
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					product.setName(name);
					System.out.println("name product : " + name);
				}
				System.out.println("3");
				if (item.getFieldName().equals("price")) {
					String price = item.getString();
					product.setPrice(Long.parseLong(price));
					System.out.println("price product : " + price);
				}
				System.out.println("4");
				if (item.getFieldName().equals("category")) {
				/*	product.setCategory(categoryService.get(item.getString()));*/
					String categoryId = item.getString();
					Category category = new Category();
					category.setId(Integer.parseInt(categoryId));
					product.setCategory(category);
					System.out.println("category: " + category);
				}
				System.out.println("5");
				if (item.getFieldName().equals("description")) {
				String des = item.getString();
				product.setDescription(des);
				System.out.println("descrip product : " + des);
				}
				System.out.println("6");
				if (item.getFieldName().equals("image")) {
					// kiem tra dung luong file upload
					if (item.getSize() > 0) {// neu co upload file
						final String UPLOAD_FOLDER = "C:\\Users\\pc\\eclipse-workspace\\ProjectWeb\\uploads";
						// tao 1 file tren server
						// tim dinh dang file
						String name = item.getName();// tra ve ten file upload
						int index = name.lastIndexOf(".");
						String ext = name.substring(index);// lay ra phan dinh dang file

						// MINH se ko lay ten file anh upload len, vi se xay ra trung ten
						// ma tao 1 file ten moi
						/// tao file de luu tren server
						String image = System.currentTimeMillis() + ext;// ten file anh moi
						File file = new File(UPLOAD_FOLDER + File.separator + image);

						// ghi du lieu upload len vao file
						item.write(file);

						product.setImage(image);
						;// luu lai ten file anh vao
					} else {
						product.setImage(null);
					}
				}
			}

			System.out.println("7");
			productService.edit(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
