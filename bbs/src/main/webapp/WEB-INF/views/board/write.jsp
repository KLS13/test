<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board/writeCommit" method="post">

<table>
	<caption>글쓰기</caption>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" id="title"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="writer" id="writer"></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><input type="text" name="image" id="image"></td>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="25" name="content" id="content"></textarea></td>
	</tr>
	<tr>
		<th colspan="2"><input type="submit" value="작성완료">
		</th>
	</tr>
</table>
</form>
</body>
</html>