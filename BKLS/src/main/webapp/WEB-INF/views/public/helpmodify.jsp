<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>SAFE SEOUL</title>
</head>

<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<header>
	<!-- 메뉴 바 -->
	<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>

	<!-- 공지사항 수정 페이지입니다.  -->
	<!-- ADMIN 만 작성 가능 -->
	<br><br>
	
	<div class="container">
		<div class="row justify-content-center">
			<form class="container" action="helpupdate" method="get">
			
			<c:forEach items="${help}" var="dto">
			
			<input type="hidden" name="num1" value="${dto.help_num}"> 
			
					<div class="form-group row">
						<label for="num" class="col-sm-2 col-form-label">번호</label>
						<div class="col-sm-10">${dto.help_num}</div>
					</div>
					
					 
					<div class="form group row">
						<label for="hit" class="col-sm-2 col-form-label">조회수</label>
						<div class="col-sm-10">${dto.help_hit}</div>
					
					</div>
					<div class="form group row">
						<label for="id" class="col-sm-2 col-form-label">아이디</label>
						<div class="col-sm-10">${dto.help_id}</div>
					</div>
					<div class="form group row">
						<label for="title" class="col-sm-2 col-form-label">제목</label>
						<div class="col-sm-10">
							<input type="text" name="title1" class="form-control" id="title"
								value="${dto.help_title}">
						</div>
					</div>
					<div class="form-group row">
						<label for="content" class="col-sm-2 col-form-label">내용</label>
						<div class="col-sm-10">
							<textarea id="editor1" rows="10" name="content1"
								class="form-control">${dto.help_content}</textarea>
							<script>
								CKEDITOR.replace('editor1');
							</script>
						</div>
					</div>
					
				<div class="container">
					<div class="row justify-content-end">
						<button type="submit" class="btn btn-info">수정</button>&nbsp;&nbsp;
						<a href="#" onclick="history.go(-1)" class="btn btn-info">목록보기</a>
					</div>
				</div>	
			</c:forEach>
			</form>
		</div>
	</div>

</body>

<footer>
	<!-- footer -->
	<jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>