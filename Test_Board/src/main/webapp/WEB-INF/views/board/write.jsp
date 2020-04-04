<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>	
	 	<title>게시판</title>
		<script type="text/javascript">
		function ajax_write() {

			$.ajax({
				type : 'POST',
				url : "/board/write",
				data : $("#writeForm").serialize(),
				success : function(data) {
					if(data == "YES") {							
						alert("게시글 저장 완료");						
						location.href ='/board/list';
					}	
				},
				error : function(request, status, error) {
					
				}
			});
		}z
		</script>
	</head>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form id="writeForm" method="post">
				
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content" ></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="writer" />
								</td>
							<tr>
								<td>						
									<button type="button" onclick="ajax_write()">작성</button>
									<button type="button"
									onclick="location.href='/board/list'">목록</button>
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>