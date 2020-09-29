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
            <td>${dto.user_id}</td>
            <td>${dto.user_name}</td>
            <td>${dto.user_email}</td>
            <td>${dto.user_address}</td>
            <td>${dto.user_date}</td>
            <td>${dto.isEnabled}</td>
            <td>
                <a href="userBan?user_id=${dto.user_id}">정지</a>
                <a href="userRestore?user_id=${dto.user_id}">해제</a>
            </td>
        </tr>    
        </c:forEach>
    </table>
   	</div>

</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>