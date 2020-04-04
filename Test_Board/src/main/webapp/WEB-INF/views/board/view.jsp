<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/updatePage");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 취소
			$(".list_btn").on("click", function(){
				
				location.href = "/board/list";
			})
		})
		
		
	</script>
</head>
<body>
<form name="readForm" role="form" method="post">
<input type="hidden" id="bno" name="bno" value="${view.bno}" />
<table>
	<tr>
		<th>제목</th>
		<td><input type="text" id="title" name="title" value="${view.title}" readonly="readonly"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" id="writer" name="writer" value="${view.writer }" readonly="readonly"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea id="content" name="content" readonly="readonly"><c:out value="${view.content}" /></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
		<button type="button" onclick="location.href='/board/list'">목록</button>
		<button type="submit" class="update_btn">수정</button>
		<button type="submit" class="delete_btn">삭제</button>
		<button type="submit" class="list_btn">목록</button>
		</th>
</table>
</form>
</body>
</html>