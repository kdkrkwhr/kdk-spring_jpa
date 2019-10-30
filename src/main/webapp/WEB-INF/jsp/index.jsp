<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>SPRING - BOOT - START</h1>
<hr/>
<c:if test = "${not empty memberList }">
	<c:forEach var="member" items="${memberList }">
		No. ${member.no } <br/> NAME: ${member.name}<hr/>
	</c:forEach>
</c:if>
<c:if test = "${not empty member }">
	특정 조회 : ${member.no } <br/> 전화번호 : ${member.name }<hr/>
</c:if>
</body>
</html>