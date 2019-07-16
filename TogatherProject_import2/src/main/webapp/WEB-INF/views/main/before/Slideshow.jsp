<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 슬라이드쇼 -->
<div class="slideshow">
	<div class="slideshow-container">
		<div class="mySlides fadeslide slideshowSlide">
			<img src="resources/images/slideshow02.png">
		</div>

		<div class="mySlides fadeslide slideshowSlide">
			<img src="resources/images/slideshow01.png">
		</div>

		<a class="prevslideShow" onclick="plusSlides(-1)">&#10094;</a>
		<a class="nextslideShow" onclick="plusSlides(1)">&#10095;</a>
	</div>
	<br>

	<div class="dot-container">
		<span class="dot dotSlideshow" onclick="currentSlide(1)"></span>
		<span class="dot dotSlideshow" onclick="currentSlide(2)"></span>
	</div>
</div>



<script type="text/javascript">
var slideIndexShow = 1;
showSlides(slideIndexShow);

function plusSlides(n) {
showSlides(slideIndexShow += n);
}

function currentSlide(n) {
showSlides(slideIndexShow = n);
}

function showSlides(n) {
  var k;
  var slidesShow = document.getElementsByClassName("slideshowSlide");
  var dotsShow = document.getElementsByClassName("dotSlideshow");
  if (n > slidesShow.length) {slideIndexShow = 1}    
  if (n < 1) {slideIndexShow = slidesShow.length}
  for (i = 0; i < slidesShow.length; i++) {
	  slidesShow[i].style.display = "none";  
  }
  for (i = 0; i < dotsShow.length; i++) {
	  dotsShow[i].className = dotsShow[i].className.replace(" active", "");
  }
  slidesShow[slideIndex-1].style.display = "block";  
  dotsShow[slideIndex-1].className += " active";
}
</script>
