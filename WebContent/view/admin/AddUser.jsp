<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add user form</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/adduser.css">
</head>
<body>
	<h1>Add User</h1>
	<div class="container">
		<form action="/ProjectWeb/admin/user/add" method="post"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-25">
					<label for="fname">Email</label>
				</div>
				<div class="col-75">
					<input type="email" id="fname" name="email"
						placeholder="Your email. ." required="">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="fname">Image</label>
				</div>
				<div class="col-75">
					<input type="file" id="fname" name="avatar">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="lname">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="username"
						placeholder="Your username.." required="">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Password</label>
				</div>
				<div class="col-75">
					<input type="password" id="lname" name="password"
						placeholder="Your password.." required="">
				</div>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="lname">Role</label>
				</div>
				<div class="col-75">
					<input type="radio" value="1" name="role">Admin </br> <input
						type="radio" value="2" name="role">Client
				</div>
			</div>
			<div class="row">
				<span> <input type="submit" value="Submit">

				</span>
			</div>
		</form>
	</div>
</body>

</html>