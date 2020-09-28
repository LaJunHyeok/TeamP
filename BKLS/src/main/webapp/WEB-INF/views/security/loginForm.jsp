<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="com.project.springboot.signuplogin.Account" %>


<%
	String name = "";
	String msg = (String) request.getAttribute("exceptionMsgName");
	
	if (msg == null || msg.equals("")) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			Object principal = auth.getPrincipal();
			if (principal instanceof Account)
				System.out.println(" Accout 객체 맞음 !! ");
			else
				System.out.println(" Accout 객체 아님.. " + principal.getClass().toString());
			if (principal != null && principal instanceof Account) {
				name = ((Account) principal).getUsername();
				System.out.println(" Account에서 가지고온 이름 ! : " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>



<html>
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
     	 
         <label for="inputID" class="sr-only">ID</label>
         <input type="text" id="username" name="username" placeholder="아이디" class="form-control" placeholder="ID" required autofocus>
         <label for="inputPassword" class="sr-only">Password</label>
         <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호" required>
        </p>
        <div class="container">

						<div class="row justify-content-center">
							<button class="btn btn-md btn-info" type="submit">로 그 인</button>
							&nbsp;&nbsp; <a type="button" class="btn btn-md btn-info"
								href="joinForm">회원가입</a>
						</div>
						<%-- <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}"> --%>
						<c:if test="${not empty exceptionMsgName}">
							<br>
							<font color="red">
								<p>${exceptionMsgName}
									<%-- ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} --%>
								</p>
							</font>
							<%-- </c:if> --%>
						</c:if>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>
					
					<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
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