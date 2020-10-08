<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판 글쓰기 작성폼</title>
</head>

<!-- 에디터 -->
<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>

<header>
<!-- 메뉴 바 -->
<jsp:include page="../menubar.jsp" flush="false" />

</header>
<body>
   
   <br>
   <p style="text-align: center">
   <font size="6" color="#5bc0de">공지사항 작성</font> <br>   

   <div class="container">
   <div class="row justify-content-center">
   <form action="write" method="get">
      
      <div class="mb-3">
         <label for="제목">제목</label> <input type="text" class="form-control"
            name="title" placeholder="" value="" required>
      </div>

      <div class="mb-3">
         <label for="내용">내용</label>
         <textarea class="form-control" id="editor" name="content" rows="10"
            placeholder="" value="" required></textarea>
         <script>
            CKEDITOR.replace('editor');
         </script>
      </div>   
      
      <div class="container">
         <div class="row justify-content-end">
            <button type="submit" class="btn btn-info">작성 완료</button>
         </div>
      </div>
   </form>
   </div>   
   </div>   
</body>
<footer>
    <!-- footer -->
    <jsp:include page="../footer.jsp" flush="false" />
</footer>
</html>