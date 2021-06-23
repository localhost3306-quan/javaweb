<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add user form</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/addcategory.css">
</head>
<body>
	<h1>Add Category</h1>
	<div class="container">
		<form action="/ProjectWeb/admin/category/add" method="post">

			<div class="row">
				<div class="col-25">
					<label for="lname">Category Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="cname"
						placeholder="Category Name..">
				</div>
			</div>
			<div class="row">
				<span></span> <input type="submit" value="Submit"> </span>
			</div>
		</form>
	</div>
</body>

</html>