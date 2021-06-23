<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Category form</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/addproduct.css">
</head>
<body>
	<h1>Update Product</h1>
	<div class="container">
		<form action="/ProjectWeb/admin/product/update" method="post"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-25">
					<label for="fname">ID</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="id" placeholder="ID.."
						readonly="readonly" value="${product.id }">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="fname">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="name"
						placeholder="Your product name.." value="${product.name }">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="fname">Image</label>
				</div>
				<div class="col-75">
					<input type="file" id="fname" name="image" placeholder="..">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="lname">Price</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="price"
						placeholder="Your product price.." value="${product.price }">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="country">Category</label>
				</div>
				<div class="col-75">
					<select id="country" name="category">
						<c:forEach items="${categories}" var="category">
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
					<input value="${product.description }" class="form-control"
						type="text" name="description" placeholder="description">
				</div>
			</div>
			<div class="row">
				<span></span> <input type="submit" value="Update"> </span>
			</div>
		</form>
	</div>
</body>

</html>