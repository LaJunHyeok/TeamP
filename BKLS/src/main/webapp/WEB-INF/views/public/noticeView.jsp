<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>SAFE SEOUL</title>
</head>

<!-- 에디터 -->
<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<header>
   <!-- 메뉴 바 -->
   <jsp:include page="../menubar.jsp" flush="false" />
</header>

<body>

   <p style="text-align:center">
   <font size="10" color="#5bc0de">글 내용</font>
   
   <c:forEach items="${notice}" var="dto">
   <div class="container">
   <div class="row justify-content-center">
   <table class="table table-bordered" >   
   
   <tr>
         <td>글번호</td>
         <td>${dto.notice_num}</td>
   </tr>
   <tr>
         <td>아이디</td>
         <td>${dto.notice_id}</td>
   </tr>
   <tr>
         <td>제  목</td>
         <td>${dto.notice_title}</td>
   </tr>
   <tr>
   		 <fmt:formatDate value="${dto.notice_date}" pattern="yyyy-MM-dd" var="date" />	
         <td>작성일</td>
         <td>${date}</td>
   </tr>
   <tr>
         <td>조회수</td>
         <td>${dto.notice_hit}</td>
   </tr>
   <tr>
         <td>내용</td>
         <td>${dto.notice_content}</td>
   </tr>
   
   </table>
   </div>   
   </div>
		<div class="container">
			<div class="row justify-content-end">
	<sec:authorize access="hasRole('ADMIN')">
					<a class="btn btn-info" href="noticedelete?num=${dto.notice_num}">삭제</a> &nbsp;&nbsp;
         <a class="btn btn-info"
						href="noticemodify?num=${dto.notice_num}">수정</a> &nbsp;&nbsp;
    </sec:authorize>
				<a class="btn btn-info" href="#" onclick="history.go(-1)">목록보기</a>
			</div>
		</div>

		</c:forEach>


</body>
<footer>
   <!-- footer -->
   <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>