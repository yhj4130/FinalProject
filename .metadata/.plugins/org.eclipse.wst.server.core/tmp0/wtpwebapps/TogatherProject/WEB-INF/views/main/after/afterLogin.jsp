<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--------------------------------------------------- content -------------------------------------------------->
<!-- 별명 및 쪽지 -->
<div class="nickname-container">
	<div class="user-nickname">
		님
		<div class="nickname">${nickNameMain }</div>
	</div>
</div>

<!-- 떠날 여행 목록 -->
<div class="login-list mb-5">
	<!-- mb-5: margin-bottom css를 위한 클래스(리스트목록, 메인페이지 BEST/NEW 미리보기 나열에서 사용) -->
	<div class="list-title">
		<div class="listName">
			떠날 여행 목록 <span data-toggle="tooltip" data-placement="right"
				title="D-Day가 짧은 순으로 확정된 모든 여행 목록.&#10;남은기간이 짧은 순서로 3개가 출력되고 나머지 목록을 보고 싶은 경우 목록 우측상단의 '더보기'를 누르세요.">
				<img src="<c:url value="resources/images/questionmark.png" />"
				class="img-ques">
			</span>
		</div>
		<div class="list-more-href">
			<a href="">더보기</a>
		</div>
	</div>

	<table class="table">
		<tr>
			<th>게시물제목</th>
			<th>여행작가</th>
			<th class="d-day">여행시작</th>
			<th>출발일</th>
			<th>도착일</th>
		</tr>
		
		<c:if test="${empty goingInfo }">
		<tr>
			<td colspan="5">
				<img src="<c:url value="resources/images/exclamationmark.png"/>" class="img-excla"> 
				여행목록이 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		
		<c:forEach var="goingList" items="${goingInfo }" begin="0" end="2">
			<tr>
				<td>${goingList.title }</td>
				<td>${goingList.nickName }</td>
				<td class="d-day">D - ${goingList.goingDDay }</td>
				<td>${goingList.t_Start }</td>
				<td>${goingList.t_End }</td>
				<!-- <img src="<c:url value="resources/images/exclamationmark.png"/>" class="img-excla"> 
					여행목록이 존재하지 않습니다. -->
			</tr>
		</c:forEach>
	</table>
</div>

<!-- Ready 목록 -->
<div class="login-list mb-5">
	<div class="list-title">
		<div class="listName">
			Ready 목록 <span data-toggle="tooltip" data-placement="right"
				title="본인을 게시물의 여행작가가 동행자로 선택한 게시물 목록.&#10;여행참가를 확정하기 위해 'Ready'라는 절차를 거쳐야 합니다.&#10;남은기간이 짧은 순서로 3개가 출력되고 나머지 목록을 보고 싶을 경우 목록 우측상단의 '더보기'를 누르세요.">
				<img src="<c:url value="resources/images/questionmark.png" />" class="img-ques">
			</span>
		</div>
		<div class="list-more-href">
			<a href="">더보기</a>
		</div>
	</div>
	<table class="table">
		<tr>
			<th>게시물제목</th>
			<th>여행작가</th>
			<th class="d-day">Ready 남은기한</th>
			<th>출발일</th>
			<th>도착일</th>
			<th>링크</th>
		</tr>
		
		<c:if test="${empty readyInfo }">
		<tr>
			<td colspan="6">
				<img src="<c:url value="resources/images/exclamationmark.png"/>" class="img-excla"> 
				여행목록이 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="ready" items="${readyInfo }" begin="0" end="2">
			<tr>
				<td>${ready.title }</td>
				<td>${ready.nickName }</td>
				<td class="d-day">D - ${ready.readyDDay }</td>
				<td>${ready.t_Start }</td>
				<td>${ready.t_End }</td>
				<td>
					<div class="listbutton">
						<button type="button" class="listbtn" onclick="location.href=''">Ready</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>



<!-- Pick 목록 -->
<div class="login-list mb-5">
	<div class="list-title">
		<div class="listName">
			Pick 목록 <span data-toggle="tooltip" data-placement="right"
				title="업로드한 게시물의 모집기간이 끝나고 동행자 선택을 해야하는 게시물 목록.&#10;여행동반자를 선택하기 위해 'Pick'이라는 절차를 거쳐야 합니다.&#10;남은기간이 짧은 순서로 3개가 출력되고 나머지 목록을 보고 싶을 경우 목록 우측상단의 '더보기'를 누르세요.">
				<img src="<c:url value="resources/images/questionmark.png" />" class="img-ques">
			</span>
		</div>
		<div class="list-more-href">
			<a href="">더보기</a>
		</div>
	</div>
	<table class="table">
		<tr>
			<th>게시물제목</th>
			<th class="d-day">Pick 남은기한</th>
			<th>출발일</th>
			<th>도착일</th>
			<th>링크</th>
		</tr>
		
		<c:if test="${empty pickInfo }">
		<tr>
			<td colspan="5">
				<img src="<c:url value="resources/images/exclamationmark.png"/>" class="img-excla"> 
				여행목록이 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="pick" items="${pickInfo }" begin="0" end="2">
			<tr>
				<td>${pick.title }</td>
				<td class="d-day">D - ${pick.pickDDay }</td>
				<td>${pick.t_Start }</td>
				<td>${pick.t_End }</td>
				<td>
					<div class="listbutton">
						<button type="button" class="listbtn" onclick="location.href=''">Pick</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>



<!-- best10 -->
<jsp:include page="/WEB-INF/views/main/BestMain.jsp" flush="true" />


<!-- new10 -->
<jsp:include page="/WEB-INF/views/main/NewMain.jsp" flush="true" />


<!--------------------------------------------------- content -------------------------------------------------->

<script>
   $(function () {
      $('[data-toggle="tooltip"]').tooltip()
   })
</script>

