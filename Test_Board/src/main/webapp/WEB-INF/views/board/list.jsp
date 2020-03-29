<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<caption>게시판</caption>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	
	<c:if test="${empty list }">
		<tr>
			<th colspan="4">등록된 게시글이 없습니다.</th>
		</tr>
	</c:if>
	
	<c:if test="${!empty list  }">
	<c:forEach var="list" items="${list}">
		<tr onclick="location.href='/board/view?bno=${list.bno }'">
			<td style="text-align: center">${list.bno }</td>
			<td>${list.title }</td>
			<td style="text-align: center">${list.writer }</td>
			<td style="text-align: center">
			<fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
	</c:forEach>
	</c:if>
		<tr>
			<th colspan="4">
			<input type="button" value="글쓰러 가기" onclick="location.href='/board/writePage'">
			</th>
		</tr>
</table>
</body>
</html>