<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>SAFE SEOUL</title>
</head>
<!-- 공지사항 게시판입니다. -->
<!-- 메뉴바 -->
<jsp:include page="../menubar.jsp" flush="false" />
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
	<div class="container">
		<div class="row justify-content-center">
			<p align="center">
			<table class="table table-dark" cellpadding="0" cellspacing="0"
				border="1">
				<thead>
					<tr>
						<h2>공지사항 게시판 입니다</h2>
					<tr>
						<th>글번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${notice}" var="dto">

						<tr>
							<td>${dto.notice_num}</td>
							<td>${dto.notice_id}</td>
							<td><a href="noticeview?num=${dto.notice_num}"> <!-- 현재 날짜 받아오기 -->
									<jsp:useBean id="now" class="java.util.Date" /> <!-- 날짜 형식 맞추기 -->
									<fmt:formatDate value="${now}" pattern="ddkk" var="todayDate" />
									<fmt:formatDate value="${dto.notice_date}" pattern="ddkk"
										var="dtoDate" /> <!-- 날짜 형식 맞춘거 숫자형으로 변환 --> <fmt:parseNumber
										value="${todayDate}" type="number" var="today" /> <fmt:parseNumber
										value="${dtoDate}" type="number" var="uploadDate" /> <!-- 업로드 된 날짜 형식 바꿔서 테이블에 적용해주기 -->
									<fmt:formatDate value="${dto.notice_date}"
										pattern="yy-MM-dd kk:mm" var="uploadDate2" /> <c:if
										test="${ 100 > today-uploadDate }">
										<span id="date" class="badge badge-secondary">New</span>
									</c:if> ${dto.notice_title}
							</a></td>
							<td>${dto.notice_date}</td>
							<td>${dto.notice_hit}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			</p>
			<p align="center">
				<!-- <input type="button" id="btnclickme" value="글작성" href="writeForm">-->
				<button>
					<a href="admin/writeForm" role="button">글작성</a>
				</button>
				<br />
				<br />
			<form class="form-inline my-2 my-lg-0" action="noticesearch"method="post">
				<input class="form-control mr-sm-2" type="text" name="title"
					placeholder="Search"> 
					<input	class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
			</form>
			</p>
			
		</div>
		<tr>
				<nav aria-label="..." class="row justify-content-md-center">
						<ul class="pagination">
						
							<c:choose>
								<c:when test="${(page.curPage -1) <1}">
									<li class="page-item disabled"><span class="page-link">&lt;&lt;</span></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="notice?page=1">&lt;&lt;</a></li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${(page.curPage -1) <1}">
									<li class="page-item disabled"><span class="page-link">&lt;</span></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="notice?page=${page.curPage - 1}">&lt;</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach var="fEach" begin="${page.startPage}" end="${page.endPage}" step="1">
								<c:choose>
									<c:when test="${page.curPage == fEach}">
										<li class="page-item"><a class="page-link" href="#">${fEach}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="notice?page=${fEach}">${fEach}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${page.curPage >= page.totalPage}">
									<li class="page-item disabled"><span class="page-link">&gt;</span></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="notice?page=${page.curPage + 1}">&gt;</a></li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${page.curPage == page.totalPage}">
									<li class="page-item"><a class="page-link">&gt;&gt;</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="notice?page=${page.totalPage}">&gt;&gt;</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
						
					</nav>
					
					
			</tr>
	</div>
	<!--  <a id ="openkub" onchange="showButton();"></a>-->
	<!-- DB만든후 BdsDao.xml 수정 -->

</body>
</html>
