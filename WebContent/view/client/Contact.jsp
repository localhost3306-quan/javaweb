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
	<!---------------ACCOUNT PAGE------------------>
	<div class="account-page">
		<div class="container">
			<div class="row">
				<!--  <div class="col-2">
                    <img src="RedStore_Img/images/Q7CNR_SQ1_0000000099_N_A_SLf_preview_rev_1.png" width="100%">
                </div> -->
				<div id="map" style="width: 500px; height: 500px;">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.738271759003!2d105.8032667149322!3d21.003126086012337!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135aca2809fea2d%3A0xfdd85937512dcd3!2zSGVpIFRvd2VyLCAxIE5n4buleSBOaMawIEtvbiBUdW0sIE5ow6JuIENow61uaCwgVGhhbmggWHXDom4sIEjDoCBO4buZaQ!5e0!3m2!1sen!2s!4v1606101074086!5m2!1sen!2s"
						width="600" height="450" frameborder="0" style="border: 0;"
						allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
				</div>
				<div class="col-2">
					<div class="form-container">
						<div class="form-btn">
							<span onclick="register()">Contact</span>
						</div>

						<form id="RegisterForm">
							<input type="text" placeholder="username..."> <input
								type="email" placeholder="email..."> <input
								type="password" placeholder="password...">
							<button type="submit" class="btn">Send request</button>
						</form>
					</div>
				</div>
			</div>
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
						<img src="RedStore_Img/images/app-store.png">
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

	<!----------JS FORM LOGIN REGISTER------------------------>

	<script>
		var LgForm = document.getElementById("LoginForm");
		var RgForm = document.getElementById("RegisterForm");
		var Indi = document.getElementById("Indicator");

		function register() {
			RgForm.style.transform = "translateX(0px)";
			LgForm.style.transform = "translateX(0px)";
			Indi.style.transform = "translateX(100px)";
		}
		function login() {
			RgForm.style.transform = "translateX(300px)";
			LgForm.style.transform = "translateX(300px)";
			Indi.style.transform = "translateX(0px)";
		}
	</script>
</body>

</html>