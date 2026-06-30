<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codemate.DTO.MemberDTO" %>
<%
	MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>진 짜 볼 품 없 음</h1>
	<%if(loginUser == null) {%>
	<a href="${pageContext.request.contextPath}/member/signup">회원가입</a>
	<a href="${pageContext.request.contextPath}/member/login">로그인</a>
	<a href="${pageContext.request.contextPath}/post/list">게시글 목록</a>
	<%} else{ %>
	<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	<a href="${pageContext.request.contextPath}/post/list">게시글 목록</a>
	<%} %>
</body>
</html>