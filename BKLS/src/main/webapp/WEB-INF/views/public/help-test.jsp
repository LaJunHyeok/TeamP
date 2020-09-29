<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAFE SEOUL</title>
</head>
<!-- 건의/ 민원 게시판입니다. -->
<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>

<body>
	<div class="container">
		<div class="row justify-content-center">
			<p align="center">
			<table class="table table-dark" cellpadding="0" cellspacing="0"
				border="1">
				<thead>
					<tr>
						<h2>건의사항 게시판 입니다</h2>
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
					<c:forEach items="${help}" var="dto">

						<tr>
							<td>${dto.help_num}</td>
							<td>${dto.help_id}</td>
							<td><a href="helpview?num1=${dto.help_num}"> <!-- 현재 날짜 받아오기 -->
									<jsp:useBean id="now" class="java.util.Date" /> <!-- 날짜 형식 맞추기 -->
									<fmt:formatDate value="${now}" pattern="ddkk" var="todayDate" />
									<fmt:formatDate value="${dto.help_date}" pattern="ddkk"
										var="dtoDate" /> <!-- 날짜 형식 맞춘거 숫자형으로 변환 --> <fmt:parseNumber
										value="${todayDate}" type="number" var="today" /> <fmt:parseNumber
										value="${dtoDate}" type="number" var="uploadDate" /> <!-- 업로드 된 날짜 형식 바꿔서 테이블에 적용해주기 -->
									<fmt:formatDate value="${dto.help_date}"
										pattern="yy-MM-dd kk:mm" var="uploadDate2" /> <c:if
										test="${ 100 > today-uploadDate }">
										<span id="date" class="badge badge-secondary">New</span>
									</c:if> ${dto.help_title}
							</a></td>
							<td>${dto.help_date}</td>
							<td>${dto.help_hit}</td>
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
	</div>

</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>