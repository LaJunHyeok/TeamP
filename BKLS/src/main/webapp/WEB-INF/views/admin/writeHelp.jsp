<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<form action="write" method="post">
		
		<div class="mb-3">
			<label for="제목">제목</label> <input type="text" class="form-control"
				name="help_title" placeholder="" value="" required>
		</div>

		<div class="mb-3">
			<label for="내용">내용</label>
			<textarea class="form-control" id="editor1" name="help_content" rows="10"
				placeholder="" value="" required></textarea>
			<script>
				CKEDITOR.replace('editor1');
			</script>
		</div>
	</form>

	<hr class="mb-4">
	<button class="btn btn-info btn-lg btn-block" id="write" type="submit"
		value="글작성">작성 완료</button>
</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>