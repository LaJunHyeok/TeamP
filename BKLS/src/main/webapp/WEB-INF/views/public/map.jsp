<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사 약도</title>
</head>
<!-- Google api -->
<script type="text/javascript"
   src="//maps.googleapis.com/maps/api/js?key=AIzaSyBsCMHlsWE0Q5X_TAbJY1tFf5Sgg0DeqFI"></script>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
   integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
   crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
   integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
   crossorigin="anonymous"></script>



<script>
   function initialize() {

      var Y_point = 37.5686075; // Y 좌표
      var X_point = 126.9826324; // X 좌표
      var zoomLevel = 15; // 첫 로딩시 보일 지도의 확대 레벨
      var markerTitle = "맨날 와야되는곳"; // 현재 위치 마커에 마우스를 올렸을때 나타나는 이름
      var markerMaxWidth = 300; // 마커를 클릭했을때 나타나는 말풍선의 최대 크기

      var contentString = '<div id="content">' + '<div id="siteNotice">'
            + '</div>'
            + '<h3 id="firstHeading" class="firstHeading">프로젝트</h3>'
            + '<div id="bodyContent">' + '<p>Team Project<br />'
            + 'Tel. 02-0000-0000</p>' + '</div>' + '</div>';

      var myLatlng = new google.maps.LatLng(Y_point, X_point);
      var mapOptions = {
         zoom : zoomLevel,
         center : myLatlng,
         mapTypeId : google.maps.MapTypeId.ROADMAP
      }
      var map = new google.maps.Map(document.getElementById('map_view'),
            mapOptions);

      var marker = new google.maps.Marker({
         position : myLatlng,
         map : map,
         title : markerTitle
      });

      var infowindow = new google.maps.InfoWindow({
         content : contentString,
         maxWidth : markerMaxWidth
      });

      google.maps.event.addListener(marker, 'click', function() {
         infowindow.open(map, marker);
      });
   }
   
   google.maps.event.addDomListener(window, 'load', initialize);
</script>
 <!-- 메뉴 바 -->
   <jsp:include page="../menubar.jsp" flush="false" />
   
<body style="overflow: scroll;">
   
   <br><br>
   <div class="container">
      <div class="row justify-content-center">
         <p style="text-align:start">
            <font size="6" color="#5bc0de">회사 약도</font>
      </div>
   </div>
   
   <div class="container">
      <div class="row justify-content-center">
         <div id="map_view" style="width: 700px; height: 700px;"></div>
      </div>   
   </div>

</body>

<jsp:include page="../footer.jsp" flush="false" />

</html>