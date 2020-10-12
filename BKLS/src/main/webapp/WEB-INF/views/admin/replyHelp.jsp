<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<font size="6" color="#5bc0de">관리자 댓글 작성</font> <br>	

	<c:forEach items="${help}" var="dto">
	<div class="container">
	<div class="row justify-content-center">
	<table class="table table-bordered" >	
	
	<tr>
			<td>글번호</td>
			<td>${dto.help_num}</td>
	</tr>
	<tr>
			<td>아이디</td>
			<td>${dto.help_id}</td>
	</tr>
	<tr>
			<td>제  목</td>
			<td>${dto.help_title}</td>
	</tr>
	<tr>
			<fmt:formatDate value="${dto.help_date}" pattern="yyyy-MM-dd" var="date" />
			<td>작성일</td>
			<td>${date}</td>
	</tr>
	<tr>
			<td>조회수</td>
			<td>${dto.help_hit}</td>
	</tr>
	<tr>
			<td>내용</td>
			<td>${dto.help_content}</td>
	</tr>
	</table>
	</div>	
	</div>
	
	
	<!-- 관리자의 답글 메서드 -->
	<div class="container">
	<div class="row justify-content-center">
	<form action="/write2" method="get">
		<div class="mb-3">
		<input type="hidden" name="num" value="${dto.help_num}"/>
		<input type="hidden" name="user" value="${dto.help_id}"/>
			<label for="작성자">작성자</label> 
			<input type="text"
			 name="id" value="<sec:authentication property="principal.username" />" readonly />   
		</div>
		<div class="mb-3">
			<label for="제목">제목</label> <input type="text" class="form-control"
				name="title2" placeholder="" value="" required>
		</div>
		
		<div class="mb-3">
			<label for="내용">내용</label>
			<textarea class="form-control" id="editor1" name="content2" rows="10"
				placeholder="" value="" required></textarea>
			<script>
				CKEDITOR.replace('editor1');
			</script>
		</div>	
		
		<div class="container">
			<div class="row justify-content-end">
						<button type="submit" class="btn btn-info">작성 완료</button>
			</div>
		</div>
	</form>
	</div>	
	</div>
	</c:forEach>
	    <jsp:include page="../footer.jsp" flush="false" />	
</body>

</html>