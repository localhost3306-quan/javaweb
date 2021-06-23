<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/Home-style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="logo">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/rsz_watch-dogs-logo-led-neon-sign-red-2_preview_rev_1.png">
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
				width="30px" height="30px"></a> <img
				src="${pageContext.servletContext.contextPath}/RedStore_Img/images/menu.png"
				class="menu-icon" onclick="menutoggle()">
		</div>
	</div>
	<!--Single product detail-->
	<!--                 cart items                  -->
	<div class="small-container cart-page">
		<table>
			<tr>
				<th>PRODUCTS</th>
				<th>QUANTITY</th>
				<th>SUBTOTAL</th>
			</tr>
			<c:forEach items="${sessionScope.cart}" var="entry">
			<c:set var="total" value="${total + entry.value.quantity * entry.value.unitPrice}" />
				<tr>

					<td>
						<div class="cart-info">
							<img
								src="/ProjectWeb/dowload?image=${entry.value.product.image }">
							<div>
								<p>${entry.value.product.name }</p>
								<small>Price:$${entry.value.unitPrice } </small> <a
									href="/ProjectWeb/deletefromcart?key=${entry.key}">Remove</a>
							</div>
						</div>
					</td>
					<td>${entry.value.quantity }</td>
					<td>$${entry.value.quantity * entry.value.unitPrice}</td>
				</tr>
			</c:forEach>

		</table>
		<div class="total-price">
			<table>

				<tr>
					<td>TOTAL</td>
					<td>$${total }</td>
				</tr>
				<tr>
					<td><a href="/ProjectWeb/member/addorder" class="btn">Pay</a></td>
					<td><a href="/ProjectWeb/client/product/search" class="btn">Continue shopping</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!--featured product -->


	<!---------------------Brand----------------->

	<!---------------------FOOTER----------------->
	<div class=" footer">
		<div class="container">
			<div class="row">
				<div class="footer-col-1">
					<h3>Dowload Our App</h3>
					<p>Dowload App for Android and IOS mobile phone</p>
					<div class="app-logo">
						<img
							src="${pageContext.servletContext.contextPath}/RedStore_Img/images/play-store.png">
						<img
							src="${pageContext.servletContext.contextPath}/RedStore_Img/images/app-store.png">
					</div>
				</div>
				<div class="footer-col-2">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/rsz_watch-dogs-logo-led-neon-sign-red-2_preview_rev_1.png"
						alt="">
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