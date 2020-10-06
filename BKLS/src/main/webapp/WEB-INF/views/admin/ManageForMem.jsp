<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="#" method="post">
	<table class="table table-bordered" >
	
	<tr>
			<td>아이디</td>
			<td>#</td>
	</tr>
	<tr>
			<td>이름</td>
			<td>#</td>
	</tr>
	<tr>
			<td>이메일</td>
			<td>#</td>
	</tr>
	<tr>
			<td>가입날짜</td>
			<td>#</td>
	</tr>
	<tr>
			<td>주소</td>
			<td>#</td>
	</tr>
			
           
	</table>
	
	</form>
	</div>

</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>