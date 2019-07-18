var num = 0;

$(document)
		.ready(
				function() {

					$("#files").on('change', function() {
						readURL(this);
					});
					
					$(".car.arrayflex").css('display','none');
					$(".won-sign.arrayflex").css('display','none');
					$(".stopwatch.arrayflex").css('display','none');
					$(".calendar.arrayflex").css('display','none');

					$('.__count_range input[count_range]').click(function(e) {
						e.preventDefault();
						var type = $(this).attr('count_range');
						var $count = $(this).parent().children('input.count');
						var count_val = $count.val();
						if (type == 'm') {
							if (count_val < 2) {
								return;
							}
							$count.val(parseInt(count_val) - 1);
							$('#countAlert').hide();
						} else if (type == 'p') {
							if (count_val > 9) {
								$('#countAlert').show();
								return;
							}
							$count.val(parseInt(count_val) + 1);
							$('#countAlert').hide();
						}
					});

					$('input:checkbox[name=themaCode]').change(
							function() {
								if ($(this).is(':checked')) {
									$(this).parent('label.b1').css('color',
											'#21bf34;');
								} else {
									$(this).parent('label').css('color',
											'#848484');
								}
								/* alert("하핫"); */
							});
					$('input:radio[name=ageCode]').change(
							function() {
								if ($(this).is(':checked')) {
									$('input:radio[name=ageCode]').parent('label')
											.css('color', '#848484');
									$(this).parent('label').css('color',
											'#21bf34');
								}

							});

					$('input:radio[name=genderCode]').on(
							'click',
							function() {
								if ($(this).is(':checked')) {
									$('input:radio[name=genderCode]').parent(
											'label').css('color', '#848484');
									$(this).parent('label').css('color',
											'#21bf34');
								}
							});
					
					// 업로드시 체크사항
					$('#upload').on('click',function() {
						/*debugger;*/

										if ($('#subject').val() == ""
												|| $('#subject').val().length > 30) {
											alert("제목을 30자이내로 입력하세요.");
											$("#subject").focus();
											

										} else if ($("input:checkbox[name='themaCode']").is(":checked") != true) {
											alert("카테고리를 선택해주세요");
											$("input:check[name='themaCode']").focus();
										} else if ($("input:radio[name='ageCode']")
												.is(":checked") != true) {
											alert("연령을 선택해주세요");
											$("input:radio[name='ageCode']").focus();
										} else if ($(
												"input:radio[name='genderCode']").is(":checked") != true) {
											alert("성별을 선택해주세요");
											$("input:radio[name='genderCode']")
													.focus();
										} else if (!document
												.getElementById('date1').value) {
											alert("여행시작일을 선택해주세요");
											$(".date1").focus();

										} else if (!document
												.getElementById('date2').value) {
											alert("여행종료일을 선택해주세요");
											$(".date2").focus();

										} else {
											var count = $("div.sec.insert").length;
											
											if (count == 1&& ($("div.sec.insert").eq(0).find("input:text[name='placename']").val() == "")) {

												alert("여행지는 최소 한개는 작성하셔야 합니다. 주소검색을 실행하세요");
												$("div.sec.insert").eq(0).find("input:text[name='placename']").focus();
												return;
											
											} else if (count > 1) {

												for (var i = 0; i < count; i++) {

													if ($("div.sec.insert").eq(i).find("input:text[name='placename']").val() == "") {

														alert("주소검색을 실행하세요.");
														$("div.sec.insert")
																.eq(i)
																.find("input:text[name='placename']")
																.focus();
														return;
													}
												}
											} 
											
											$.post("countTemp.do",
														 function(count)
														{
													if (count>5) {
														alert("임시게시물이 5개 이상입니다.마이페이지에서 확인해주세요.")
														return;														
													}else{
														document.getElementById("frm").action="upload.do";
														
														document.getElementById("frm").submit();		
													}
												});
												 
											}
									
									});
					
					// 임시게시물 체크사항
					$('#temp').on('click',function() {
						/*debugger;*/

										if ($('#subject').val() == ""
												|| $('#subject').val().length > 30) {
											alert("제목을 30자이내로 입력하세요.");
											$("#subject").focus();
											

										} else if ($("input:checkbox[name='themaCode']").is(":checked") != true) {
											alert("카테고리를 선택해주세요");
											$("input:check[name='themaCode']").focus();
										} else if ($("input:radio[name='ageCode']")
												.is(":checked") != true) {
											alert("연령을 선택해주세요");
											$("input:radio[name='ageCode']").focus();
										} else if ($(
												"input:radio[name='genderCode']").is(":checked") != true) {
											alert("성별을 선택해주세요");
											$("input:radio[name='genderCode']")
													.focus();
										} else if (!document
												.getElementById('date1').value) {
											alert("여행시작일을 선택해주세요");
											$(".date1").focus();

										} else if (!document
												.getElementById('date2').value) {
											alert("여행종료일을 선택해주세요");
											$(".date2").focus();

										} else {
											var count = $("div.sec.insert").length;
											
											if (count == 1&& ($("div.sec.insert").eq(0).find("input:text[name='placename']").val() == "")) {

												alert("여행지는 최소 한개는 작성하셔야 합니다. 주소검색을 실행하세요");
												$("div.sec.insert").eq(0).find("input:text[name='placename']").focus();
												return;
											
											} else if (count > 1) {

												for (var i = 0; i < count; i++) {

													if ($("div.sec.insert").eq(i).find("input:text[name='placename']").val() == "") {

														alert("주소검색을 실행하세요.");
														$("div.sec.insert")
																.eq(i)
																.find("input:text[name='placename']")
																.focus();
														return;
													}
												}
											} 
											
											$.post("countTemp.do",
														 function(count)
														{
													if (count>5) {
														alert("임시게시물이 5개 이상입니다.마이페이지에서 확인해주세요.")
														return;														
													}else{
														document.getElementById("frm").action="tempupload.do";
														
														document.getElementById("frm").submit();		
													}
												});
												 
											}
									
									});

					// 여행지 추가 이벤트
					$('#moreInf')
					.click(
							function() {

								num++;

								$('.body.section6.margin20')
										.append(
												"<div class='sec insert'>"
														+ "<div class='subtitle'></div>"
														+ "<div class='step'>step "
														+ (num + 1)
														+ ".<br><i class='fas fa-trash'></i></div>"
														+ "<div class='insertform'>"
														+ "<div class='insert-address'>"
														+ "<div class='smtitle'>주소입력</div>"
														+ "<div class='input-group-prepend'>"
														+ "<input type='text' name='placename' placeholder='검색을 눌러 검색해주세요'"
														+ "id='addr"
														+ num
														+ "' class='form-control' readonly='readonly'>"
														+ "<button type='button' class='btn btn-secondary' name='findaddr' id='findaddr"
														+ num
														+ "' onclick='openChild(this)'>"
														+ "<i class='fa fa-search'></i>주소 검색"
														+ "</button>"
														+ "<input type='hidden' name='lon' id ='lon"
														+ num
														+ "'>"
														+ "<input type='hidden' name='lat' id ='lat"
														+ num
														+ "'>"
														+ "</div>"
														+ "</div>"
														+ "<div class='insert-explanation arrayflex'>"
														+ "<div class='smtitle'>설명</div>"
														+ "<div class='exp-form'>"
														+ "<textarea rows='8' name='r_Comment' class='form-control noresize'"
														+ "placeholder='내용을 입력해주세요.'></textarea>"
														+ "</div>"
														+ "</div>"
														+ "<div class='insert-icons'>"
														+ "<button type='button' "
														+ "class='traffic btn btn-outline-secondary'>"
														+ "<i class='fa fa-car'></i> 교통수단"
														+ "</button>"
														+ "<button type='button' class='pay btn btn-outline-secondary'>"
														+ "<i class='fas fa-won-sign'></i> 비용"
														+ "</button>"
														+ "<button type='button' class='time btn btn-outline-secondary'>"
														+ "<i class='fas fa-stopwatch'></i> 소요시간"
														+ "</button>"
														+ "<button type='button' class='else btn btn-outline-secondary'>"
														+ "<i class='fas fa-calendar-check'></i> 기타"
														+ "</button>"
														+ "</div>"
														+ "<div class='insert-cons details'>" 
																+"<div class='car arrayflex' style='display:none;'>"
																+"<i class='faStyle fa fa-car fa-2x'></i>" 
																+"<input type=text class='form-control'  name ='vehicle' id='traffic' style='width: 500px'>"
																+"<i class='fas fa-eraser'></i>"
																+"</div>"
																
														+"<div class='won-sign arrayflex' style='display:none;'>" 
														+"<i class='faStyle fa fa-won-sign fa-2x'></i> "
														+"<input type=text class='form-control' id='pay' name='r_Cost'style='width: 500px'>" 
														+"<i class='fas fa-eraser'></i>" 
														+"</div>" 
														
														
														+"<div class='stopwatch arrayflex' style='display:none;'>" 
														+"<i class='faStyle fa fa-stopwatch fa-2x' ></i> " 
														+"<input type=text class='form-control' id='time' name='r_Time' style='width: 500px'>" 
														+"<i class='fas fa-eraser'></i>"
														+"</div>" 
														
														+"<div class='calendar arrayflex' style='display:none;'>" 
														+"<i class='faStyle fa fa-calendar-check fa-2x' ></i> "
														+"<input type=text class='form-control' id='else' name='etc' style='width: 500px'>" 
														+" <i class='fas fa-eraser'></i>" 
														+"</div>" 
														
														+ "</div>"
														+ "</div></div>");

							});
					/* 여행지 삭제 마우스 관련 이벤트 */
					$(document).on("mouseover", ".sec.insert", function() {
						$(this).find('.fas.fa-trash').css("display", "block");

					});
					$(document).on("mouseleave", ".sec.insert", function() {
						$(this).find('.fas.fa-trash').css("display", "none");
					});

					// 여행지삭제 클릭시 이벤트
					$(document)
							.on(
									"click",
									".fas.fa-trash",
									function(e) {
										/* $(event.target).closest(".sec.insert").children().remove(); */

										var count = $("div.sec.insert").length;
										if (count <= 1) {
											alert("최소 1개의 여행지는 작성하셔야 합니다.");
										} else {
											$(e.target).closest(".sec.insert")
													.remove();
											count--;

											for (var i = 0; i < count; i++) {
												$("div.sec.insert")
														.eq(i)
														.find('.step')
														.html(
																"step "
																		+ (i + 1)
																		+ ".<br><i class='fas fa-trash'></i>");
												$("div.sec.insert").eq(i).find(
														'.input-group-prepend')
														.children(":text")
														.attr('id', 'addr' + i);
												$("div.sec.insert").eq(i).find(
														'.input-group-prepend')
														.children(":button")
														.attr('id',
																'findaddr' + i);
												$("div.sec.insert")
														.eq(i)
														.find(
																'.input-group-prepend')
														.children(
																"input[name=lat]")
														.attr('id', 'lat' + i);
												$("div.sec.insert")
														.eq(i)
														.find(
																'.input-group-prepend')
														.children(
																"input[name=lon]")
														.attr('id', 'lon' + i);
											}
											--num;
											$("div.sec.insert").eq(0).find(
													'.subtitle').text("여행지 추가");
										}

										/* alert(i); */
									});

					// 여행지 세부 사항 클릭시 이벤트
					//교통지
					$(document)
							.on(
									'click',
									'.traffic',
									function(e) {
										if ($(e.target).closest(".insertform")
												.find('.car.arrayflex').css("display") != "none") {

											alert("이미 추가하셨습니다. 추가한 목록에 작성해 주시기 바랍니다.");

										} else {

											/*$(e.target)
													.closest(".insertform")
													.children(
															'.insert-cons.details')
													.append(
															""
																	+ "<div class='car arrayflex'>"
																	+ "<i class='faStyle fa fa-car fa-2x'></i>"
																	+ "<input type=text class='form-control' id='traffic' style='width:500px'>"
																	+ " <i class='fas fa-eraser'></i>"
																	+ "</div>");*/
											
											$(e.target).closest(".insertform")
											.find('.car.arrayflex').css("display", "flex");

										}

									});
					// 비용
					$(document)
							.on(
									'click',
									'.pay',
									function(e) {
										
										/*if ($(e.target).closest(".insertform")
												.find('.won-sign.arrayflex').length > 0)*/
										if ($(e.target).closest(".insertform")
												.find('.won-sign.arrayflex').css("display") != "none") {

											alert("이미 추가하셨습니다. 추가한 목록에 작성해 주시기 바랍니다.");

										} else {

											/*$(e.target)
													.closest(".insertform")
													.children(
															'.insert-cons.details')
													.append(
															""
																	+ "<div class='won-sign arrayflex'>"
																	+ "<i class='faStyle fa fa-won-sign fa-2x'></i>"
																	+ "<input type=text class='form-control' id='pay' style='width:500px'>"
																	+ "<i class='fas fa-eraser'></i>"
																	+ "</div>");*/
											$(e.target).closest(".insertform")
											.find('.won-sign.arrayflex').css("display", "flex");


										}

									});
					//시간
					$(document)
							.on(
									'click',
									'.time',
									function(e) {
										if ($(e.target).closest(".insertform")
												.find('.stopwatch.arrayflex').css("display") != "none") {

											alert("이미 추가하셨습니다. 추가한 목록에 작성해 주시기 바랍니다.");

										} else {

											/*$(e.target)
													.closest(".insertform")
													.children(
															'.insert-cons.details')
													.append(
															"<div class='stopwatch arrayflex'>"
																	+ "<i class='faStyle fa fa-stopwatch fa-2x'></i>"
																	+ " <input type=text class='form-control' id='time' style='width:500px'>"
																	+ "<i class='fas fa-eraser'></i>"
																	+ "</div>");*/
											$(e.target).closest(".insertform")
											.find('.stopwatch.arrayflex').css("display", "flex");

										}

									});
					//기타사항
					$(document)
							.on(
									'click',
									'.else',
									function(e) {
										if ($(e.target).closest(".insertform")
												.find('.calendar.arrayflex').css("display") != "none") {

											alert("이미 추가하셨습니다. 추가한 목록에 작성해 주시기 바랍니다.");

										} else {

											/*$(e.target)
													.closest(".insertform")
													.children(
															'.insert-cons.details')
													.append(
															"<div class='calendar arrayflex'>"
																	+ "<i class='faStyle fa fa-calendar-check fa-2x'></i>"
																	+ "<input	type=text class='form-control' id='else' style='width:500px'>"
																	+ "<i class='fas fa-eraser'></i>"
																	+ "</div>");*/
											
											$(e.target).closest(".insertform")
											.find('.calendar.arrayflex').css("display", "flex");

										}

									});

					// 여행지 세부사항 삭제 이벤트

					$(document).on('click', '.fas.fa-eraser', function(e) {
						$(e.target).parent('div').css('display','none');

					});

					// 사진이 변경될 시에 이벤트
					$('input[type="file"]').on('change', function() {

						// 섬네일 스크립트
						readURL(this);
						// 삭제활성화
						$(".fa-trash-alt").css("display", "inline");
					});

					// 사진삭제버튼 숨김
					$(".fa-trash-alt").css("display", "none");

					// 사진삭제버튼 클릭시 이벤트
					$(".fa-trash-alt").click(function(e) {
						var $input = $("#files");
						var $preview = $('#blah');
						resetInputFile($input, $preview);
						$(this).css("display", "none");
					});

					// 캘린더 최소값 클릭시 이벤트
					$('#date1').click(function() {

						var today = new Date();
						today.setDate(today.getDate() + 14);

						// 여행 최소일자 설정
						if (!!today.valueOf()) {

							today = changeDate(today);
							$('#date1').attr('min', today);

						} else {
							// TODO
							alert("날짜를 잘못입력하셨습니다. 다시 선택해주세요.");
						}

					});

					// 캘린더 최소값 변경시 최대값 변경
					$('#date1').change(function(e) {
						var input = e.target.value;
						var min = new Date(input);
						min.setDate(min.getDate() + 1);
						if (!!min.valueOf()) {
							$('#date2').attr('min', changeDate(min));
						}

						var d = new Date(input);
						d.setMonth(d.getMonth() + 6);
						/* alert(d); */
						if (!!d.valueOf()) {
							date = changeDate(d);
							$('#date2').attr('max', date);
						}
					});
					
					$('.btn-warning').click(function(){
						
						$.ajax({
							url : "datecheck.do",
							type: "post",
							data : {'date1':date1,'date2':date2},
							success: function(count) {
								// 중복안됨
								if(count == 0)
								{
									alert("여행을 갈 수 있는 기간입니다.");
									/*document.getElementById("idCheck").value = "idCheck";	*/								
								}
								else
								{
									alert("여행을 갈 수 없는 기간입니다.");
									return false;
								}
							},
							error:function(request,status,error){
								console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});						
					});
				});

// 날짜 변환 함수
function changeDate(date) {

	year = date.getFullYear();
	month = date.getMonth() + 1;
	day = date.getDate();

	day < 10 && (day = "0" + day);
	month < 10 && (month = "0" + month);
	/* alert(day); */
	date = year + '-' + month + '-' + day;

	return date;
}

// 이미지 섬네일 세팅
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blah').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

// 이미지 섬네일 삭제
function resetInputFile($input, $blah) {
	var agent = navigator.userAgent.toLowerCase();
	if ((navigator.appName == 'Netscape' && navigator.userAgent
			.search('Trident') != -1)
			|| (agent.indexOf("msie") != -1)) {
		// ie 일때
		$input.replaceWith($input.clone(true));
		$('#blah').attr('src', '/web/resources/images/insertimg.png');
	} else {
		// other
		$input.val("");
		$('#blah').attr('src', '/web/resources/images/insertimg.png');
	}
}

// 주소검색창 오픈

function openChild(val) {
	// 부모창 이름
	window.name = "parentForm";
	var lonName = $(val).siblings("input[name=lon]").attr('id');
	var latName = $(val).siblings("input[name=lat]").attr('id');
	var addr = $(val).siblings("input[name=placename]").attr('id');
	// window.open("open할 window", "자식창 이름", "팝업창 옵션");
	var windowW = 700; // 창의 가로 길이
	var windowH = 700; // 창의 세로 길이
	var left = Math.ceil((window.screen.width - windowW) / 2);
	var top = Math.ceil((window.screen.height - windowH) / 2);
	window.open("addrSearchForm.do?lonName=" + lonName + "&latName=" + latName
			+ "&addr=" + addr, "childForm", "scrollbars = no,l top=" + top
			+ ", left=" + left + ", height=" + windowH + ", width=" + windowW);
}


