<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.footer {
    display: flex;
    position:absolute;
    bottom:0;
    width: 100%;
    height: 100px;   
    background: gray;
}
.footleft {
    flex: 1;
    padding: 1%;
    text-align: center;
}

.footcenter {
    flex: 1;
    padding: 1%;
    text-align: center;
}

.footright{
    flex: 1;
    padding: 1%;
    text-align: center;
}
</style>
<body>
<div class="footer">
    
    <!-- 회사소개/지도보기 -->
    <div class="footleft">
       <p>서울시 종로구 삼일대로17길 51 스타골드 빌딩 3층 </p>
       
       <a href="map">ㄱㄱ</a>
       <!-- 
       <a href="#" onClick="window.open('https://map.naver.com/v5/entry/place/1189668723?c=14135386.1795637,4518812.5984630,15,0,0,0,dh','지도보기','width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">지도보기</a>
        -->
    </div>
    
    <!-- 회사 목적 소개 -->
    <div class="footcenter">
        <p> 서울시 내의 범죄발생 관련하여 정보를 제공하는 사이트 입니다. </p>
    </div>
    
    <!-- 신고하기 or 사이버수사대 링크 주기-->
    <div class="footright">
    <a href="#" onClick="window.open('https://cyberbureau.police.go.kr/crime/sub1.jsp?mid=010101','사이버수사대','width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">사이버수사대신고하기</a>
    </div>
</div>
</body>
</html>