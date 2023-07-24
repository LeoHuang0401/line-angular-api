<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>One Page Wonder - Start Bootstrap Template</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
	rel="stylesheet" />
	
<!-- Bootstrap V5.0.2-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/app.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet" />
<script src="<c:out value="/onlineOrder/resources/jquery/jquery.min.js" />"></script>
<style>
.nav-counter{
	position: absolute;
    left: 10px;
	width: 21px;
    line-height: 20px;
    padding: 0 6px;
    font-weight: normal;
    color: white;
    text-align: center;
    font-size: 10px;
    text-shadow: 0 1px rgba(0,0,0, 0.2);
    border-radius: 11px;
    box-shadow: inset 0 0 1px 1px rgba(255,255,255,0.1), 0 1px rgba(0,0,0,0.12);
    margin-left:50%;
    transform: translate(-50%, -50%);
}
.nav-counter-blue{
	background:#e8616c;
	Background-image:linear-gradient(to bottom,orange,orange);
}
</style>
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
		<div class="container px-5">
			<a class="navbar-brand" href="#page-top">
				點餐平台
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="<c:url value="/order" />">點餐</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/shopCar" />">購物車</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/orderHistory" />">歷史訂單</a></li>
					<li class="nav-item"><img
						class="img-fluid rounded-circle width-40"
						id="picture"
						src="<c:url value=""/>" alt="..." /></li>
					<li class="nav-item"><a id="uName" class="nav-link" href="#!"></a></li>
				</ul>
					<input type="hidden" id="uLineD" name="uLineD">
			</div>
		</div>
	</nav>
	<!-- Content section 1-->
	<sitemesh:write property="body"/>
	
	<!-- Footer-->
	<footer>
	<div class="bg-gray fixed-bottom" style="height: 60px">
		<div class="" style="height: 100%;background:#FFFAFA;color:gray">
			<div class="col-4" align="center" style="margin-top:5px;float:left;"><a href="<c:url value="/order" />"><i class="fa-solid fa-utensils" style="color:gray"></i></a><br>點餐</div>
			<div class="col-4" align="center" style="margin-top:5px;float:left;">
			<div class="nav-counter nav-counter-blue" <c:if test="${shopCarNum != null && shopCarNum >= 10}"> style="width:26px"</c:if>><c:if test="${shopCarNum != null && shopCarNum != 0}">${shopCarNum}</c:if></div><a id="shopCar" onclick="location.href='<c:url value="/shopCar" />'">
			<i class="fa-solid fa-cart-shopping" style="color:gray;z-index:2;displayblock"></i>
			</a><br>購物車</div>
			<div class="col-4" align="center" style="margin-top:5px;float:left;"><a href="<c:url value="/orderHistory" />"><i class="fa-sharp fa-solid fa-clipboard-check" style="color:gray"></i></a><br>歷史訂單</div>
		</div>
	</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<!-- Line LIFF SDK v2 版 -->
<!-- 	<script src="https://static.line-scdn.net/liff/edge/2/sdk.js"></script> -->
	<!-- Core theme JS-->
<%-- 	<script src="<c:url value="/resources/js/scripts.js"/>"></script> --%>
<%-- 	<script src="<c:url value="/resources/js/line-liff.js"/>"></script>  --%>
	<script type="text/javascript">
	function getUser(){
		$.ajax({
			   type: "POST",
			   url: '<c:url value="/order/Line" />',
			   data: {id:$('#uLineD').val(),name:$('#uName').text()}
		   })
	}
	</script>
</body>
</html>
