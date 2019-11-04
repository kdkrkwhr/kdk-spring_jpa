<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *Must* come first in the head; any other head content must come *after* these tags -->
<!-- Title -->
<title>Study Meeting</title>
<!-- Favicon -->
<link rel="icon" href="/resources/img/core-img/k_logo2.png">
<!-- Stylesheet -->
<link rel="stylesheet" href="/resources/style.css">
<!-- jQuery-2.2.4 js -->
<script src="/resources/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="/resources/js/bootstrap/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="/resources/js/bootstrap/bootstrap.min.js"></script>
<!-- SUMMER NOTE -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/lang/summernote-ko-KR.js"></script>
<!-- Common JS -->
<script src="/resources/js/use/common.js"></script>
</head>
<body>
	<header class="header-area">
		${alt }
		<!-- Top Header Area -->
		<div
			class="top-header-area d-flex justify-content-between align-items-center">
			<!-- Contact Info -->
			<div class="contact-info">
				<a href="#"><span>문의:</span> 010-9392-3762 </a> <a href="#"><span>이메일:</span>
					kdkdongki1997@gmail.com </a>
			</div>
			<!-- Follow Us -->
			<div class="follow-us">
				<span>Follow us</span> <a href="#" class="common-sns"><i
					class="fa fa-facebook" aria-hidden="true"></i></a> <a href="#"
					class="common-sns"><i class="fa fa-instagram"
					aria-hidden="true"></i></a> <a href="#" class="common-sns"><i
					class="fa fa-twitter" aria-hidden="true"></i></a>
			</div>
		</div>

		<!-- Navbar Area -->
		<div class="clever-main-menu">
			<div class="classy-nav-container breakpoint-off">
				<!-- Menu -->
				<nav class="classy-navbar justify-content-between" id="cleverNav">

					<!-- Logo -->
					<a class="nav-brand" href="/"><img
						src="/resources/img/core-img/k_logo2.png" alt=""></a>

					<!-- Navbar Toggler -->
					<div class="classy-navbar-toggler">
						<span class="navbarToggler"><span></span><span></span><span></span></span>
					</div>

					<!-- Menu -->
					<div class="classy-menu">

						<!-- Close Button -->
						<div class="classycloseIcon">
							<div class="cross-wrap">
								<span class="top"></span><span class="bottom"></span>
							</div>
						</div>

						<!-- Nav Start -->
						<div class="classynav">
							<ul>
								<li><a href="/">Home</a></li>
								<li><a href="#">스터디 모집</a>
									<ul class="dropdown">
										<li><a href="/board/it">IT & SOFTWARE</a></li>
										<li><a href="/board/art">ART & DESIGN</a></li>
										<li><a href="/board/busuness">BUSINESS</a></li>
										<li><a href="/board/language">LANGUAGES</a></li>
									</ul></li>
								<li><a href="/board/reply">스터디 후기</a></li>
								<li><a href="/board/store">자료실</a></li>
								<li><a href="/location">문의하기</a></li>
							</ul>

							<!-- Search Button -->
							<div class="search-area">
								<form method="get" action="/board/search">
									<input type="search" name="search" id="search"
										placeholder="Search">
									<button type="submit">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</form>
							</div>

							<c:if test="${not empty sessionMember }">
								<div class="login-state d-flex align-items-center">
									<div class="user-name mr-30">
										<div class="dropdown">
											<a class="dropdown-toggle" href="#" role="button"
												id="userName" data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">${sessionMember.email }</a>
											<div class="dropdown-menu dropdown-menu-right"
												aria-labelledby="userName">
												<a class="dropdown-item" href="" class="common-sns">Profile</a> <a
													class="dropdown-item" id="logOut" href="">Logout</a>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<c:if test="${empty sessionMember }">
								<div class="register-login-area">
									<a href="/register" class="btn">회원가입</a> <a href="/login" class="btn">로그인</a>
								</div>
							</c:if>
						</div>
					</div>
					<!-- Nav End -->
			</div>
			</nav>
		</div>
		</div>
	</header>