<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="com.project.springboot.signuplogin.Account" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAFE SEOUL</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
   integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
   crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
   integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
   crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->

<!-- Nav Bar -->   
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand">
  <a href="/"><img src="../seoul.png" width="80" height="80" ></a>
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href=""> 데이터 게시판 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          게시판
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="notice?page=1">공지 사항</a>
          <a class="dropdown-item" href="public/help">건의 및 민원</a>
        </div>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/public/navi"> 주변 파출소 안내 <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <sec:authorize access="!isAuthenticated()">
    <form class="form-inline my-2 my-lg-0" action="/security/loginForm">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">로그인</button>
    </form>
   <form class="form-inline my-2 my-lg-0" action="/security/joinForm">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">회원가입</button>
    </form>
    </sec:authorize>


		<sec:authorize access="isAuthenticated()">
			<div class="form-group" align="center">
				<h5><sec:authentication property="principal.username" />
					님, 반갑습니다.
					<%--<sec:authentication property="principal.username" />님, 겁나 반갑습니다. --%>
				</h5>
				<br>
				<form action="/logout" method="POST">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button type="submit" class="btn btn-dark btn-sm">LOGOUT</button>
				</form>
			</div>
		</sec:authorize>
		<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
		<sec:authorize access="hasRole('ADMIN')">
    <a href="admin/userList">관리자화면</a>
    </sec:authorize>

     


  </div>
</nav>
<!-- Nav Bar -->


<!-- Optional JavaScript -->
   <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"></script>
   <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
      integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
      crossorigin="anonymous"></script>
</head>

<body>

</body>

</html>