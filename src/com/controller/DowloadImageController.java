package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

@WebServlet(urlPatterns = "/dowload") // ?image=abc.png
public class DowloadImageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String fileName = req.getParameter("fname");
		 * 
		 * final String dir =
		 * "C:\\\\Users\\\\pc\\\\eclipse-workspace\\\\ProjectWeb\\\\uploads";
		 * 
		 * File file = new File(dir + "/" + fileName);
		 * 
		 * resp.setContentType("image/jpeg");
		 * 
		 * if (file.exists()) { IOUtils.copy(new FileInputStream(file),
		 * resp.getOutputStream()); } }
		 */
		String image = req.getParameter("image");
		final String UPLOAD_FOLDER = "C:\\\\Users\\\\pc\\\\eclipse-workspace\\\\ProjectWeb\\\\uploads";
		File file = new File(UPLOAD_FOLDER + File.separator + image);
		if (file.exists()) {
			FileUtils.copyFile(file, resp.getOutputStream());
		}

	}

}
