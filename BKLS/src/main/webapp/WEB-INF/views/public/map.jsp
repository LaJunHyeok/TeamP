<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
   src="//maps.googleapis.com/maps/api/js?key=AIzaSyBsCMHlsWE0Q5X_TAbJY1tFf5Sgg0DeqFI"></script>
<meta charset="UTF-8">

<title>지도 첨부</title>

<header>
<!-- 메뉴 바 -->
<jsp:include page="menubar.jsp" flush="false" />

</header>

<script>
   function initialize() {

      var Y_point = 37.5686075; // Y 좌표
      var X_point = 126.9826324; // X 좌표
      var zoomLevel = 15; // 첫 로딩시 보일 지도의 확대 레벨
      var markerTitle = "ㅁㄴㅇㅁㄴㅇ"; // 현재 위치 마커에 마우스를 올렸을때 나타나는 이름
      var markerMaxWidth = 300; // 마커를 클릭했을때 나타나는 말풍선의 최대 크기

      var contentString = '<div id="content">' + '<div id="siteNotice">'
            + '</div>'
            + '<h3 id="firstHeading" class="firstHeading">ㅁㄴㅇ</h3>'
            + '<div id="bodyContent">' + '<p>ㅁㄴㅇㅁㄴㅇ<br />'
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

</head>

<body>
	
	<div class="container">
	<div class="row justify-content-center">
	<p style="text-align:start">
	<br>
	<font size="6" color="#5bc0de">테스트</font>
	</div>
	</div>
	<br>
	
	
	<div class="container">
		<div class="row justify-content-center">
			<div id="map_view" style="width: 600px; height: 600px;"></div>	
		</div>
	</div>	

</body>
<footer>
    <!-- footer -->
    <jsp:include page="footer.jsp" flush="false" />
</footer>
</html>