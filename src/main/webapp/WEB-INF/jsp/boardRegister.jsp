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
	class="register-now section-padding-100-0 d-flex justify-content-between align-items-center"
	style="padding-top: 40px; padding-bottom: 40px;">
	<!-- Register Contact Form -->
	<div class="register-contact-form wow fadeInUp" data-wow-delay="250ms"
		style="visibility: visible; animation-delay: 250ms; animation-name: fadeInUp; min-width: 100%;">
		<div class="register-contact-form mb-0 wow fadeInUp"
			data-wow-delay="250ms"
			style="visibility: visible; animation-delay: 250ms; animation-name: fadeInUp; min-width: 100%;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="forms">
							<h4>${cn }</h4>
							<div class="row">
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>제목</strong> <input type="text" class="form-control"
											name="subject" id="subject" placeholder="제 목"
											value="${board.subject }">
									</div>
								</div>
								<div class="col-12 col-lg-2">
									<div class="form-group">
										<strong>분야</strong> <select class="form-control"
											name="boardCat" id="boardCat"
											style="height: 40px; width: 100%;">
											<option value="IT"
												<c:if test="${board.boardCat eq 'IT' || board.boardCat eq null }">
														selected="selected"
													</c:if>>IT
												& SOFTWARE</option>
											<option value="ART"
												<c:if test="${board.boardCat eq 'ART'}">
														selected="selected"
													</c:if>>ART
												& DESIGN</option>
											<option value="BUSINESS"
												<c:if test="${board.boardCat eq 'BUSINESS'}">
														selected="selected"
													</c:if>>BUSINESS</option>
											<option value="LANGUAGE"
												<c:if test="${board.boardCat eq 'LANGUAGE'}">
														selected="selected"
													</c:if>>LANGUAGE</option>
										</select>
									</div>
								</div>
								<input type=hidden id="memberNo" name="memberNo"
									value="${sessionMember.no }" />
								<div class="col-12 col-lg-2">
									<div class="form-group">
										<strong>인원</strong> <select class="form-control"
											name="totalPersonCnt" id="totalPersonCnt"
											style="height: 40px; width: 100%;">
											<option value="1" <c:if test="${board.totalPersonCnt eq 1 || board.totalPersonCnt eq null }">selected="selected"</c:if>> 1</option>
											<option value="2" <c:if test="${board.totalPersonCnt eq 2 }">selected="selected"</c:if>>2</option>
											<option value="3" <c:if test="${board.totalPersonCnt eq 3 }">selected="selected"</c:if>>3</option>
											<option value="4" <c:if test="${board.totalPersonCnt eq 4 }">selected="selected"</c:if>>4</option>
											<option value="5" <c:if test="${board.totalPersonCnt eq 5 }">selected="selected"</c:if>>5</option>
											<option value="6" <c:if test="${board.totalPersonCnt eq 6 }">selected="selected"</c:if>>6</option>
											<option value="7" <c:if test="${board.totalPersonCnt eq 7 }">selected="selected"</c:if>>7</option>
											<option value="8" <c:if test="${board.totalPersonCnt eq 8 }">selected="selected"</c:if>>8</option>
											<option value="9" <c:if test="${board.totalPersonCnt eq 9 }">selected="selected"</c:if>>9</option>
											<option value="10" <c:if test="${board.totalPersonCnt eq 10 }">selected="selected"</c:if>>10</option>
										</select>
									</div>
								</div>
								<div class="col-12 col-lg-8">
									<div class="form-group">
										<strong>연락처</strong> <input type="text" id="communication"
											name="communication" class="form-control" id="phone"
											placeholder="연락처 or 오픈카카오톡 - *참가 희망 회원만 확인할 수 있습니다.*"
											value="${board.communication }">
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<textarea name="content" id="content" class="form-control">${board.content }</textarea>
								</div>
								<div class="col-12" style="padding-top: 10px;"
									style="background: rgba(0,123,255,.25);">
										<input type="button" class="btn w-100" id="${btnType }"
											name="${btnType }" value="${cn }">
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