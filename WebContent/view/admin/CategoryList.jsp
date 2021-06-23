<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Category List</title>
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
                        <li><a href="/ProjectWeb/admin/product/list">ProductsList</a></li>
                        <li><a href="/ProjectWeb/admin/bill/list">BillsList</a></li>
                        <li><a href ="/ProjectWeb/admin">HOME</a><li>
                    </ul>
                </nav><a href = "/ProjectWeb/admin">
                <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/account.png" width="30px" height="30px"></a>
            </div>
        </div>
    </div>
    <!---------------------------------->
    <div class="small-container">
        <h2 class="title">Categories List</h2>
        <a href="/ProjectWeb/admin/category/add" class="btn">Add Category</a>
      <!--  <div class="search">
            <span class="searchbox">
                <input type="text" name="" class="searchbox-txt" placeholder="Search..." />
                <a class="btn" href ="#">Search</a>
            </span>
        </div>-->
        <div class="row">
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Category Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${cateList }" var="list">
                    <tr>
                        <td>${list.id }</td>
                        <td>${list.name }</td>
                        <td>
                            <span>
                                <a href="/ProjectWeb/admin/category/delete?id=${list.getId() }" class="btn">Delete</a>
                                <a href="/ProjectWeb/admin/category/update?id=${list.getId() }" class="btn">Update</a>
                            </span>
                        </td>

                    </tr>
                   </c:forEach>
                    <!-- and so on... -->
                </tbody>
            </table>
        </div>


        <div class="page-btn">
            <span>1</span>
            <span>2</span>
            <span>3</span>
            <span>4</span>
            <span>&#8594;</span>
        </div>
    </div>
</body>

</html>