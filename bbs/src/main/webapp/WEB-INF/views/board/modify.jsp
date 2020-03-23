<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board/modifyCommit" method="get">
<input type="hidden" name="bno" value="${view.bno }">
<table>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="writer" id="writer"
		value="${view.writer }"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" id="title"
		value="${view.title }"></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><input type="text" name="image" id="image" value="${view.image }">
	<tr>	
		<th>내용</th>
		<td><textarea rows="5" cols="20" name="content">${view.title }</textarea></td>
	</tr>
	<tr>
		<th colspan="2">
		<input type="submit"  value="수정완료">
		</th>
	</tr>
</table>
</form>
</body>
</html>