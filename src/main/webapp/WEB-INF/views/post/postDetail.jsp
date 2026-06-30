<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codemate.DTO.PostDTO" %>
<%@ page import="com.codemate.DTO.MemberDTO" %>
<%@ page import="com.codemate.DTO.CommentDTO" %>
<%@ page import="java.util.List" %>
<%
	PostDTO post = (PostDTO) request.getAttribute("post");
	List<CommentDTO> comments = (List<CommentDTO>) request.getAttribute("comments");
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
	
	<table border="1">
		<tr>
			<th>댓글번호</th>
			<th>댓글내용</th>
		</tr>
		<%if(comments != null) {%>
			<%for(CommentDTO c : comments) {%>
				<tr>
					<td><%=c.getId()%></td>
					<td><%=c.getContent() %></td>
				</tr>
			<%} %>
		<%}else { %>
			<tr>
				<td colspan="5">댓글이 없습니다.</td>
			</tr>	
		<%} %>
	</table>
	<%if(loginUser != null && loginUser.getId() == post.getMember_id()) {%>
		<a href="${pageContext.request.contextPath}/post/update?id=<%=post.getId() %>">
		수정하기
		</a>
		<a href="${pageContext.request.contextPath}/post/delete?id=<%=post.getId() %>">
		삭제하기
		</a>
		
		
	<%} %>
	
	<form action="${pageContext.request.contextPath}/comment/write" method="post">
			<input type="hidden" name="post_id" value="<%=post.getId()%>">
			
			<input type="text" name="content">
			<br><br>
			
			<button type="submit">댓글 등록</button>
		
		</form>
</body>
</html>