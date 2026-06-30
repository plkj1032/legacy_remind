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
<title>게시글 작성</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/post/write">
		<input type="hidden" name="member_id" value="<%=loginUser.getId()%>">
		
		제목 :
		<input type="text" name="title">
		<br><br>
		
		내용 :
		<input type="text" name="content">
		<br><br>
		
		<button type="submit">글등록</button>
	</form>
</body>
</html>