<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<!-- ##### Hero Area Start ##### -->
<section class="hero-area bg-img bg-overlay-2by5"
	style="background-image: url('/resources/img/bg-img/bg1.jpg');">
	<div class="container h-100">
		<div class="row h-100 align-items-center">
			<div class="col-12">
				<!-- Hero Content -->
				<div class="hero-content text-center">
					<h2>Let's Study Together</h2>
					<a href="#" class="btn clever-btn">Get Started</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ##### Hero Area End ##### -->

<!-- ##### Cool Facts Area Start ##### -->
<section class="cool-facts-area section-padding-100-0">
	<div class="container">
		<div class="row">
			<!-- Single Cool Facts Area -->
			<div class="col-12 col-sm-6 col-lg-4">
				<div class="single-cool-facts-area text-center mb-100 wow fadeInUp"
					data-wow-delay="250ms">
					<div class="icon">
						<img src="/resources/img/core-img/star.png" alt="">
					</div>
					<h2>
						<span class="counter">${newBoardCnt }</span>
					</h2>
					<h5>오늘 등록된 스터디</h5>
				</div>
			</div>

			<!-- Single Cool Facts Area -->
			<div class="col-12 col-sm-6 col-lg-4">
				<div class="single-cool-facts-area text-center mb-100 wow fadeInUp"
					data-wow-delay="500ms">
					<div class="icon">
						<img src="/resources/img/core-img/star.png" alt="">
					</div>
					<h2>
						<span class="counter">${weekBoardCnt }</span>
					</h2>
					<h5>이번주 등록된 스터디</h5>
				</div>
			</div>

			<!-- Single Cool Facts Area -->
			<div class="col-12 col-sm-6 col-lg-4">
				<div class="single-cool-facts-area text-center mb-100 wow fadeInUp"
					data-wow-delay="750ms">
					<div class="icon">
						<img src="/resources/img/core-img/star.png" alt="">
					</div>
					<h2>
						<span class="counter">${totalBoardCnt }</span>
					</h2>
					<h5>총 진행된 스터디</h5>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ##### Cool Facts Area End ##### -->

<!-- ##### Popular Courses Start ##### -->
<section class="popular-courses-area section-padding-100-0"
	style="background-image: url('/resources/img/core-img/texture.png');">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading">
					<h3>모집중인 스터디</h3>
				</div>
			</div>
		</div>

		<div class="row">
			<c:forEach var = "board" items = "${boardList }">
				<!-- Single Popular Course -->
				<div class="col-12 col-md-6 col-lg-4">
					<div class="single-popular-course mb-100 wow fadeInUp"
						data-wow-delay="250ms">
						<!-- Course Content -->
						<div class="course-content">
							<h4>${board.subject }</h4>
							<div class="meta d-flex align-items-center">
								<a href="#">${board.memberNo }</a> <span><i class="fa fa-circle"
									aria-hidden="true"></i></span> <a href="#">${board.boardCat }</a>
							</div>
							<p style="height: 200px;overflow:auto;">
							${board.content }
						    </p>
						</div>
						<!-- Seat Rating Fee -->
						<div class="seat-rating-fee d-flex justify-content-between">
							<div class="seat-rating h-100 d-flex align-items-center">
								<div class="seat">
									<i class="fa fa-user" aria-hidden="true"></i> 0 / ${board.totalPersonCnt }
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- ##### Popular Courses End ##### -->

<!-- ##### Blog Area Start ##### -->
<section class="blog-area section-padding-100-0">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading">
					<h3>스터디 후기</h3>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- Single Blog Area -->
			<div class="col-12 col-md-6">
				<div class="single-blog-area mb-100 wow fadeInUp"
					data-wow-delay="250ms">
					<img src="/resources/img/blog-img/1.jpg" alt="">
					<!-- Blog Content -->
					<div class="blog-content">
						<a href="#" class="blog-headline">
							<h4>김동기 작곡 스터디</h4>
						</a>
						<div class="meta d-flex align-items-center">
							<a href="#">김동기</a> <span><i class="fa fa-circle"
								aria-hidden="true"></i></span> <a href="#">Art &amp; Design</a>
						</div>
						<p>김동기 멋있어요.</p>
					</div>
				</div>
			</div>

			<!-- Single Blog Area -->
			<div class="col-12 col-md-6">
				<div class="single-blog-area mb-100 wow fadeInUp"
					data-wow-delay="500ms">
					<img src="/resources/img/blog-img/2.jpg" alt="">
					<!-- Blog Content -->
					<div class="blog-content">
						<a href="#" class="blog-headline">
							<h4>김동기 코딩 스터디</h4>
						</a>
						<div class="meta d-flex align-items-center">
							<a href="#">김동기</a> <span><i class="fa fa-circle"
								aria-hidden="true"></i></span> <a href="#">IT &amp; BUSINESS</a>
						</div>
						<p>김동기씨 멋있어요.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ##### Blog Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->