
var map,markerLayer;
const appKey = "55b7752b-1fe5-4ee9-9b9c-0474cb716aef";
var ckLon,ckLat;
$(document).ready(function() {
	initTmap();

});

function setVariables() {
	/* zoom level */
	zoom = 16;
}

function initTmap() {
	// map 생성
	// Tmap.map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
	map = new Tmap.Map({
		div : 'map_div', // map을 표시해줄 div
		width : "650px",
		height : "452px",
	});

	map.setCenter(new Tmap.LonLat("126.986072", "37.570028").transform(
			"EPSG:4326", "EPSG:3857"), 15);
	markers = new Tmap.Layer.Markers( "MarkerLayer" );
	map.addLayer(markers);

}

//지도의 위치가 변경되거나 움직였을 때 다시 처음의 위치로 돌아가는 함수입니다.
function Move(){
	var lonlat = new Tmap.LonLat(126.984895,37.566369).transform("EPSG:4326", "EPSG:3857");//좌표 설정
	map.setCenter(lonlat, 15);//map의 중심 좌표 설정
}

// 지정한 좌표값만큼 지도를 움직이게 할 수 있는 함수입니다.
function PanTo(){
	var lonlat = new Tmap.LonLat(126.976889, 37.571644).transform("EPSG:4326", "EPSG:3857");//좌표 설정
	map.panTo(lonlat);	//해당 좌표로 map을 부드럽게 이동
}

