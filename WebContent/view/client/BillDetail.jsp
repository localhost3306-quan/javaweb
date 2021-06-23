<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bill</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/Home-style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
</head>
<body>
	  <!------heade------------>
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/rsz_watch-dogs-logo-led-neon-sign-red-2_preview_rev_1.png">
            </div>
            <nav>
                <ul id="MenuItems">
                  <li><a href="/ProjectWeb/welcome">Home</a></li>
					<li><a href="/ProjectWeb/client/product/search">Products</a></li>
					<li><a href="/ProjectWeb/contact">Contact</a></li>
                    <li><a href="/ProjectWeb/member/account">Account</a></li>
                </ul>
            </nav>
            <a href="/ProjectWeb/cart"> <img
				src="${pageContext.servletContext.contextPath}/RedStore_Img/images/cart.png"
				width="30px" height="30px"></a>
            <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
    </div>

    <div class="small-container">
        <h2 class="title">Bill Detail</h2>
        <h3>Info Bill </h3>
        <ul >
            <li><a >1.Bill ID: ${bill.id }</a></li>
            <li><a >2.Customer: ${bill.buyer.username}</a></li>
            <li><a >3.Date: ${bill.date }</a></li>
            <li><a >4.Total :$ ${bill.totalBill}</a></li>
           
        </ul>

        <div class="row">
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Quantity</th>
                        <th>Unit Price</th>
                        <th>Total Prices</th>

                    </tr>
                </thead>
                <c:forEach items="${billProducts}" var="billProduct">
                <tbody>
                    <tr>
                        <td>${billProduct.id}</td>
                        <td><a
						href="/ProjectWeb/product/detail?id=${billProduct.product.id }">${billProduct.product.name }</a></td>
                        <td>
                            <img src="/ProjectWeb/dowload?image=${billProduct.product.image }" width="50%">
                        </td>
                        <td>${billProduct.quantity}</td>
                        <td>$${billProduct.unitPrice}</td>
                        <td>$${billProduct.unitPrice * billProduct.quantity}</td>

                    </tr>
           
                </tbody>
                </c:forEach>
            </table>
        </div>


    </div>



    <!---------------------FOOTER----------------->
    <div class=" footer">
        <div class="container">
            <div class="row">
                <div class="footer-col-1">
                    <h3>Dowload Our App</h3>
                    <p>Dowload App for Android and IOS mobile phone</p>
                    <div class="app-logo">
                        <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/play-store.png">
                        <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/app-store.png">
                    </div>
                </div>
                <div class="footer-col-2">
                    <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/rsz_watch-dogs-logo-led-neon-sign-red-2_preview_rev_1.png" alt="">
                    <p>Our purpose is to make best products</p>
                </div>
                <div class="footer-col-3">
                    <h3>Useful Links</h3>
                    <ul>
                        <li>Coupons</li>
                        <li>Blog Post</li>
                        <li>Return Policy</li>
                        <li>Join Affiliate</li>
                    </ul>
                </div>
                <div class="footer-col-4">
                    <h3>Follow us</h3>
                    <ul>
                        <li>Facebook</li>
                        <li>Twitter</li>
                        <li>Instagram</li>
                        <li>Youtube</li>
                    </ul>
                </div>
            </div>
            <hr>
            <p class="copyright">Copyright</p>
        </div>
    </div>
    <!---------------------JAVASCRIPT--------------->
    <script>
        var MenuItems = document.getElementById("MenuItems");
        MenuItems.style.maxHeight = "0px";

        function menutoggle() {
            if (MenuItems.style.maxHeight == "0px") {
                MenuItems.style.maxHeight = "200px";
            } else {
                MenuItems.style.maxHeight = "0px";
            }
        }

    </script>

</body>

</html>