/**
 * 
 */
var map, markerLayer;
const appKey = "55b7752b-1fe5-4ee9-9b9c-0474cb716aef";
var ckLon, ckLat;
if (document.addEventListener) {
	document.addEventListener("DOMContentLoaded", function() {
		document.removeEventListener("DOMContentLoaded", arguments.callee,
				false);
		domReady();
	}, false);
} // Internet Explorer
else if (document.attachEvent) {
	document.attachEvent("onreadystatechange", function() {
		if (document.readyState === "complete") {
			document.detachEvent("onreadystatechange", arguments.callee);
			domReady();
		}
	});
}

function domReady () { //처리할 내용 }
	
	initTmap();

}


function setVariables() {
	/* zoom level */
	zoom = 16;
}

function initTmap() {
	// map 생성
	// Tmap.map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
	
	var count = $(".map").length;
	for (var i = 0; i < count.length; i++) {
		
		var mapid =['map_div','map_div2'];
	
	map[i] = new Tmap.Map({
		div : mapid[i], // map을 표시해줄 div
		width : "650px",
		height : "452px",
	});

	map[i].setCenter(new Tmap.LonLat("126.986072", "37.570028").transform(
			"EPSG:4326", "EPSG:3857"), 15);
	markers = new Tmap.Layer.Markers( "MarkerLayer" );
	map[i].addLayer(markers);
	
	}
	
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