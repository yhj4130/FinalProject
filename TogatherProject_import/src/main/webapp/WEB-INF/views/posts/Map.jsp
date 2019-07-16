<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>simpleMap</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script
	src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=55b7752b-1fe5-4ee9-9b9c-0474cb716aef"></script>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>

</head>

<style>
.ft_select_wrap {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
}

.searchTitle {
	text-align: center;
	font-family: 나눔고딕;
	font-weight: bold;
}

.center {
	text-align: center;
}

button.btn.btn-success.center {
	margin: 50px 0px 50px 0px;
}
</style>
<body>

	<div id="map_div">
		<!-- 지도표시 영역 -->
	</div>
	<!-- <div>
		<button onClick="Move()">처음 위치로 지도 이동</button>
		<button onClick="PanTo()">지도 중심좌표 부드럽게 이동</button>
	</div> -->
	<input type="hidden" id="id" value='${id}'/>
	<div class="ft_area">
		<div class="ft_select_wrap">
			<div class="text_div_custom2">
				<input type="text" class="text_custom" id="searchKeyword"
					name="searchKeyword">
				<button onClick="search()">검색</button>
			</div>

		</div>

	</div>
	<div class="searchTitle">검색 결과</div>
	<hr>
	<div class="center" style="height: auto; overflow-y: scroll;"
		id="searchResult" name="searchResult">없음</div>
	<hr>
	<div class="center">
		<button type="button" class="btn btn-success center">선택</button>
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="resources/js/posts/Map.js" />"></script>
	
	
</body>
</html>
