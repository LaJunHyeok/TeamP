<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>

<p style="text-align:center">
   <font size="8" color="#5bc0de">회원 조회</font>

<br><br>
   <div class="container">
   <table class="table table-bordered" >
        <tr>
            <td>아이디</td>
            <td>회원이름</td>
            <td>이메일</td>
            <td>주소</td>
            <td>가입일</td>
            <td>회원상태</td>
            <td>회원처리</td>
        </tr>
        <c:forEach items="${userList}" var="dto">
            <tr>
            <td><a href="user_search?id=${dto.id}">${dto.id}</a></td>
            <td>${dto.name}</td>
            <td>${dto.email}</td>
            <td>${dto.address}</td>
            <td>${dto.date}</td>
            <td>
                <c:if test="${dto.isEnabled == 1}">정상회원</c:if>
                <c:if test="${dto.isEnabled == 0}">정지회원</c:if>
            </td>
            <td>
                <a href="userBan?id=${dto.id}" class="btn btn-light">정지</a>
                <a href="userRestore?id=${dto.id}" class="btn btn-light">해제</a>
            </td>
        </tr>    
        </c:forEach>
    </table>
    </div>
      
    <nav aria-label="..." class="row justify-content-md-center">
        <ul class="pagination">
            <c:choose>
                <c:when test="${(page.curPage -1) <1}">
                    <li class="page-item disabled"><span class="page-link">&lt;&lt;</span></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="userList?page=1">&lt;&lt;</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${(page.curPage -1) <1}">
                    <li class="page-item disabled"><span class="page-link">&lt;</span></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                        href="userList?page=${page.curPage - 1}">&lt;</a></li>
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
                            href="userList?page=${fEach}">${fEach}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${page.curPage >= page.totalPage}">
                    <li class="page-item disabled"><span class="page-link">&gt;</span></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                        href="userList?page=${page.curPage + 1}">&gt;</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${page.curPage == page.totalPage}">
                    <li class="page-item"><a class="page-link">&gt;&gt;</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                        href="userList?page=${page.totalPage}">&gt;&gt;</a></li>
                </c:otherwise>
            </c:choose>

        </ul>

    </nav>

</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>