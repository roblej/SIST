<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div id="map" style="width:500px;height:400px;"></div>
<div id="map" style="width:500px;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e947476c55a71da85e3dbb12acda597"></script>
<script>
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(37.450701, 127.570667),
        level: 3
    };

    var map = new kakao.maps.Map(container, options);

    var points = [
        new kakao.maps.LatLng(37.450701, 127.570667)
    ];

    // 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
    var bounds = new kakao.maps.LatLngBounds();

    var i, marker;
    for (i = 0; i < points.length; i++) {

        marker =     new kakao.maps.Marker({ position : points[i] }); // 마커 생성
        marker.setMap(map); // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다

        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(points[i]);
    }
</script>
</body>
</html>