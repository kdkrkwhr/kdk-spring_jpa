<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<script src="/resources/js/use/boardRegister.js"></script>

<c:if test="${empty sessionMember }">
<script>
alert("로그인 후 게시글 작성이 가능합니다.");
location.href = '/login';
</script>
</c:if>

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
								<div class="row">
									<div class="col-12 col-lg-12">
										<div class="form-group">
											<strong>제목</strong>
											<input type="text" class="form-control" name="subject" id="subject"
												placeholder="제 목">
										</div>
									</div>
									<div class="col-12 col-lg-2">
										<div class="form-group">
											<strong>분야</strong>
											<select class="form-control" name="boardCat" id="boardCat" style="height:40px; width: 100%;">
												<option value="IT" selected="selected">IT & SOFTWARE</option>
												<option value="ART">ART & DESIGN</option>
												<option value="BUSUNESS">BUSUNESS</option>
												<option value="LANGUAGE">LANGUAGE</option>
											</select>
										</div>
									</div>
									<input type=hidden id="memberNo" name="memberNo" value="${sessionMember.no }"/>
									<div class="col-12 col-lg-2">
										<div class="form-group">
											<strong>인원</strong>
											<select class="form-control" name="totalPersonCnt" id="totalPersonCnt" style="height:40px; width: 100%;">
												<option value="1" selected="selected">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
											</select>
										</div>
									</div>
									<div class="col-12 col-lg-8">
										<div class="form-group">
											<strong>연락처</strong>
											<input type="text" id="communication" name="communication" class="form-control" id="phone"
												placeholder="연락처 or 오픈카카오톡 - *참가 희망 회원만 확인할 수 있습니다.*">
										</div>
									</div>
									<div class="col-12 col-lg-12">
										<textarea name="content" id="content" class="form-control"></textarea>
									</div>
									<div class="col-12" style="padding-top: 10px;" style="background: rgba(0,123,255,.25);">
										<input type="button" class="btn w-100" id="registerBtn" name="registerBtn" value="게시글 등록">
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->