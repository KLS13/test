<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<script src="resources/jQuery/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>글 쓰기</h1>
	<hr>
	<form id="frm" name="frm" action="insertBoard.do" method="post">
		<table border="1">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left">
					<input type="text" id="title" name="title" />
				</td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left">
					<input type="text" id="writer" name="writer" size="10" />
				</td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left">
					<textarea id="content" name="content" cols="40" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" name="write" id="write" >쓰기</button>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.do">글 목록 가기</a>
</body>
<script type="text/javascript">
	$(document).ready(function (e){
		$('#write').click(function(){
				var frmArr = ["title","writer","content"];

				//입력 값 널 체크
				for(var i=0;i<frmArr.length;i++){
					//alert(arr[i]);
					if($.trim($('#'+frmArr[i]).val()) == ''){
						alert('빈 칸을 모두 입력해 주세요.');
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