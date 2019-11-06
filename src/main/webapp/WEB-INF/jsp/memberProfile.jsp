<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<c:if test="${empty sessionMember }">
<script>
alert("로그인 후 나의 프로필을 확인하실 수 있습니다.");
location.href = '/login';
</script>
</c:if>
<hr/>
이름 : ${sessionMember.name } <br/><hr/>
연락처 : ${sessionMember.phone } <br/><hr/>
주소 : ${sessionMember.address } <br/>
<hr/>
<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->