<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>SAFE SEOUL</title>
</head>
<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>

<!-- 공지사항 수정 페이지입니다.  -->
<!-- ADMIN 만 작성 가능 -->
<div class="container">
		<div class="row justify-content-center">
			<p align="center">
			<table class="table table-dark" cellpadding="0" cellspacing="0"
				border="1">

		<form action="noticeupdate" method="post">
			<!--<c:forEach items="${notice}" var="dto">-->
				<input type="hidden" name="num"value="${dto.notice_num}"> 
				<tr>
					<td>글번호</td>
					<td>${dto.notice_num}</td>
				</tr>
								<tr>
					<td>작성자</td>
					<td>${dto.notice_id}</td>
				</tr>

				<tr>
					<td>제목</td>
					<td><input type="text"id="title" name="title" size="100"
						value="${dto.notice_title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" id="content"name="content" size="100"
						value="${dto.notice_content}"></td>						
						
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력">
						<a href="notice">목록보기</a></td>
				</tr>
			<!--</c:forEach>-->
		</form>
		</p>
		</table>

	</div>
	</div>

</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html> 