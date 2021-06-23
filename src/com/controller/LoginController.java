package com.controller;



import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.util.Constant;



@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath()+ "/waiting");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath()+ "/waiting");
					return;
				}
			}
		}

		req.getRequestDispatcher("view/Account.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		  String username = req.getParameter("username");
	        
	        String password = getSHA256(req.getParameter("password"));
	        System.out.println("Pass encript: "+password);
	        boolean isRememberMe = false;
	        String remember = req.getParameter("remember");
	        
	        if("on".equals(remember)){
	            isRememberMe = true;
	        }
	        String alertMsg="";
	        
	        if(username.isEmpty() || password.isEmpty()){
	            alertMsg = "Username and password can't be empty!";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("view/Account.jsp").forward(req, resp);
	            return;
	        }
	      
	        UserService service = new UserServiceImpl();
	        
	        User user = service.login(username, password);
	        
	        
	        if(user!=null){
	            HttpSession session = req.getSession(true);
	            session.setAttribute("account", user);

	            if(isRememberMe){
	                saveRemeberMe(resp, username);
	            }
	           
	            resp.sendRedirect(req.getContextPath()+"/waiting");
	        }else{
	            alertMsg = "Username or password isn't correct";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("view/Account.jsp").forward(req, resp);
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
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	  }
	    
	    private void saveRemeberMe(HttpServletResponse response, String username){
	        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
	        cookie.setMaxAge(30*60);
	        response.addCookie(cookie);
	    }
	}


