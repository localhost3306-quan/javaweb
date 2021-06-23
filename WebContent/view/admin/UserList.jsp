<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Users List</title>
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
						<li><a href="/ProjectWeb/admin/product/list">ProductsList</a></li>
						<li><a href="/ProjectWeb/admin/category/list">CategoriesList</a></li>
						<li><a href="/ProjectWeb/admin/bill/list">BillsList</a></li>
						<li><a href="/ProjectWeb/admin">HOME</a>
						<li>
					</ul>
				</nav>
				<a href = "/ProjectWeb/admin">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/account.png"
					width="30px" height="30px"></a>
			</div>
		</div>
	</div>
	<!---------------------------------->
	<div class="small-container">
		<h2 class="title">Users List</h2>
		<a href="/ProjectWeb/admin/user/add" class="btn">Add User</a>
		<form action="/ProjectWeb/admin/user/list" method="post">
			<div class="search">
		<span class="searchbox"> <input name="keyword" type="text" id="myInput"
			onkeyup="myFunction()" class="searchbox-txt" placeholder="Search username..." />
			<button class="btn" type=submit>
				Search</a></span>
	</div>
	</form>
		<div class="row">
			<table class="styled-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Email</th>
						<th>Image</th>
						<th>Username</th>
						<th>Password</th>
						<th>Role</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList }" var="list">
						<tr>
							<td>${list.id }</td>
							<td>${list.email }</td>
							<!-- 		<c:url value="/ProjectWeb/image?image=${list.avatar }"
								var="imgUrl"></c:url> 
							<td><img src="${imgUrl} width="50%"></td>-->

							<td><img src="/ProjectWeb/dowload?image=${list.avatar}" width="50%"></td>
							<td>${list.username }</td>
							<td>${list.password }</td>
							<td><c:choose>
									<c:when test="${list.roleId ==1 }">
													Admin
								</c:when>
									<c:otherwise>Client</c:otherwise>
								</c:choose></td>
							<td><span> <a
									href="/ProjectWeb/admin/user/delete?id=${list.getId() }"
									class="btn">Delete</a> <a
									href=" /ProjectWeb/admin/user/update?id=${list.getId() }"
									class="btn">Update</a>
							</span></td>

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
</body>

</html>