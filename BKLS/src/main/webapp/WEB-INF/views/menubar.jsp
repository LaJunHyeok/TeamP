<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- ------------------------------------------------------------------------- -->
<% String se = "1"; %>
<!--  ------------------------------------------------------------------------ -->


<!-- Nav Bar -->   
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand">
  <a href="/BKLS/"><img src="seoul.png" width="80" height="80" ></a>
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
          <a class="dropdown-item" href="notice">공지 사항</a>
          <a class="dropdown-item" href="help">건의 및 민원</a>
        </div>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="navi"> 주변 파출소 안내 <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="loginForm">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">로그인</button>
    </form>
    <% if(se=="1"){ %>
      <form class="form-inline my-2 my-lg-0" action="logout">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">로그아웃</button>
    </form>
   <% } else{ %>
   <form class="form-inline my-2 my-lg-0" action="joinForm">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">회원가입</button>
    </form>
   <%  }; %>
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