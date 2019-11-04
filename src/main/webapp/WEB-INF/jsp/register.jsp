<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<link rel="icon" type="image/png"
	href="/resources/login/images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/css/util.css">
<link rel="stylesheet" type="text/css"
	href="/resources/login/css/main.css">
<script src="/resources/login/vendor/animsition/js/animsition.min.js"></script>
<script src="/resources/login/vendor/bootstrap/js/popper.js"></script>
<script src="/resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/login/vendor/select2/select2.min.js"></script>
<script src="/resources/login/vendor/daterangepicker/moment.min.js"></script>
<script src="/resources/login/vendor/daterangepicker/daterangepicker.js"></script>
<script src="/resources/login/vendor/countdowntime/countdowntime.js"></script>
<script src="/resources/login/js/main.js"></script>

<div class="limiter">
	<div class="container-login100" style="min-height: 90vh">
		<div class="wrap-login100">
			<div class="login100-form-title"
				style="background-image: url('resources/login/images/bg-01.jpg');">
				<span class="login100-form-title-1"> 회원 가입 </span>
			</div>

			<form class="login100-form validate-form">
				<div class="wrap-input100 validate-input m-b-26"
					data-validate="Username is required">
					<span class="label-input100">Email</span> <input class="input100"
						type="email" id="email" name="email" placeholder="Email">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-18"
					data-validate="Password is required">
					<span class="label-input100">Password</span> <input
						class="input100" type="password" id="pwd" name="pwd"
						placeholder="Password"> <span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-26"
					data-validate="Username is required">
					<span class="label-input100">Name</span> <input class="input100"
						type="text" id="name" name="name" placeholder="Name"> <span
						class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-26"
					data-validate="Username is required">
					<span class="label-input100">Phone</span> <input class="input100"
						type="text" id="phone" name="phone" placeholder="Phone"> <span
						class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-26"
					data-validate="Username is required">
					<span class="label-input100">Address</span> <input class="input100"
						type="text" id="address" name="address" placeholder="Address">
					<span class="focus-input100"></span>
				</div>

				<div class="flex-sb-m w-full p-b-30"></div>
				<div class="container-login100-form-btn">
					<input type="button" class="login100-form-btn" id="registerBtn"
						name="registerBtn" value="REGISTER">
				</div>
			</form>
		</div>
	</div>
</div>

<script src="/resources/js/use/register.js"></script>

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->