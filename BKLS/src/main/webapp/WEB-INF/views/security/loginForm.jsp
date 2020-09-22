<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginForm</title>
</head>
<!-- 메뉴 바 -->
<jsp:include page="menubar.jsp" flush="false" />
<!--  -->
<body>
   <div class="cotainer">
      <div class="row justify-content-center">
         <form action="login.do" method="post">
         <body class="text-center">
         <form class="form-signin" action="loginOk.jsp" method="post">
         <p style="text-align: center">
         <br><br>
         <font size="6" color="#5bc0de">로 그 인</font> <br>
         <br>
         <label for="inputID" class="sr-only">ID</label>
         <input type="text" name="id" placeholder="아이디" class="form-control" value="<%if (session.getAttribute("id") != null)
         out.println(session.getAttribute("id"));%>" required autofocus>
         <label for="inputPassword" class="sr-only">Password</label>
         <input type="password" name="pw" class="form-control" placeholder="비밀번호" required>
         </form>
      </div>
   </div>
   
   <div class="container">
      <div class="row justify-content-center">
         <button class="btn btn-md btn-info" type="submit">로 그 인</button> &nbsp;&nbsp;
      
         <a type ="button" class="btn btn-md btn-info" href="join.jsp">회원가입</a>
      </div>
    </div>   

</body>
</html>