// 주소찾기 이벤트
function search(){

		var keyword = document.getElementById("searchKeyword").value;

		$.ajax({
			method:"GET",
			url:"https://api2.sktelecom.com/tmap/pois?version=1&format=xml&callback=result",// POI 통합검색 api 요청 url입니다.
			async:false,
			data:{
				"searchKeyword" : keyword,//검색 키워드
				"resCoordType" : "EPSG3857",//응답 좌표계 유형
				//검색타입
				//all:통합 검색
				//name:명칭 검색
				//telno:전화번호 검색
				"searchType" : "all",
				//거리순,정확도순 검색
				//A:정확도순
				//R:거리순
				"searchtypCd" : "A",
				"reqCoordType" : "WGS84GEO",//요청 좌표계 유형
				"multiPoint" : "N",
				"appKey" : appKey,// 실행을 위한 키입니다. 발급받으신 AppKey(서버키)를 입력하세요.
				"count" : 10//페이지당 출력되는 개수를 지정
			},
			//데이터 로드가 성공적으로 완료되었을 때 발생하는 함수입니다.
			success:function(response){
				prtcl = response;

				// 2. 기존 마커, 팝업 제거
				if(markerLayer != null) {
					markerLayer.clearMarkers();
					map.removeAllPopup();
				}

				// 3. POI 마커 표시
				markerLayer = new Tmap.Layer.Markers();//마커 레이어 생성
				map.addLayer(markerLayer);//map에 마커 레이어 추가
				var size = new Tmap.Size(24, 38);//아이콘 크기 설정
				var offset = new Tmap.Pixel(-(size.w / 2), -(size.h));//아이콘 중심점 설정
				var maker;
				var popup;
				var prtclString = new XMLSerializer().serializeToString(prtcl);//xml to String
				xmlDoc = $.parseXML( prtclString ),
				$xml = $( xmlDoc ),
				$intRate = $xml.find("poi");
				var innerHtml ="";
				$intRate.each(function(index, element) {
				   	var name = element.getElementsByTagName("name")[0].childNodes[0].nodeValue;
				   	var id = element.getElementsByTagName("id")[0].childNodes[0].nodeValue;
				   	var content ="<div style=' position: relative; border-bottom: 1px solid #dcdcdc; line-height: 18px; padding: 0 35px 2px 0;'>"+
								    "<div style='font-size: 12px; line-height: 15px;'>"+
								        "<span style='display: inline-block; width: 14px; height: 14px; background-image: url(/resources/images/common/icon_blet.png); vertical-align: middle; margin-right: 5px;'></span>"+name+
								    "</div>"+
								 "</div>";
				   	innerHtml+="<div class='val result"+index+"'><img src='http://tmapapis.sktelecom.com/upload/tmap/marker/pin_b_m_"+index+".png' style='vertical-align:middle'/><span id='name'>"+name+"</span>";
					var lon = element.getElementsByTagName("noorLon")[0].childNodes[0].nodeValue;
					var lat = element.getElementsByTagName("noorLat")[0].childNodes[0].nodeValue;

					var icon = new Tmap.Icon('http://tmapapis.sktelecom.com/upload/tmap/marker/pin_b_m_'+index+'.png',size, offset);//마커 아이콘 설정
					var lonlat = new Tmap.LonLat(lon, lat);//좌표설정
						innerHtml+="<span id='lon'>"+ lon+ "</span><span id='lat'>"+lat+"</span></div>";
					marker = new Tmap.Marker(lonlat, icon);//마커생성
					markerLayer.addMarker(marker);//마커레이어에 마커 추가

					popup = new Tmap.Popup("p1", lonlat, new Tmap.Size(120, 50), content, false);//마우스 오버 팝업
					popup.autoSize = true;//Contents 내용에 맞게 Popup창의 크기를 재조정할지 여부를 결정
					map.addPopup(popup);//map에 popup추가
					popup.hide();//마커에 마우스가 오버되기 전까진 popup을 숨김
					//마커 이벤트등록
				    marker.events.register("mouseover", popup, onOverMarker);
				    //마커에 마우스가 오버되었을 때 발생하는 이벤트 함수입니다.
				    function onOverMarker(evt) {
				      this.show(); //마커에 마우스가 오버되었을 때 팝업이 보입니다.
				    }
				    //마커 이벤트 등록
				    marker.events.register("mouseout", popup, onOutMarker);
				    //마커에 마우스가 아웃되었을 때 발생하는 함수입니다.
				    function onOutMarker(evt) {
				      this.hide(); //마커에 마우스가 없을땐 팝업이 숨겨집니다.
				    }



			   });
			$("#searchResult").html(innerHtml);
			
			

			$('.val').click(function(){
				ckLon= $(this).children('#lon').text();
				ckLat= $(this).children('#lat').text();
				$('.val').css("background-color","white");
				$(this).css("background-color","#bbc2ca");
			/* alert(ckLon+"/"+ckLat);*/
			 
			 	$('.btn-success').click(function(){
			 		sendDate();			 		
			 	});
			 
			// this.show();

			});

				map.zoomToExtent(markerLayer.getDataExtent());//마커레이어의 영역에 맞게 map을 zoom합니다.
			},
			//요청 실패시 콘솔창에서 에러 내용을 확인할 수 있습니다.
			error:function(request,status,error){
				console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
}

// 좌표 주소전환 함수
function reverseGeo(addr){
	$.ajax({
		method:"GET",
		url:"https://api2.sktelecom.com/tmap/geo/reversegeocoding?version=1&format=json&callback=result", // ReverseGeocoding api 요청 url입니다.
		async:false,
		data:{
			"coordType" : "EPSG3857", //지구 위의 위치를 나타내는 좌표 타입
			"addressType" : "A10",  // 주소 타입 입니다.
			"lon" : ckLon,
			"lat" : ckLat,
			"addressType": "A00",
			"appKey" : appKey, //실행을 위한 키 입니다. 발급받으신 AppKey(서버키)를 입력하세요.
		},
		//데이터 로드가 성공적으로 완료되었을 때 발생하는 함수입니다.
		success:function(response){
			prtcl = response;
			
			// 3. json에서 주소 파싱
			var arrResult = prtcl.addressInfo;
			
			//법정동 마지막 문자 
			var lastLegal = arrResult.legalDong.charAt(arrResult.legalDong.length-1);
			
			// 새주소
			newRoadAddr = arrResult.city_do + ' ' + arrResult.gu_gun + ' '; 
			
			if(arrResult.eup_myun == '' && (lastLegal=="읍"||lastLegal=="면")){//읍면
				newRoadAddr +=  arrResult.legalDong;	
			}else{
				newRoadAddr +=  arrResult.eup_myun;
			}
			newRoadAddr += ' ' +arrResult.roadName + ' ' + arrResult.buildingIndex;
			
			// 새주소 법정동& 건물명 체크
			if(arrResult.legalDong != '' && (lastLegal!="읍"&&lastLegal!="면")){//법정동과 읍면이 같은 경우
				
				if(arrResult.buildingName != ''){//빌딩명 존재하는 경우
					newRoadAddr +=  (' (' + arrResult.legalDong + ', ' +arrResult.buildingName +') ');
				}else{
					newRoadAddr += (' (' + arrResult.legalDong + ')');
				}
			}else if(arrResult.buildingName != ''){//빌딩명만 존재하는 경우
				newRoadAddr +=  (' (' + arrResult.buildingName +') ');
			}
			
			// 구주소
			jibunAddr = arrResult.city_do + ' ' + arrResult.gu_gun + ' ' + arrResult.legalDong + ' '+ arrResult.ri + ' ' + arrResult.bunji;
			//구주소 빌딩명 존재
			if(arrResult.buildingName != ''){//빌딩명만 존재하는 경우
				jibunAddr +=  (' '+arrResult.buildingName);
			}
			
			//주소 결과 
			
			/*result="새주소 : "+newRoadAddr+"</br>";*/
			result=jibunAddr; 
			/*result+="위경도좌표 : "+lat+", "+lon;*/
			
			/*var resultDiv = document.getElementById("result");//결과를 출력할 태그를 찾습니다.
			resultDiv.innerHTML = result;//결과를 html에 출력합니다.*/	
			opener.document.getElementById(addr).value=result;
			},
		//요청 실패시 콘솔창에서 에러 내용을 확인할 수 있습니다.
		error:function(request,status,error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
}


// 좌표 및 주소 전달함수
function sendDate(){
	var lonName =getParam("lonName");
	var latName =getParam("latName");
	var addr =getParam("addr");
	/*var latName =$("#latName").val();*/

	
	opener.document.getElementById(latName).value = ckLat;
	opener.document.getElementById(lonName).value = ckLon;
	reverseGeo(addr);
	window.close();

}

// 파라미터 값 추출 함수
function getParam(pname) {

    var params = location.search.substr(location.search.indexOf("?") + 1);

    var sval = "";

    params = params.split("&");

    for (var i = 0; i < params.length; i++) {

        temp = params[i].split("=");

        if ([temp[0]] == pname) { sval = temp[1]; }

    }

    return sval;

}




