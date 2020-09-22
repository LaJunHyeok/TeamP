<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 메뉴 바 -->
<jsp:include page="menubar.jsp" flush="false" />
<!--  -->

<body>

<p style="text-align:center">
	<font size="8" color="#5bc0de">회원 조회</font>

<br><br>
	<div class="container">
	<form action="content_view.do" method="post">
	<table class="table table-bordered" >
	
	<tr>
			<td>아이디</td>
			<td>${content_view.bId}</td>
	</tr>
	<tr>
			<td>이름</td>
			<td>${content_view.bHit}</td>
	</tr>
	<tr>
			<td>이메일</td>
			<td>${content_view.bName}</td>
	</tr>
	<tr>
			<td>가입날짜</td>
			<td>${content_view.bTitle}</td>
	</tr>
	<tr>
			<td>주소</td>
			<td>${content_view.bContent}</td>
	</tr>
			
           
	</table>
	
	</form>
	</div>

</body>
</html>