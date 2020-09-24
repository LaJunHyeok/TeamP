<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 성공</title>
</head>
<body>
    <h1>로그인 성공!!</h1>
    <hr>
    <p>
        <span sec:authentication="name"></span>님 환영합니다~
    </p>
    <a th:href="@{'/'}">메인으로 이동</a>
</body>
</html>