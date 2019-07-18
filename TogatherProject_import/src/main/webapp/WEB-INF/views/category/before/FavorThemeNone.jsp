<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
   request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath();
%>
<link href="<c:url value="/resources/css/category/periodList.css" />"
   rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/category.js" />"></script>
<div class="contentList">
	<div class="categoryB">
		<span>관심테마</span>
	</div>
	<div class="searchDate">
	</div>
	<div style="width: 1140px; height: 55px;">
		<div class="listLine"></div>
	</div>
	<div style="width: 1140px; height: 700px; margin-bottom: 20px;">
		<div style="padding: 100px 100px 100px 100px">
			<div style="text-align: center; margin-bottom: 20px;"><span style="font-size: 35pt; font-family: 맑은 고딕; font-weight: bold;"><i class="fas fa-exclamation-circle"></i></span></div>
			<div style="text-align: center; margin-bottom: 20px;"><span style="font-size: 35pt; font-family: 맑은 고딕; font-weight: bold;" >등록한 관심테마가 없습니다.</span></div>
			<div style="text-align: center;">
				<a href="" style="width: 300px; height:50px; color: white; text-decoration: none; font-size: 20pt; font-family: 맑은 고딕; font-weight: bold; border-radius:5px; border: 0px; background-color: rgb(60,127,68);" onmouseout="change2(this)" onmouseover="change1(this)">관심테마등록하러가기</a>
			</div>
		</div>
	</div>
</div>

	<!-- script -->
	<script type="text/javascript">
		function change1(obj) {
			obj.style.color = 'black';
		}
		function change2(obj) {
			obj.style.color = 'white';
		}
	</script>
