<%@ page contentType="text/html; charset=UTF-8"%>
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

<!-- new10 -->
<div class="listName">NEW 10</div>
<div class="slideshow">
	<div class="slideshow-container">
		
			<div class="mySlides fadeslide NewMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; justify-content: space-between; margin-top: 30px;">
		         <c:forEach var="newMain" items="${newMainList }" begin="0" end="2">         
		         <div style="width: 350px; text-align: center; float: left;">
		               <div class="card" style="width: 200px; height: 400px; border: 0px; display: inline-block;">
		                  <div class="selector" style="width: 200px; height: 200px;">
		                     <a href=""><img src="<c:url value="" />" class="card-img-top" alt="..."></a>
		                  </div>
		                  <div class="cardBody">
		                     <div><span class="postTitle">${newMain.title}</span></div>
		                     <div><span class="postContent">여행작가 : ${newMain.nickName }</span></div>
		                     <div><span class="postContent">
		                           여행테마 : 
		                           <c:forEach var="thema" items="${newMain.themaType }">
		                              ${thema} 　
		                           </c:forEach>
		                        </span></div>
		                     <div><span class="postContent">${newMain.region_Start }-${newMain.city_Start }</span></div>
		                     <div><span class="postContent">→${newMain.region_End }/${newMain.city_End }</span></div>
		                     <div><span class="postContent">${newMain.t_Start } ~ ${newMain.t_End }</span></div>
		                     <div><span class="postContent">모집마감 ${newMain.recruit_End }</span></div>
		                  </div>
		               </div>
		         </div>
		         </c:forEach>
		        </div>
			</div>
			<div class="mySlides fadeslide NewMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; justify-content: space-between; margin-top: 30px;">
		         <c:forEach var="newMain" items="${newMainList }" begin="3" end="5">         
		         <div style="width: 350px; text-align: center; float: left;">
		               <div class="card" style="width: 200px; height: 400px; border: 0px; display: inline-block;">
		                  <div class="selector" style="width: 200px; height: 200px;">
		                     <a href=""><img src="<c:url value="" />" class="card-img-top" alt="..."></a>
		                  </div>
		                  <div class="cardBody">
		                     <div><span class="postTitle">${newMain.title}</span></div>
		                     <div><span class="postContent">여행작가 : ${newMain.nickName }</span></div>
		                     <div><span class="postContent">
		                           여행테마 : 
		                           <c:forEach var="thema" items="${newMain.themaType }">
		                              ${thema} 　
		                           </c:forEach>
		                        </span></div>
		                     <div><span class="postContent">${newMain.region_Start }-${newMain.city_Start }</span></div>
		                     <div><span class="postContent">→${newMain.region_End }/${newMain.city_End }</span></div>
		                     <div><span class="postContent">${newMain.t_Start } ~ ${newMain.t_End }</span></div>
		                     <div><span class="postContent">모집마감 ${newMain.recruit_End }</span></div>
		                  </div>
		               </div>
		         </div>
		         </c:forEach>
		        </div>
			</div>
			<div class="mySlides fadeslide NewMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; justify-content: space-between; margin-top: 30px;">
		         <c:forEach var="newMain" items="${newMainList }" begin="6" end="8">         
		         <div style="width: 350px; text-align: center; float: left;">
		               <div class="card" style="width: 200px; height: 400px; border: 0px; display: inline-block;">
		                  <div class="selector" style="width: 200px; height: 200px;">
		                     <a href=""><img src="<c:url value="" />" class="card-img-top" alt="..."></a>
		                  </div>
		                  <div class="cardBody">
		                     <div><span class="postTitle">${newMain.title}</span></div>
		                     <div><span class="postContent">여행작가 : ${newMain.nickName }</span></div>
		                     <div><span class="postContent">
		                           여행테마 : 
		                           <c:forEach var="thema" items="${newMain.themaType }">
		                              ${thema} 　
		                           </c:forEach>
		                        </span></div>
		                     <div><span class="postContent">${newMain.region_Start }-${newMain.city_Start }</span></div>
		                     <div><span class="postContent">→${newMain.region_End }/${newMain.city_End }</span></div>
		                     <div><span class="postContent">${newMain.t_Start } ~ ${newMain.t_End }</span></div>
		                     <div><span class="postContent">모집마감 ${newMain.recruit_End }</span></div>
		                  </div>
		               </div>
		         </div>
		         </c:forEach>
		        </div>
			</div>
			<!-- 마지막 한 장 -->
			<div class="mySlides fadeslide NewMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; flex-direction: left; margin-top: 30px;">
		         <c:forEach var="newMain" items="${newMainList }" begin="9" end="9">         
		         <div style="width: 350px; text-align: center; float: left;">
		               <div class="card" style="width: 200px; height: 400px; border: 0px; display: inline-block;">
		                  <div class="selector" style="width: 200px; height: 200px;">
		                     <a href=""><img src="<c:url value="" />" class="card-img-top" alt="..."></a>
		                  </div>
		                  <div class="cardBody">
		                     <div><span class="postTitle">${newMain.title}</span></div>
		                     <div><span class="postContent">여행작가 : ${newMain.nickName }</span></div>
		                     <div><span class="postContent">
		                           여행테마 : 
		                           <c:forEach var="newMainThema" items="${newMain.themaType }">
		                              ${newMainThema} 　
		                           </c:forEach>
		                        </span></div>
		                     <div><span class="postContent">${newMain.region_Start }-${newMain.city_Start }</span></div>
		                     <div><span class="postContent">→${newMain.region_End }/${newMain.city_End }</span></div>
		                     <div><span class="postContent">${newMain.t_Start } ~ ${newMain.t_End }</span></div>
		                     <div><span class="postContent">모집마감 ${newMain.recruit_End }</span></div>
		                  </div>
		               </div>
		         </div>
		         </c:forEach>
		        </div>
			</div>

		

		<a class="prevslideNew" onclick="plusSlidesNew(-1)">&#10094;</a>
		<a class="nextslideNew" onclick="plusSlidesNew(1)">&#10095;</a>
	</div>
	<br>

	<div class="dot-container">
		<span class="dot dotNewMain" onclick="currentSlideNew(1)"></span>
		<span class="dot dotNewMain" onclick="currentSlideNew(2)"></span>
		<span class="dot dotNewMain" onclick="currentSlideNew(3)"></span>
		<span class="dot dotNewMain" onclick="currentSlideNew(4)"></span>
	</div>
</div>

<script type="text/javascript">
var slideIndexNew = 1;
showSlidesNew(slideIndexNew);

function plusSlidesNew(n) {
showSlidesNew(slideIndexNew += n);
}

function currentSlideNew(n) {
showSlidesNew(slideIndexNew = n);
}

function showSlidesNew(n) {
  var i;
  var slidesNew = document.getElementsByClassName("NewMainSlide");
  var dotsNew = document.getElementsByClassName("dotNewMain");
  if (n > slidesNew.length) {slideIndexNew = 1}    
  if (n < 1) {slideIndexNew = slidesNew.length}
  for (i = 0; i < slidesNew.length; i++) {
	  slidesNew[i].style.display = "none";  
  }
  for (i = 0; i < dotsNew.length; i++) {
	  dotsNew[i].className = dotsNew[i].className.replace(" active", "");
  }
  slidesNew[slideIndexNew-1].style.display = "block";  
  dotsNew[slideIndexNew-1].className += " active";
}
</script>