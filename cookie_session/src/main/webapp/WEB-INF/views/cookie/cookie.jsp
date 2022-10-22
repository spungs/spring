<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
	<c:if test="${empty cookie.quizName.value }">
		<script>
		window.open('popup', '', 'width=400 height=200 top=200 left=300');
		</script>
	</c:if>
</head>
<body>
	<h1>쿠키 페이지 입니다.</h1>
	${cookie.quizName.value }
</body>
</html>