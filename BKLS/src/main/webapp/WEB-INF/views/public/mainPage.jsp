<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAFE SEOUL</title>
<style>
.left {
    left:50%;
    float:left; 
    width:50%;
}

.right {
    border-left: 1px solid gray;
    height: 100%;
    float:left; 
    width:50%;
}
</style>
</head>
<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>

<body>
<br><br><br>
<!-- 메인페이지 (좌측엔 시각화자료, 우측엔 범죄토픽 크롤링데이터 시각화) -->
<div class="container">
<div class="left">
    <img src="seoul.png" width="80%" height="80%">
</div> 
<div class="right">
    <ul class="topic_li">
        <li><h1>토픽 </h1></li>
        <li><h1>토픽 </h1></li>
        <li><h1>토픽 </h1></li>
        <li><h1>토픽 </h1></li>
        <li><h1>토픽 </h1></li>
        <li><h1>토픽 </h1></li>
        <li><h1>토픽 </h1></li>
    </ul>
</div>
</div>
</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>