<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>작성자</th>
		<td>${view.writer }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${view.title }</td>
	</tr>
	<tr>	
		<th>내용</th>
		<td>${view.title }</td>
	</tr>
	<tr>
		<th colspan="2">
		<input type="button"  value="삭제"
		onclick="location.href='/board/remove?bno=${view.bno}'">
		</th>
	</tr>
</table>
</body>
</html>