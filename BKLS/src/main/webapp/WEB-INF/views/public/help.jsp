<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>건의사항 게시판</title>

</head>
<header>
	<!-- 메뉴 바 -->
	<jsp:include page="../menubar.jsp" flush="false" />
</header>

<body>
<!-- 현재 날짜 받아오기 -->
<jsp:useBean id="now" class="java.util.Date" /> <!-- 날짜 형식 맞추기 -->
<fmt:formatDate value="${now}" pattern="MMdd" var="todayDate" />
<fmt:formatDate value="${dto.help_date}" pattern="MMdd"
var="dtoDate" /> <!-- 날짜 형식 맞춘거 숫자형으로 변환 --> <fmt:parseNumber
value="${todayDate}" type="number" var="today" /> <fmt:parseNumber
value="${dtoDate}" type="number" var="uploadDate" /> <!-- 업로드 된 날짜 형식 바꿔서 테이블에 적용해주기 -->
<fmt:formatDate value="${dto.help_date}" pattern="yyyy-MM-dd" var="uploadDate2" />
	
	<br>
	<p style="text-align: center">
		<font size="6" color="#5bc0de">건의사항 게시판</font> <br>
	<div class="container">
		<div class="row justify-content-center">
			<table class="table table-bordered table-hover" width="500"
				cellpadding="0" cellspacing="0" border="1">

				<tr>
					<td>글번호</td>
					<td>아이디</td>
					<td>제 목</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
				<sec:authorize access="isAuthenticated()">
					<sec:authentication property="principal.username" var="currentUserName"/>
						</sec:authorize>
				
				<c:forEach items="${help}" var="dto">
			
					<c:choose>
					<c:when test="${currentUserName == 'admin' }">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td> <c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							<a href="helpview?num1=${dto.help_num}">${dto.help_title}</a>
							</td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName == dto.help_id }">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td><c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							<a href="helpview?num1=${dto.help_num}">${dto.help_title}</a></td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName == null && dto.help_open=='0'}">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td> <c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							비공개 글입니다.
							</td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName != null && dto.help_reply == null && dto.help_open == '0' }">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td> <c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							비공개글입니다.
							</td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName != null && dto.help_reply == null && dto.help_open == '1' }">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td> <c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							<a href="helpview?num1=${dto.help_num}">${dto.help_title}</a>
							</td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName != null && dto.help_reply == currentUserName }">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td> <c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							<a href="helpview?num1=${dto.help_num}">${dto.help_title}(비공개글)</a>
							</td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName != dto.help_id && dto.help_open == '0'}">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td><c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							비공개 글입니다.
							</td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					<c:when test="${currentUserName != dto.help_id && dto.help_open == '1' }">
						<tr background="gray">
							<td>${dto.help_group}</td>
							<td>${dto.help_id }</td>
							<td><c:if test="${ 1 > today-uploadDate }">
							<span id="date" class="badge badge-secondary">New</span></c:if>
							<a href="helpview?num1=${dto.help_num}">${dto.help_title}</a></td>
							<td>${uploadDate2}</td>
							<td>${dto.help_hit}</td>
						</tr>
					</c:when>
					</c:choose>
				</c:forEach>
		
			</table>
		</div>
	</div>

	<div class="container">
		<div class="row justify-content-end">
			<a class="btn btn-info" href="../private/writeHelp">글작성</a>
		</div>
	</div>
	
	<div class="container">
	<div class="row justify-content-center">	
		<form class="form-inline my-2 my-md-0" action="/public/help_search" method="get">
			<input class="form-control mr-sm-2" id="title1" name="title1" type="text" placeholder="제목으로 검색">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
		</form>
	</div>	
	</div>

	<nav aria-label="..." class="row justify-content-md-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${(page.curPage -1) <1}">
					<li class="page-item disabled"><span class="page-link">&lt;&lt;</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="help?page=1">&lt;&lt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${(page.curPage -1) <1}">
					<li class="page-item disabled"><span class="page-link">&lt;</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="help?page=${page.curPage - 1}">&lt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="fEach" begin="${page.startPage}"
				end="${page.endPage}" step="1">
				<c:choose>
					<c:when test="${page.curPage == fEach}">
						<li class="page-item"><a class="page-link" href="#">${fEach}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="help?page=${fEach}">${fEach}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${page.curPage >= page.totalPage}">
					<li class="page-item disabled"><span class="page-link">&gt;</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="help?page=${page.curPage + 1}">&gt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.curPage == page.totalPage}">
					<li class="page-item"><a class="page-link">&gt;&gt;</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="help?page=${page.totalPage}">&gt;&gt;</a></li>
				</c:otherwise>
			</c:choose>

		</ul>

	</nav>

</body>


<jsp:include page="../footer.jsp" flush="false" />

</html>