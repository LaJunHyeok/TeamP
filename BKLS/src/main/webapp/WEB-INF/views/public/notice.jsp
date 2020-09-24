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
							 <td><a href="noticeview?num=${dto.notice_num}">${dto.notice_title}</a></td>
							 <td>${dto.notice_date}</td>
							<td>${dto.notice_hit}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			</p>
		</div>
	</div>
	<!--  <a id ="openkub" onchange="showButton();"></a>-->
	<!-- DB만든후 BdsDao.xml 수정 -->
	<p align="center">
		<!-- <input type="button" id="btnclickme" value="글작성" href="writeForm">-->
		<a href="admin/writeForm" role="button">글작성</a>
	</p>
</body>
</html> 