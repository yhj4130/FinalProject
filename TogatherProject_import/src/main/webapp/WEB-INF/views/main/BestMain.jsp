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
<!-- best10 -->
<div class="listName">BEST 10</div>
<div class="slideshow">
	<div class="slideshow-container">
		
			<div class="mySlides fadeslide bestMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; justify-content: space-between; margin-top: 30px;">
		         <c:forEach var="bestMain" items="${bestMainList }" begin="0" end="2">         
		         <div style="width: 350px; text-align: center; float: left;">
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
			<div class="mySlides fadeslide bestMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; justify-content: space-between; margin-top: 30px;">
		         <c:forEach var="bestMain" items="${bestMainList }" begin="3" end="5">         
		         <div style="width: 350px; text-align: center; float: left;">
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
			<div class="mySlides fadeslide bestMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; justify-content: space-between; margin-top: 30px;">
		         <c:forEach var="bestMain" items="${bestMainList }" begin="6" end="8">         
		         <div style="width: 350px; text-align: center; float: left;">
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
			<!-- 마지막 한 장 -->
			<div class="mySlides fadeslide bestMainSlide">
				<div style="width: 1140px; height: 400px; display: flex; flex-direction: left; margin-top: 30px;">
		         <c:forEach var="bestMain" items="${bestMainList }" begin="9" end="9">         
		         <div style="width: 350px; text-align: center; float: left;">
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

		

		<a class="prevslideBest" onclick="plusSlidesBest(-1)">&#10094;</a>
		<a class="nextslideBest" onclick="plusSlidesBest(1)">&#10095;</a>
	</div>
	<br>

	<div class="dot-container">
		<span class="dot dotBestMain" onclick="currentSlideBest(1)"></span>
		<span class="dot dotBestMain" onclick="currentSlideBest(2)"></span>
		<span class="dot dotBestMain" onclick="currentSlideBest(3)"></span>
		<span class="dot dotBestMain" onclick="currentSlideBest(4)"></span>
	</div>
</div>




<script type="text/javascript">
var slideIndexBest = 1;
showSlidesBest(slideIndexBest);

function plusSlidesBest(l) {
  showSlidesBest(slideIndexBest += l);
}

function currentSlideBest(l) {
  showSlidesBest(slideIndexBest = l);
}

function showSlidesBest(l) {
  var j;
  var slidesBest = document.getElementsByClassName("bestMainSlide");
  var dotsBest = document.getElementsByClassName("dotBestMain");
  if (l > slidesBest.length) {slideIndexBest = 1}    
  if (l < 1) {slideIndexBest = slidesBest.length}
  for (j = 0; j < slidesBest.length; j++) {
	  slidesBest[j].style.display = "none";  
  }
  for (j = 0; j < dotsBest.length; j++) {
	  dotsBest[j].className = dotsBest[j].className.replace(" active", "");
  }
  slidesBest[slideIndexBest-1].style.display = "block";  
  dotsBest[slideIndexBest-1].className += " active";
}
</script>