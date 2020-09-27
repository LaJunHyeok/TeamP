<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>

<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginForm</title>
</head>
<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>


   <div class="cotainer">
      <div class="row justify-content-center">
         <div class="text-center">
         <form class="form-signin" action="/loginOk" method="post">
         <p style="text-align: center">
         <br><br>
         <font size="6" color="#5bc0de">로 그 인</font> <br>
         <br>
     	 <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
         <label for="inputID" class="sr-only">ID</label>
         <input type="text" name="username" placeholder="아이디" class="form-control" placeholder="ID" required autofocus>
         <label for="inputPassword" class="sr-only">Password</label>
         <input type="password" name="password" class="form-control" placeholder="비밀번호" required>
        </p>
        <div class="container">
        
      <div class="row justify-content-center">
         <button class="btn btn-md btn-info" type="submit">로 그 인</button> &nbsp;&nbsp;
      
         <a type ="button" class="btn btn-md btn-info" href="joinForm">회원가입</a>
      </div>
      <c:if test="${param.error != null}">
      <p>
      ${error_message }
      </p>
      </c:if>
      </div>   
    </form>
         </div>
      </div>
   </div>
   
   

</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>