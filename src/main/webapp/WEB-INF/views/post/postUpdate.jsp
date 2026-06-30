<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codemate.DTO.PostDTO" %>
<%
	PostDTO post = (PostDTO) request.getAttribute("post");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/post/update" method="post">
	
	<input type="hidden" name="id" value="<%=post.getId() %>">
	
	제목 : 
	<input type="text" name="title" value="<%=post.getTitle() %>">
	<br><br>
	
	내용 :
	<input type="text" name="content" value="<%=post.getContent() %>">
	<br><br>
	
	<button type="submit">수정하기</button>
	
	</form>
</body>
</html>