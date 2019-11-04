<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<section
	class="register-now section-padding-100-0 d-flex justify-content-between align-items-center" style="padding-top: 40px; padding-bottom: 40px;">
	<!-- Register Contact Form -->
	<div class="register-contact-form wow fadeInUp"
		data-wow-delay="250ms"
		style="visibility: visible; animation-delay: 250ms; animation-name: fadeInUp; min-width: 100%;">
		<div class="register-contact-form mb-0 wow fadeInUp"
			data-wow-delay="250ms"
			style="visibility: visible; animation-delay: 250ms; animation-name: fadeInUp; min-width: 100%;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="forms">
							<h4>게시글 등록</h4>
							<form action="#" method="post">
								<div class="row">
									<div class="col-12 col-lg-12">
										<div class="form-group">
											<input type="text" class="form-control" id="text"
												placeholder="제 목">
										</div>
									</div>
									<div class="col-12 col-lg-2">
										<div class="form-group">
											<select name="job" style="height:40px; width: 100%;">
												<option value="IT" selected="selected">IT & SOFTWARE</option>
												<option value="ART">ART & DESIGN</option>
												<option value="BUSUNESS">BUSUNESS</option>
												<option value="LANGUAGE">LANGUAGE</option>
											</select>
										</div>
									</div>
									<div class="col-12 col-lg-10">
										<div class="form-group">
											<input type="text" class="form-control" id="phone"
												placeholder="연락처 or 오픈카카오톡 - *참가 희망 회원만 확인할 수 있습니다.*">
										</div>
									</div>
									<div class="col-12 col-lg-12">
										<textarea name="content" id="content"></textarea>
									</div>
									<div class="col-12">
										<button class="btn clever-btn w-100">게시글 등록</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="/resources/js/use/insert.js"></script>

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->