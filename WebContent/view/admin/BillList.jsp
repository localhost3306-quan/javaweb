<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bill List</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/adminpage.css">
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
						<li><a href="/ProjectWeb/admin/product/list">ProductsList</a></li>
						<li><a href="/ProjectWeb/admin">HOME</a>
						<li></li>

					</ul>
				</nav><a href = "/ProjectWeb/admin">
				<img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/account.png" width="30px"
					height="30px"></a>
			</div>
		</div>
	</div>
	<!---------------------------------->
	<div class="small-container">
		<h2 class="title">Bills List</h2>
		
		<div class="row">
			<table class="styled-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Customer</th>
						<th>Date</th>
						<th>TotalPrice</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${bills}" var="bill">
					<tr>
						<td>${bill.id }</td>
						<td>${bill.buyer.username }</td>
						<td>${bill.date }</td>
						<td> $${bill.totalBill } </td>
						<td><span> <a href="/ProjectWeb/admin/bill/delete?id=${bill.getId() }" class="btn">Delete</a> <a
								href="UpdateBill.html" class="btn">Update</a>
						</span></td>

					</tr>
					</c:forEach>
					<!-- and so on... -->
				</tbody>
			</table>
		</div>
</body>
</html>