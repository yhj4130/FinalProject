<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title></title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

<link href="<c:url value="resources/css/fontawesome/css/all.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="<c:url value="/resources/css/main/index.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/Posts/write.css" />"
	rel="stylesheet">
<script>
	var list = new Array();
	<c:forEach items="${t_resDate}" var="item">
	list.push("${item.t_start}");
	list.push("${item.t_end}");
	</c:forEach>
	<c:forEach items="${m_resDate}" var="item">
	list.push("${item.t_start}");
	list.push("${item.t_end}");
	</c:forEach>

	for (var i = 0; i < list.length; i++) { //배열 출력
		/* alert(list[i]); */		
	}

</script>
<script src="<c:url value='/resources/js/posts/write.js' />"
	type="text/javascript"></script>

</head>

<body>
	<div class="container">
		<div class="row header">
			<div class="blank col-md-1"></div>
			<div class="logo col-md-12">
				<%@ include file="/WEB-INF/tiles/layout/header_af.jsp"%>
				<%-- <tiles:insertAttribute name="header" /> --%>

			</div>
			<div class="blank col-md-1"></div>
		</div>


		<div class="row nevigator">
			<div class="blank col-md-1"></div>
			<div class="category col-md-12">
				<c:import url="/WEB-INF/tiles/layout/nevigator.jsp">
				</c:import>
				<%-- <tiles:insertAttribute name="nevigator" /> --%>
			</div>
			<div class="blank col-md-1"></div>
		</div>


		<div class="row content">
			<div class="blank col-md-1"></div>
			<div class="content col-md-12">
				<div class="section-content">
					<!-- <form name="frn"> -->
					<div class="head">
						<div class="content title">여행코스등록</div>
						<div class="content guide">여행경로 등록 안내</div>
					</div>
					<hr />

					<div class="body section1">

						<div class="sec write">
							<div class="position position1 ">
								<div class="subtitle">여행 제목</div>
								<div class="text">
									<input type="text" class="form-control" id="subject"
										placeholder="내용을 입력해주세요."> <span class="alert"
										id="subjectAlert">제목을 30자이내로 입력하세요.</span>
								</div>
							</div>
							<div class="position position2 arrayflex">
								<div class="subtitle">여행 소개</div>
								<div class="text">
									<textarea rows="8" id="introduceText"
										class="form-control noresize" placeholder="내용을 입력해주세요."></textarea>
								</div>
							</div>
						</div>
						<div class="sec image">
							<div class="imgfile">

								<img id="blah"
									src="<c:url value="/resources/images/insertimg.png" />"
									alt="이미지를 추가하시려면 이곳을 눌러주세요">

							</div>

							<input type="file" id="files" /> <i class="far fa-trash-alt"></i>


						</div>
					</div>
					<hr />
					<div class="body section2">
						<div class="sec category">
							<div class="subtitle">카테고리</div>
							<div class="text">
								<div class="btn-group btn-group-toggle" data-toggle="buttons">
									<label class="btn b1"><input type="checkbox" name="loc"
										id="loc" value="1">자연</label> <label class="btn b1"><input
										type="checkbox" name="loc" id="loc" value="2">문화관광</label> <label
										class="btn b1"><input type="checkbox" name="loc"
										id="loc" value="3">레저/스포츠</label> <label class="btn b1"><input
										type="checkbox" name="loc" id="loc" value="4">쇼핑</label> <label
										class="btn b1"><input type="checkbox" name="loc"
										id="loc" value="5">맛집</label> <label class="btn b1"><input
										type="checkbox" name="loc" id="loc" value="6">기타</label>
								</div>
								<span class="alert" id="locationAlert"><br>카테고리를
									선택해주세요.</span>
							</div>
						</div>
					</div>
					<div class="body section3">
						<div class="sec condition">
							<div class="subtitle">동행자조건</div>
							<div class="choice">
								<div class="con1 arrayflex margin20">
									<div class="con-name">연령</div>
									<div class="btn-group btn-group-toggle" data-toggle="buttons">
										<label class="btn b1"><input type="radio"
											class="checkAll" name="age" id="age0">전체</label> <label
											class="btn b1"><input type="radio" class="age"
											name="age" id="age20">20대</label> <label class="btn b1"><input
											type="radio" class="age" name="age" id="age30">30대</label> <label
											class="btn b1"><input type="radio" class="age"
											name="age" id="age40">40대</label> <label class="btn b1"><input
											type="radio" class="age" name="age" id="age50">50대 이상</label>
									</div>
									<span class="alert" id="ageAlert"><br>연령 선택해주세요.</span>

								</div>
								<div class="con2 arrayflex margin20">
									<div class="con-name">성별</div>
									<div class="btn-group btn-group-toggle gender"
										data-toggle="buttons">
										<label class="btn b1"><input type="radio"
											name="gender" id="gender1">전체</label> <label class="btn b1">
											<input type="radio" name="gender" id="gender2">동성
										</label>
									</div>
									<span class="alert" id="genderAlert"><br>성별을
										선택해주세요.</span>
								</div>
								<div class="con3 arrayflex margin20">
									<div class="con-name">기타</div>
									<div class="etctext">
										<textarea rows="5" class="form-control noresize"
											placeholder="내용을 입력해주세요."></textarea>
									</div>

								</div>

								<span class="alert" id="locationAlert"><br>카테고리를
									선택해주세요.</span>
							</div>
						</div>
					</div>
					<div class="body section4 arrayflex margin20">
						<div class="subtitle">동행자인원</div>
						<div class="choice arrayflex">
							<div class="con-name">최대인원</div>
							<div class="__count_range btn-group">
								<input type="text" class="count" value="1" readonly="readonly">
								<input value="▼" count_range="m" type="button"
									class="btn btn-secondary"> <input value="▲"
									count_range="p" type="button" class="btn btn-secondary">
								<span class="alert" id="countAlert">&emsp;최대인원은 10명까지
									입니다.</span>
							</div>

						</div>
					</div>
					<div class="body section5 margin20">
						<div class="sec period arrayflex">
							<div class="subtitle">여행 기간</div>
							<div class="text">
								<div class="startAndEnd arrayflex">
									<label>여행 시작일<input type="date" class="form-control"
										id="date1" required="required"></label>&emsp;~&emsp; <label>여행
										종료일<input type="date" class="form-control" id="date2"
										required="required">
									</label>
									<button type="button" class="btn btn-warning">중복검사</button>
									
								</div>
							</div>
						</div>
					</div>
					<hr />
					<div class="body section6 margin20">
						<div class="sec insert">
							<div class="subtitle">여행지 추가</div>
							<div class="step">
								step 1. <br> <i class="fas fa-trash"></i>
							</div>
							<div class="insertform">
								<div class="insert-address">
									<div class="smtitle">주소입력</div>
									<div class="input-group-prepend">
										<input type="text" placeholder="검색을 눌러 검색해주세요" name="addr"
											id="addr0" class="form-control" readonly="readonly">
										<button type="button" class="btn btn-secondary"
											name="findaddr" id="findaddr0" onclick="openChild(this)">
											<i class="fa fa-search"></i>주소 검색
										</button>
										<input type="hidden" name="lon" id="lon0"> <input
											type="hidden" name="lat" id="lat0">
									</div>
								</div>
								<div class="insert-explanation arrayflex">
									<div class="smtitle">설명</div>
									<div class="exp-form">
										<textarea rows="8" class="form-control noresize"
											placeholder="내용을 입력해주세요."></textarea>
									</div>

								</div>
								<div class="insert-icons">
									<button type="button" class="traffic btn btn-outline-secondary">
										<i class="fa fa-car"></i> 교통수단
									</button>
									<button type="button" class="pay btn btn-outline-secondary">
										<i class="fas fa-won-sign"></i> 비용
									</button>
									<button type="button" class="time btn btn-outline-secondary">
										<i class="fas fa-stopwatch"></i> 소요시간
									</button>
									<button type="button" class="else btn btn-outline-secondary">
										<i class="fas fa-calendar-check"></i> 기타
									</button>
								</div>
								<div class="insert-cons details"></div>
							</div>
						</div>
					</div>
					<hr />
					<div class="body section7 margin20">
						<div class="moreInfBox">
							<button type="button" class="moreInf btn btn-info" id="moreInf">
								<i class="fa fa-plus"></i> 항목 추가
							</button>
						</div>

						<div class="submitButton">
							<button class="btn btn-primary" type="submit" id="temp">임시
								저장</button>
							<button class="btn btn-success" type="submit" id="upload">모집
								시작</button>
						</div>
					</div>
				</div>
				<!-- </form> -->
			</div>
			<!--------------------------------------------------- content -------------------------------------------------->
			<div class="blank col-md-1"></div>
		</div>
		<div class="row footer">
			<div class="blank col-md-1"></div>
			<div class="content col-md-12">
				<c:import url="/WEB-INF/tiles/layout/footer.jsp">
				</c:import>
				<%-- <tiles:insertAttribute name="footer" /> --%>
			</div>
			<div class="blank col-md-1"></div>
		</div>


	</div>
</body>
</html>