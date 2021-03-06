<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 상세</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"   
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   
	crossorigin="anonymous">
</script>
</head>
<body>
	<h1>글 상세</h1>
	<hr>
	<form id="frm" action="updateBoard.do" method="post">
		<input name="seq" type="hidden" value="${board.idx}" />
		<table border="1">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input id="title" name="title" type="text"
					value="${board.title }" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left">${board.writer }</td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea id="content" name="content" cols="40" rows="10">${board.content }</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><fmt:formatDate value="${board.reg_date }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left">${board.cnt }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" id="modify" value="글 수정" /></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="writeBoard.do">글 쓰기</a>&nbsp;&nbsp;&nbsp; 
	<a href="deleteBoard.do?idx=${board.idx }">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>
</body>
<script type="text/javascript">
	$(document).ready(function (e){
		$('#modify').click(function(){
			var frmArr = ["title","content"];

			//입력 값 널 체크
			for(var i=0;i<frmArr.length;i++){
				//alert(arr[i]);
				if($.trim($('#'+frmArr[i]).val()) == ''){
					alert('빈 칸을 모두 입력해 주세요. -'+frmArr[i]);
					$('#'+frmArr[i]).focus();
					return false;
				}
			}

			//전송
			$('#frm').submit();
		});
	});
</script>
</html>