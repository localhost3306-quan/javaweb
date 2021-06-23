package com.controller.admin;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/user/add" })
public class UserAddController extends HttpServlet {
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String eString = req.getParameter("e"); if (eString != null) { if
		 * (eString.equals("1")) { req.setAttribute("errMsg", "Username da ton tai!!!");
		 * } } RequestDispatcher dispatcher =
		 * req.getRequestDispatcher("/view/admin/AddUser.jsp"); dispatcher.forward(req,
		 * resp); }
		 */

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/AddUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		/*
		 * User user = new User(); DiskFileItemFactory diskFileItemFactory = new
		 * DiskFileItemFactory(); ServletFileUpload servletFileUpload = new
		 * ServletFileUpload(diskFileItemFactory);
		 * 
		 * try { List<FileItem> items = servletFileUpload.parseRequest(req); for
		 * (FileItem item : items) { if (item.getFieldName().equals("email")) {
		 * user.setEmail(item.getString());; } else if
		 * (item.getFieldName().equals("username")) {
		 * user.setUsername(item.getString()); } else if
		 * (item.getFieldName().equals("password")) {
		 * user.setPassword(item.getString()); } else if
		 * (item.getFieldName().equals("role")) {
		 * user.setRoleId(Integer.parseInt(item.getString()));; } else if
		 * (item.getFieldName().equals("avatar")) { final String dir = "F:\\upload";
		 * String originalFileName = item.getName(); int index =
		 * originalFileName.lastIndexOf("."); String ext =
		 * originalFileName.substring(index + 1); String fileName =
		 * System.currentTimeMillis() + "." + ext; File file = new File(dir + "/" +
		 * fileName); item.write(file);
		 * 
		 * user.setAvatar(fileName); } }
		 * 
		 * userService.insert(user);
		 * 
		 * resp.sendRedirect(req.getContextPath() + "/admin/user/list"); } catch
		 * (FileUploadException e) { e.printStackTrace(); } catch (Exception e) {
		 * resp.sendRedirect(req.getContextPath() + "/admin/user/add?e=1"); }
		 * 
		 * }
		 */
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

			User user = new User();
			// lay ra tung input
			for (FileItem item : fieldList) {
				System.out.println("1");
				if (item.getFieldName().equals("email")) {
					String email = item.getString();
					user.setEmail(email);
					System.out.println("email: "+ email);
				}
				System.out.println("2");
				if (item.getFieldName().equals("username")) {
					String username = item.getString();
					user.setUsername(username);
					;
				}
				System.out.println("3");
				if (item.getFieldName().equals("password")) {
					String password = getSHA256(item.getString());
					user.setPassword(password);
				}
				System.out.println("4");
				if (item.getFieldName().equals("role")) {
					user.setRoleId(Integer.parseInt(item.getString()));
					;
				}
				System.out.println("5");
				if (item.getFieldName().equals("avatar")) {
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

						user.setAvatar(image);
						;// luu lai ten file anh vao
					}
				}
			}

			System.out.println("6");
			userService.insert(user);

			resp.sendRedirect(req.getContextPath() + "/admin/user/list");
		} catch (Exception e) {
			System.out.println("Loi " + e);
		}

	}
	public static String getSHA256(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(input.getBytes());
			return convertByteToHex(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String convertByteToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

}
