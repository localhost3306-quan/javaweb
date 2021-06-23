<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOME</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/adminpage.css">
</head>
<body>
	 <!--------------NAV----------------->
    <div class="header">
        <div class="container">
            <div class="navbar">
                <nav>
                    <ul id="MenuItems">
                        <li><a href="/ProjectWeb/admin/user/list">UsersList</a></li>
                        <li><a href="/ProjectWeb/admin/category/list">CategoriesList</a></li>
                        <li><a href="/ProjectWeb/admin/bill/list">BillsList</a></li>
                         <li><a href="/ProjectWeb/admin/product/list">ProductList</a></li>

                    </ul>
                </nav>
                <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/account.png" width="30px" height="30px">
            </div>
        </div>
    </div>
    <!---------------------------------->

   <div class="container">
       <h1>Welcome------ ${username}------</h1>
   </div>
</body>
</html>