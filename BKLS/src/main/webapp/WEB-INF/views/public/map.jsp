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
   src="//maps.googleapis.com/maps/api/js?key=AIzaSyBsCMHlsWE0Q5X_TAbJY1tFf5Sgg0DeqFI&callback=initMap&libraries=places&v=weekly"
      defer></script>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
   integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
   crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
   integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
   crossorigin="anonymous"></script>

    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
   
  
    <script>
      // This example requires the Places library. Include the libraries=places
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">
      let map;
      let service;
      let infowindow;

      function initMap() {
        const now = new google.maps.LatLng(37.5686075, 126.9826324);
        infowindow = new google.maps.InfoWindow();
        map = new google.maps.Map(document.getElementById("map"), {
          center: now,
          zoom: 15,
        });
        const request = {
          query: "경찰서",
          fields: ["name", "geometry"],
        };
        service = new google.maps.places.PlacesService(map);
        service.findPlaceFromQuery(request, (results, status) => {
          if (status === google.maps.places.PlacesServiceStatus.OK) {
            for (let i = 0; i < results.length; i++) {
              createMarker(results[i]);
            }
            map.setCenter(results[0].geometry.location);
          }
        });
      }

      function createMarker(place) {
        const marker = new google.maps.Marker({
          map,
          position: place.geometry.location,
        });
        google.maps.event.addListener(marker, "click", () => {
          infowindow.setContent(place.name);
          infowindow.open(map);
        });
      }
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
         <div id="map" style="width: 700px; height: 700px;"></div>
      </div>   
   </div>

</body>

<jsp:include page="../footer.jsp" flush="false" />

</html>