<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Category form</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/adduser.css">
</head>
<body>
	 <h1>Update Category</h1>
    <div class="container">
        <form action="/ProjectWeb/admin/category/update" method="post" >
            <div class="row">
                <div class="col-25">
                    <label for="fname">Id</label>
                </div>
                <div class="col-75">
                    <input readonly="readonly" type="text" name="id" value="${category.getId()}">
                </div>
            </div>
          
            <div class="row">
                <div class="col-25">
                    <label for="lname">Category Name</label>
                </div>
                <div class="col-75">
                    <input value="${category.getName()}" type="text" name="name" placeholder="Category name ...">
                </div>
            </div>
            <div class="row">
                <span></span>
                <input type="submit" value="Submit">
                </span> 
            </div>
        </form>
    </div>
</body>

</html>