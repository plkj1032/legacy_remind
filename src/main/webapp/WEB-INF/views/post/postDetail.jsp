<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codemate.DTO.PostDTO" %>
<%@ page import="com.codemate.DTO.MemberDTO" %>
<%
	PostDTO post = (PostDTO) request.getAttribute("post");
	MemberDTO loginUser = (MemberDTO) request.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<p><%=post.getId() %></p>
	<p><%=post.getTitle() %></p>
	<p><%=post.getContent() %></p>
	<p><%=post.getCreated_at() %></p>
	<%if(loginUser != null) {%>
		<a href="${pageContext.request.contextPath}/post/update?id=<%=post.getId() %>">
		수정하기
		</a>
		<a href="${pageContext.request.contextPath}/post/delete?id=<%=post.getId() %>">
		삭제하기
		</a>
	<%} %>
</body>
</html>