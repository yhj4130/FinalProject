<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%

   Date now = new Date();
   SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 E요일");

%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="<c:url value="/resources/css/public.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/category/periodList.css" />" rel="stylesheet" type="text/css">


<!-- 슬라이드쇼 -->
<div class="slideshow">
	<div class="slideshow-container">
		<div class="mySlides fadeslide slideshowSlide">
			<img src="resources/images/slideshow02.png">
		</div>

		<div class="mySlides fadeslide slideshowSlide">
			<img src="resources/images/slideshow01.png">
		</div>

		<a class="prevslideShow" onclick="plusSlidesShow(-1)">&#10094;</a>
		<a class="nextslideShow" onclick="plusSlidesShow(1)">&#10095;</a>
	</div>
	<br>

	<div class="dot-container">
		<span class="dot dotSlideshow" onclick="currentSlide(1)"></span>
		<span class="dot dotSlideshow" onclick="currentSlide(2)"></span>
	</div>
</div>



<%-- <%@ include file="/WEB-INF/views/main/BestMain.jsp"%> --%>
<jsp:include page="/WEB-INF/views/main/BestMain.jsp" flush="true" />
<jsp:include page="/WEB-INF/views/main/NewMain.jsp" flush="true" />


<script type="text/javascript">
var slideIndexShow = 1;
showSlidesShow(slideIndexShow);

function plusSlidesShow(m) {
showSlidesShow(slideIndexShow += m);
}

function currentSlideShow(m) {
showSlidesShow(slideIndexShow = m);
}

function showSlidesShow(m) {
  var k;
  var slidesShow = document.getElementsByClassName("slideshowSlide");
  var dotsShow = document.getElementsByClassName("dotSlideshow");
  if (m > slidesShow.length) {slideIndexShow = 1}    
  if (m < 1) {slideIndexShow = slidesShow.length}
  for (k = 0; k < slidesShow.length; k++) {
	  slidesShow[k].style.display = "none";  
  }
  for (k = 0; k < dotsShow.length; k++) {
	  dotsShow[k].className = dotsShow[k].className.replace(" active", "");
  }
  slidesShow[slideIndexShow-1].style.display = "block";  
  dotsShow[slideIndexShow-1].className += " active";
}
</script>
