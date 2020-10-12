<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>건의사항 게시판</title>

</head>
<header>
   <!-- 메뉴 바 -->
   <jsp:include page="../menubar.jsp" flush="false" />
</header>

<body style="overflow: scroll;">

   <br>
   <p style="text-align: center">
      <font size="6" color="#5bc0de">공지사항 게시판</font> <br>
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

            <c:forEach items="${notice}" var="dto">
               <tr>
                  <td>${dto.notice_num}</td>
                  <td>${dto.notice_id}</td>
                  <td><a href="noticeview?num=${dto.notice_num}">
                     <!-- 현재 날짜 받아오기 -->
                     <jsp:useBean id="now" class="java.util.Date" />
                     <!-- 날짜 형식 맞추기 -->
                     <fmt:formatDate value="${now}" pattern="MMdd" var="todayDate" />
                     <fmt:formatDate value="${dto.notice_date}" pattern="MMdd"   var="dtoDate" />
                     <!-- 날짜 형식 맞춘거 숫자형으로 변환 -->
                     <fmt:parseNumber value="${todayDate}" type="number" var="today" />
                     <fmt:parseNumber value="${dtoDate}" type="number" var="uploadDate" />
                     <!-- 업로드 된 날짜 형식 바꿔서 테이블에 적용해주기 -->
                     <fmt:formatDate value="${dto.notice_date}" pattern="yyyy-MM-dd" var="uploadDate2" />
                     <c:if test="${ 1 > today-uploadDate }">
                        <span id="date" class="badge badge-secondary">New</span>
                     </c:if> ${dto.notice_title}
                  </a></td>
                  <td>${dto.notice_date}</td>
                  <td>${dto.notice_hit}</td>
               </tr>
            </c:forEach>
         </table>
      </div>
   </div>
<sec:authorize access="hasRole('ADMIN')">
     <div class="container">
      <div class="row justify-content-end">
         <a class="btn btn-info" href="admin/writeForm">글작성</a>
      </div>
   </div>
    </sec:authorize>
  
   
   <div class="container">
   <div class="row justify-content-center">   
      <form class="form-inline my-2 my-md-0" action="noticesearch" method="get">
         <input class="form-control mr-sm-2" name="title" type="text" placeholder="제목으로 검색">
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
							<li class="page-item"><a class="page-link"
								href="noticesearch?page=1&title=${title}">&lt;&lt;</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${(page.curPage -1) <1}">
							<li class="page-item disabled"><span class="page-link">&lt;</span></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="noticesearch?page=${page.curPage - 1}&title=${title}">&lt;</a></li>
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
									href="noticesearch?page=${fEach}&title=${title}">${fEach}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${page.curPage >= page.totalPage}">
							<li class="page-item disabled"><span class="page-link">&gt;</span></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="noticesearch?page=${page.curPage + 1}&title=${title}">&gt;</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${page.curPage == page.totalPage}">
							<li class="page-item"><a class="page-link">&gt;&gt;</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="noticesearch?page=${page.totalPage}&title=${title}">&gt;&gt;</a></li>
						</c:otherwise>
					</c:choose>

				</ul>

			</nav>

</body>

 
<jsp:include page="../footer.jsp" flush="false" />

</html>