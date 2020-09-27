<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>SAFE SEOUL</title>
</head>
<!-- 공지사항 게시판입니다. -->
<!-- 메뉴바 -->
<jsp:include page="menubar.jsp" flush="false" />
<!--<script type="text/javascript">
function showButton(){
   var tmpkub = $("#openkub").val();
   if(tmpkub == '1'){
      $("#btnclickme").show();
   }else if(tmpkub == '2'){
      $("#btnclickme").hide()
   }
}

</script>
-->
<body>
   	<p style="text-align: center">
		<font size="6" color="#5bc0de">자유 게시판</font> <br>
		
		<div class="container">
			<div class="row justify-content-center">
				<table class="table table-bordered table-hover width="
		500" cellpadding="0" cellspacing="0" border="1">

				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>제목</td>
					<td>날짜</td>
					<td>조회수</td>
				</tr>
				<c:forEach items="${notice}" var="dto">
					<tr>
						<td>${dto.notice_num}</td>
						<td>${dto.notice_id}</td>
						<td>${dto.notice_title}</td>
						<td>${dto.notice_date}</td>
						<td>${dto.notice_hit}</td>
					</tr>
				</c:forEach>
				<tr>
			</div>
		</div>
	


		<td colspan="5"><a type="button" class="btn btn-info"
			href="write_view.do">글작성</a></td>
		</tr>
		<tr>
			<nav aria-label="Page navigation example" style="text-align: center;">
			</nav>
		</tr>

		<td colspan="5">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<!-- 처음 -->
					<c:choose>
						<c:when test="${(page.curPage -1) < 1 }">
							<li class="page-item"><a class="page-link"
								href="list.do?page=1">처음</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="list.do?page=1">처음</a></li>
						</c:otherwise>
					</c:choose>

					<!-- 이전 -->
					<c:choose>
						<c:when test="${(page.curPage -1) < 1 }">
							<li class="page-item"><a class="page-link"
								href="list.do?page=${page.curPage - 1}">이전</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="list.do?page=${page.curPage - 1}">이전</a></li>
						</c:otherwise>
					</c:choose>

					<!-- 개별 페이지 -->
					<c:forEach var="fEach" begin="${page.startPage}"
						end="${page.endPage}" step="1">
						<c:choose>
							<c:when test="${page.curPage == fEach}">
								<li class="page-item"><a class="page-link"
									href="list.do?page=${fEach}">${fEach}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="list.do?page=${fEach}">${fEach}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<!-- 다음 -->
					<c:choose>
						<c:when test="${(page.curPage + 1) > page.totalPage}">
							<li class="page-item"><a class="page-link"
								href="list.do?page=${page.curPage + 1}">다음</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="list.do?page=${page.curPage + 1}">다음</a></li>
						</c:otherwise>
					</c:choose>

					<!-- 끝 -->
					<c:choose>
						<c:when test="${page.curPage == page.totalPage}">
							<li class="page-item"><a class="page-link"
								href="list.do?page=${page.totalPage}">끝</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="list.do?page=${page.totalPage}">끝</a></li>&nbsp;&nbsp;
                     </c:otherwise>
					</c:choose>

					<!--  
					<form class="form-inline my-2 my-md-0">
						<input class="form-control mr-sm-2" type="search" placeholder="입력"
							aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
					</form>
					-->

					<br>
					<form action="list.do" method="post">
						<select name="opt" class="btn btn-info btn-md">
							<option value="bName">이름</option>
							<option value="bTitle">제목</option>
							<option value="bContent">내용</option>
						</select> <input class="btn btn-info btn-md" id="search" type="text"
							name="search"> <input class="btn btn-info btn-md"
							type="submit" value="검색">
					</form>
		</td>
		</tr>
		<tr>
			</div>
	</table>
</body>
<!— Optional JavaScript —>
	<!— jQuery first, then Popper.js, then Bootstrap JS —>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</html>