<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product List</title>
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
						<li><a href="/ProjectWeb/admin/bill/list">BillsList</a></li>
						<li><a href="/ProjectWeb/admin">HOME</a>
						<li>
					</ul>
				</nav>
				<a href = "/ProjectWeb/admin">
				<img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/account.png" width="30px"
					height="30px"></a>
			</div>
		</div>
	</div>
	<!---------------------------------->
	<div class="small-container">
		<h2 class="title">Products List</h2>
		<a href="/ProjectWeb/admin/product/add" class="btn">Add Product</a>
		<form action="/ProjectWeb/admin/product/list" method="post">
			<div class="search">
		<span class="searchbox"> <input name="keyword" type="text" id="myInput"
			onkeyup="myFunction()" class="searchbox-txt" placeholder="Search..." />
			<button class="btn" type=submit>
				Search</a></span>
	</div>
	</form>
	<div class="row">
		<table class="styled-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Image</th>
					<th>Prices</th>
					<th>Category</th>
					<th>Desciption</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.name }</td>
						<td><img src="/ProjectWeb/dowload?image=${product.image}" width="50%"></td>
						<td>${product.price }</td>
						<td>${product.category.name }</td>
						<td>${product.description }</td>
						<td><span> <a
								href="/ProjectWeb/admin/product/delete?id=${product.getId() }"
								class="btn">Delete</a> <a
								href="/ProjectWeb/admin/product/update?id=${product.getId() }"
								class="btn">Update</a></span></td>

					</tr>
				</c:forEach>

				<!-- and so on... -->
			</tbody>
		</table>
	</div>


	<div class="page-btn">
		<span>1</span> <span>2</span> <span>3</span> <span>4</span> <span>&#8594;</span>
	</div>
	</div>
	
	</ body>
</html>