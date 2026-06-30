<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codemate.DTO.PostDTO" %>
<%@ page import="java.util.List" %>
<% List<PostDTO> list = (List<PostDTO>) request.getAttribute("posts"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>게시글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성시간</th>
		</tr>
		<% if(list != null){ %>
			<%for(PostDTO p : list){%>
			<tr>
				<td><%=p.getId() %></td>
				<td><%=p.getTitle() %></td>
				<td><%=p.getContent() %></td>
				<td><%=p.getCreated_at() %></td>
			</tr>
			<%} %>
		<%} else {%>
		<tr>
			<td colspan="5">게시글이 없습니다.</td>
		</tr>
		<%} %>
	</table>
</body>
</html>