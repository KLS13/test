<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
</head>
<body>
<table border ="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
	</tr>

<c:if test="${!empty list}">
<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.bno }</td>
		<td><a href="#" onclick="location.href='/board/view?bno=${list.bno}'">${list.title }</a></td>
		<td>${list.writer }</td>
	</tr>
</c:forEach>
</c:if>
<tr>
	<td colspan="3">
		<button type="button" onclick="location.href='/board/write'">글쓰기</button>
	</td>
</table>

<div>
  <ul>
    <c:if test="${pageMaker.prev}">
    	<li><a href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
    </c:if> 

    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    	<li><a href="list${pageMaker.makeQuery(idx)}">${idx}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    	<li><a href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
  </ul>
</div>


</body>
</html>