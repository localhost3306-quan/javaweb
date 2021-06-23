<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add product form</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/addproduct.css">
</head>
<body>
	<h1>Add Product</h1>
	<div class="container">
		<form action="/ProjectWeb/admin/product/add" method="post" 
				enctype="multipart/form-data">
			<div class="row">
				<div class="col-25">
					<label for="fname">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="name"
						placeholder="Your product name..">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="fname">Image</label>
				</div>
				<div class="col-75">
					<input type="file" id="fname" name="image" accept="image/*" >
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="lname">Price</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="price" placeholder="Price..">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="country">Category</label>
				</div>
				<div class="col-75">
					<select id="country" name="category1">
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.id}">${category.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="subject">Description</label>
				</div>
				<div class="col-75">
					<input id="subject"  name="description" type="text"
						placeholder="Write description.." style="height: 200px">
					</textarea>
				</div>
			</div>
			<div class="row">
				<span></span> <input type="submit" value="Submit"> 
			</div>
		</form>
	</div>
</body>

</html>