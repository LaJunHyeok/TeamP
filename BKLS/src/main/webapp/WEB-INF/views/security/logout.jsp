<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>LoginForm</title>
</head>
<body>
<h1>loginForm.jsp</h1>

<form action ="login.do" method="post">

	ID : <input type="text" name="j_username" value="${username}"><br/>
	PW : <input type="text" name="j_password"><br/>
	<input type="submit" value="LOGIN"><br/>
</form>

</body>
</html>
