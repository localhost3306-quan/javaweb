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
            <a href ="/ProjectWeb/cart"> <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/cart.png" width="30px" height="30px"></a>
            <img src="${pageContext.servletContext.contextPath}/RedStore_Img/images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
    </div>
    <!--Single product detail-->
    <div class="small-container single-product">
        <div class="row">
            <div class="col-2">
                <img src="/ProjectWeb/dowload?image=${productlistsclient.image}" width="100%" id="ProductImg">
            </div>
            <div class="col-2">
                <p>Home / Products</p>
                <h1>${productlistsclient.name}</h1>
                <h4>Price: $${productlistsclient.price} </h4>
     
                <a href="/ProjectWeb/addtocart?pid=${productlistsclient.id }" class="btn">Art to Cart</a>
                <h3>Description</h3>
                <p>${productlistsclient.description}</p>
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

    <!-- js for product gallery-->
    <script>
        var ProductImg = document.getElementById("ProductImg");
        var SmallImg = document.getElementsByClassName("small-img");
        SmallImg[0].onclick = function()
        {
            ProductImg.src = SmallImg[0].scr;
        }
        SmallImg[1].onclick = function()
        {
            ProductImg.src = SmallImg[1].scr;
        }

        SmallImg[2].onclick = function()
        {
            ProductImg.src = SmallImg[2].scr;
        }

        SmallImg[3].onclick = function()
        {
            ProductImg.src = SmallImg[3].scr;
        }


    </script>

</body>

</html>