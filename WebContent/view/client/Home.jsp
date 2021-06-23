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
	<div class="header">
		<div class="container">
			<div class="navbar">
				<div class="logo">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/rsz_watch-dogs-logo-led-neon-sign-red-2_preview_rev_1.png">
				</div>
				<nav>
					<ul id="MenuItems">
						<li><a href="/ProjectWeb/welcome">Home</a></li>
						<li><a href="/ProjectWeb/client/product/search">Products</a>
						</li>
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


			<div class="row">
				<div class="col-2">
					<h1>
						Give Your Workout<br>A New Style
					</h1>
					<p>
						Success isn't always about greatness. It's about consistency.
						Consistent<br>hard work gains sucess. Greatness will come
					</p>
					<a href="/ProjectWeb/client/product/search" class="btn">Explore Now &#8594;</a>
				</div>

				<div class="col-2">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh4_preview_rev_1.png">
				</div>
			</div>
		</div>
	</div>
	

	<!--featured product -->
	<div class="small-container">
		
		<h2 class="title">Latest Products</h2>
		<div class="row">
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh2.jpg">
				
				
			</div>
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh1.jpg">
				
				
			</div>
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh4.jpg">
				
				
			</div>
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh3.jpg">
				
				
			</div>
		</div>
		<div class="row">
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh4.jpg">
				
				
			</div>
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh5.jpg">
				
			</div>
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh3.jpg">
				<!--  	<h4>Rolex</h4>
				<p>$50.00</p>
			  	<div class="row">
					<div class="col-1">
						<a href="#" class="btn">Cart</a>
					</div>
					<div class="col-1">
						<a href="#" class="btn">Detail</a>
					</div>
				</div>-->
			</div>
			<div class="col-4">
				<img
					src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh4.jpg">
				
				
			</div>
		</div>
	</div>
	<!--OFFER-->
	<div class="offer">
		<div class="small-container">
			<div class="row">
				<div class="col-2">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/exclusive.png">
				</div>
				<div class="col-2">
					<p>Exclusive Available on RedStore</p>
					<h1>Smart Band</h1>
					<small>The Mi Smart Band 4 features a 39.9% larger (than Mi
						band 3) AMOLED color full touch display with adjustable
						brightness, so everything is clear as can be. </small> <a href="/ProjectWeb/client/product/search"
						class="btn">Buy Now</a>
				</div>
			</div>
		</div>
	</div>


	<!--testimonial-->
	<div class="testimonial">
		<div class="small-container">
			<div class="row">
				<div class="col-3">
					<p>"Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry's standard
						dummy text ever"</p>
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh6.jpg">
					<h3>SSS</h3>
				</div>
				<div class="col-3">
					<p>"Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry's standard
						dummy text ever"</p>
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh6.jpg">
					<h3>PPP</h3>
				</div>
				<div class="col-3">
					<p>"Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry's standard
						dummy text ever"</p>
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/anh6.jpg">
					<h3>DDD</h3>
				</div>
			</div>
		</div>
	</div>
	<!---------------------Brand----------------->
	<div class="brands">
		<div class="small-container">
			<div class="row">
				<div class="col-5">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/logo-paypal.png">
				</div>
				<div class="col-5">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/logo-paypal.png">
				</div>
				<div class="col-5">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/logo-paypal.png">
				</div>
				<div class="col-5">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/logo-paypal.png">
				</div>
				<div class="col-5">
					<img
						src="${pageContext.servletContext.contextPath}/RedStore_Img/images/logo-paypal.png"">
				</div>
			</div>

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