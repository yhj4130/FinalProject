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

<!--------------------------------------------------- content -------------------------------------------------->
<!-- 슬라이드쇼 -->
<div class="slideshow">
	<div class="slideshow-container">
		<div class="mySlides fadeslide">
			<img src="resources/images/slideshow02.png">
		</div>

		<div class="mySlides fadeslide">
			<img src="resources/images/slideshow01.png">
		</div>

<!-- 		<div class="mySlides fadeslide">
			<img src="resources/images/slideshow03.png">
		</div> -->

		<a class="prevslide" onclick="plusSlides(-1)">&#10094;</a>
		<a class="nextslide" onclick="plusSlides(1)">&#10095;</a>
	</div>
	<br>

	<div class="dot-container">
		<span class="dot" onclick="currentSlide(1)"></span>
		<span class="dot" onclick="currentSlide(2)"></span>
		<!-- <span class="dot" onclick="currentSlide(3)"></span> -->
	</div>
</div>



<!-- best10 -->
<div class="contentList">
   <div class="categoryB">
      <span>BEST</span>
   </div>
   
   <div style="width: 1140px; height: 1600px; margin-bottom: 20px;">
   
      <div style="margin: 0px 20px 20px 20px;">
         <c:forEach var="bestMain" items="${bestMainList }">         
         <div style="width: 275px; text-align: center; float: left;">
               <div class="card" style="width: 200px; height: 400px; border: 0px; display: inline-block;">
                  <div class="selector" style="width: 200px; height: 200px;">
                     <a href=""><img src="<c:url value="" />" class="card-img-top" alt="..."></a>
                  </div>
                  <div class="cardBody">
                     <div><span class="postTitle">${bestMain.title}</span></div>
                     <div><span class="postContent">여행작가 : ${bestMain.nickName }</span></div>
                     <div><span class="postContent">
                           여행테마 : 
                           <c:forEach var="thema" items="${bestMain.themaType }">
                              ${thema} 　
                           </c:forEach>
                        </span></div>
                     <div><span class="postContent">${bestMain.region_Start }-${bestMain.city_Start }</span></div>
                     <div><span class="postContent">→${bestMain.region_End }/${bestMain.city_End }</span></div>
                     <div><span class="postContent">${bestMain.t_Start } ~ ${bestMain.t_End }</span></div>
                     <div><span class="postContent">모집마감 ${bestMain.recruit_End }</span></div>
                  </div>
               </div>
         </div>
         </c:forEach>
        </div>
        
	</div>
</div>



<!-- new10 -->
<div class="listName">NEW 10</div>
<div class="post-preview-wrapper">
	<div class="post-preview mb-5">
		<a class="post-preview-img" href=""> <img class="post-preview-img"
			src="<c:url value="resources/images/slideFile2.jpg"/>">
		</a>
		<div class="post-title post-desc">title1</div>
		<div class="post-desc">nickname1</div>
		<div class="post-desc">theme1</div>
		<div class="post-desc">location1</div>
		<div class="post-desc">how long1</div>
		<div class="post-desc">end collect date1</div>
	</div>
	<div class="post-preview mb-5">
		<a class="post-preview-img" href=""> <img class="post-preview-img"
			src="<c:url value="resources/images/slideFile2.jpg"/>">
		</a>
		<div class="post-title post-desc">title2</div>
		<div class="post-desc">nickname2</div>
		<div class="post-desc">theme2</div>
		<div class="post-desc">location2</div>
		<div class="post-desc">how long2</div>
		<div class="post-desc">end collect date2</div>
	</div>
	<div class="post-preview mb-5">
		<a class="post-preview-img" href=""> <img class="post-preview-img"
			src="<c:url value="resources/images/slideFile2.jpg"/>">
		</a>
		<div class="post-title post-desc">title3</div>
		<div class="post-desc">nickname3</div>
		<div class="post-desc">theme3</div>
		<div class="post-desc">location3</div>
		<div class="post-desc">how long3</div>
		<div class="post-desc">end collect date3</div>
	</div>
</div>


<!-- 슬라이드쇼 -->
<script type="text/javascript">
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
