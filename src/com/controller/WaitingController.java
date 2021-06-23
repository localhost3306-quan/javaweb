package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if(u.getRoleId()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin");
			}else {
				resp.sendRedirect(req.getContextPath()+"/welcome");
			}
			
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}

}
