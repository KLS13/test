<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 목록</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"   
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   
	crossorigin="anonymous">
	</script>
</head>
<body>
	<a href="/">메인</a>
	<table border="1" >
		<tr>
			<th bgcolor="" width="50">no</th>
			<th bgcolor="" width="200">제목</th>
			<th bgcolor="" width="150">작성자</th>
			<th bgcolor="" width="150">작성일</th>
			<th bgcolor="" width="100">조회수</th>
		</tr>
		<c:choose>
			<c:when test="${!empty boardList}">
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.idx }</td>
						<td align="left"><a href="${board.idx }">
								${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.reg_date }" pattern="yyyy-MM-dd"/></td>
						<td>${board.cnt }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">등록된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<a href="writeBoard.do">글 쓰기</a>
	<form id="dateForm" name="dateForm">
	
	<input type="text" id="reg_date" name="reg_date">
	</form>
	<input type="button" onclick="reg_date()" value="날짜별 게시글 삭제">
	
	<div id="pagingDiv">
			<c:if test="${paging.prev}">
				<a href="${paging.startPage - 1 }">이전</a>
			</c:if>
			<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage }">
				&nbsp;<a href="${num }">${num }</a>&nbsp;
			</c:forEach>
			<c:if test="${paging.next}">
				<a id="next" href="${paging.endPage + 1 }">다음</a>
			</c:if>
	</div>
	
	<form id="pagingFrm" name="pagingForm" action="getBoardList.do" method="get">
		<input type="hidden" id="pageNum" name="pageNum" value="${paging.cri.pageNum }">
		<input type="hidden" id="amount" name="amount" value="${paging.cri.amount }">
	</form>
	
	<!-- 검색 form -->
	<div id="search">
		<form id="searchForm" action="getBoardList.do" method="get">
			<select name="type">
				<option value="">선택</option>
				<option value="T">제목</option>
				<option value="C">내용</option>
				<option value="W">작성자</option>
				<option value="TC">제목 + 내용</option>
				<option value="TW">제목 + 작성자</option>
				<option value="TCW">제목 + 내용 + 작성자</option>
			</select>
			<input type="text" name="keyword" />
			<button id="searchBtn">검색</button>
		</form>
	</div>
</body>

<script type="text/javascript">

$(document).ready(function(){

		//페이지 번호 이동
		$('#pagingDiv a').click(function(e){
			e.preventDefault();
			$('#pageNum').val($(this).attr("href"));
			pagingForm.submit();
			
		});
		
		//게시글에 pageNum넘기기
		$('table a').click(function(e){
			e.preventDefault();
			var html = "<input type='hidden' name='idx' value='"+$(this).attr("href")+"'>";
			$('#pagingFrm').append(html);
			$('#pagingFrm').attr("action","getContent.do");
			$('#pagingFrm').submit();
		});
	});
	
function reg_date() {	
	$.ajax({
		type : 'POST',
		url : "getDateRemove.do",
		data : $("#dateForm").serialize(),
		success : function(data) {
			if (data == "YES") {					
				alert("삭제되었습니다.");
			}else{
				alert("삭제할거없어");
			}
		},
		error : function(request, status, error) {
			
		}
	});	
}
</script>


</html>