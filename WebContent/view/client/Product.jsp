<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
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
	<div class="small-container">
		<div class="row row-2">
			<h2>All Products</h2>

			<c:forEach items="${categorylistsclient}" var="cate">
				<ul>
					<li><a
						href="/ProjectWeb/client/product/category?cid=${cate.id }">
							${cate.name }</a></li>
			</c:forEach>
			</ul>

		</div>
		<div class="row">
			<div class="wrap_searchform">
				<form action="/ProjectWeb/client/product/search" method="post">
					<div class="search">
						<input name="searchproduct" type="text" id="myInput"
							onkeyup="myFunction()" class="searchbox-txt"
							placeholder="Search..." />

						<button class="btn" type=submit>
							Search</a></span>
				</form>
			</div>
		</div>


		<div class="row">
			<c:forEach items="${productlistsclient}" var="p">
				<div class="col-4">
					<img src="/ProjectWeb/dowload?image=${p.image}" alt="aa"
						width="237px" height="237px">
					<h4>${p.name}</h4>
					<p>$${p.price}</p>
					<div class="row">
						<div class="col-1">
							<a href="/ProjectWeb/addtocart?pid=${p.id }" class="btn">Cart</a>
						</div>
						<div class="col-1">
							<a href="/ProjectWeb/product/detail?id=${p.id}" class="btn">Detail</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="page-btn">
			<span>1</span> <span>2</span> <span>3</span> <span>4</span> <span>&#8594;</span>
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