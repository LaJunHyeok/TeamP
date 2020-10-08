<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건의사항 게시판 글쓰기 작성폼</title>
</head>

<!-- 에디터 -->
<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>

<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>
	
	<br>
	<p style="text-align: center">
	<font size="6" color="#5bc0de">건의사항 작성</font> <br>	

	<div class="container">
	<div class="row justify-content-center">
	<form action="/write1" method="get">
		<div class="mb-3">
			<label for="작성자">작성자</label> 
			<input type="text"
			 name="id" value="<sec:authentication property="principal.username" />" readonly />   
		</div>
		<div class="mb-3">
			<label for="제목">제목</label> <input type="text" class="form-control"
				name="title1" placeholder="" value="" required>
		</div>

		<div class="mb-3">
			<label for="내용">내용</label>
			<textarea class="form-control" id="editor1" name="content1" rows="10"
				placeholder="" value="" required></textarea>
			<script>
				CKEDITOR.replace('editor1');
			</script>
		</div>	
		
		<div class="container">
			<div class="row justify-content-end">
						<label for="open" class="btn btn-info"> <input id="open"
							type="radio" name="help_open" value="1" checked />공개
						</label>&nbsp;&nbsp; <label for="close"
							class="btn btn-info"> <input id="close" type="radio"
							name="help_open" value="0" />비공개
						</label>&nbsp;&nbsp;
						<button type="submit" class="btn btn-info">작성 완료</button>
			</div>
		</div>
	</form>
	</div>	
	</div>	
</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>