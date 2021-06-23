<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/adduser.css">
</head>
<body>
	<h1>Account Setting</h1>
    <div class="container">
        <form action="/ProjectWeb/member/account" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-25">
                    <label for="fname">ID</label>
                </div>
                <div class="col-75">
                    <input type="text" id="fname" name="id" placeholder="ID.." readonly="readonly" value="${user.id }">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="fname">Email</label>
                </div>
                <div class="col-75">
                    <input type="email" id="fname" name="email" placeholder="Your email.." value="${user.email }" >
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="fname">Avatar</label>
                </div>
                <div class="col-75">
                    <input type="file" id="fname" name="avatar" placeholder="..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="lname">Username</label>
                </div>
                <div class="col-75">
                    <input type="text" id="lname" name="username" placeholder="Your username.." value="${user.username }">
                </div>
            </div>
              <div class="row">
                <div class="col-25">
                    <label for="lname">Password</label>
                </div>
                <div class="col-75">
                    <input type="password" id="lname" name="password" placeholder="Your password.."  value="${user.password }">
                </div>
            </div>
             <div class="row">
                <div class="col-25">
                    <label for="lname"><a href ="/ProjectWeb/member/bill">Check Bill</a></label>
                     <label for="lname"><a  href ="/ProjectWeb/welcome">Homepage</a></label>
                       <label for="lname"><a  href ="/ProjectWeb/member/logout">Log out</a></label>
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