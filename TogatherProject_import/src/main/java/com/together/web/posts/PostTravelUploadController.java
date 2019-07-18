package com.together.web.posts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PostTravelUploadController {

	private static final Logger logger = LoggerFactory.getLogger(PostTravelUploadController.class);

	@Autowired
	private SqlSession sqlSession;

	@Resource(name = "uploadPath")
	String uploadPath;

	// 여행게시물 업로드
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String uploadForm(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session, HttpServletRequest request, TempDTO dto) throws Exception {

		IPostMemberDAO dao = sqlSession.getMapper(IPostMemberDAO.class);
		
		if(session.getAttribute("sessionId")==null)
		{
			return "login/Login";
		}
		else
		{
			int userCode = (int) session.getAttribute("sessionId");
	
			/* 1) 사진 서버 저장 및 경로 따오기 */
			// 파일의 원본이름 저장
			String savedName = "";
			if (file.isEmpty()) {
				// 값이 없는 경우 처리
				savedName = "default.jsp";
			} else {
				// 값이 있는 경우 처리 // 랜덤생성+파일이름 저장 // 파일명 랜덤생성메서드호출
				savedName = file.getOriginalFilename();
				savedName = uploadFile(savedName, file.getBytes());
			}
			logger.info("파일이름 :" + savedName);
			logger.info("파일이름 :" + file.getOriginalFilename());
			logger.info("파일크기 : " + file.getSize());
			logger.info("컨텐트 타입 : " + file.getContentType());
	
	
			/* 3)임시보관함테이블insert */
			dto.setSavedName(savedName);
			dto.setUserCode(userCode);
			
			dao.addTemp_travel(dto);
	
			int tempCode = dao.tempcode_Search(dto);
			logger.info(Integer.toString(tempCode));
	
			/* 4) 테마 insert */
			Map<String, Integer> themacode = new HashMap<String, Integer>();
			
			for (int themaCode : dto.getThemaCode()) {
				logger.info(Integer.toString(themaCode));
				themacode.put("tempCode", tempCode);
				themacode.put("themaCode", themaCode);
				//테마 삽입			
				dao.addtThema(themacode);
			}
	
			ArrayList<String> lonList = new ArrayList<String>();
			ArrayList<String> latList = new ArrayList<String>();
			ArrayList<String> placeNameList = new ArrayList<String>();
			ArrayList<String> vehicleList = new ArrayList<String>();
			ArrayList<String> r_CostList = new ArrayList<String>();
			ArrayList<String> r_TimeList = new ArrayList<String>();
			ArrayList<String> etcList = new ArrayList<String>();
			ArrayList<String> r_CommentList = new ArrayList<String>();
			ArrayList<String> regionList = new ArrayList<String>();
			
			// 임시게시물 코드 && 위도
			for (String lon : dto.getLon()) {
				lonList.add(lon);
			}
			// 경도
			for (String lat : dto.getLat()) {
				latList.add(lat);
				
			}
			// 자동차
			for (String vehicle : dto.getVehicle()) {
				
				if(vehicle.equals(""))
					vehicle = "　";
				vehicleList.add(vehicle);
			}
			// 비용
			for (String r_Cost : dto.getR_Cost()) {
				
				if(r_Cost.equals(""))
					r_Cost = " ";
				r_CostList.add(r_Cost);
			}
			// 시간
			for (String r_Time : dto.getR_Time()) {
				
				if(r_Time.equals(""))
					r_Time = " ";
				r_TimeList.add(r_Time);
			}
			// 기타
			for (String etc : dto.getEtc()) {
				
				if(etc.equals(""))
					etc = " ";
				etcList.add(etc);
			}
			// 코멘트
			for (String r_Comment : dto.getR_Comment()) {
				
				if(r_Comment.equals(""))
					r_Comment = " ";
				r_CommentList.add(r_Comment);
			}
			// 주소
			for (String placename : dto.getPlacename()) {
				placeNameList.add(placename);
			}
	
			/* (1) 주소변환 */
			String[] place = request.getParameterValues("placename");
			
			String[] city = new String[place.length];
			
			for (int i = 0; i < place.length; i++) {
	
				String[] array = place[i].split("\\s");
	
				if (array[0].equals("서울특별시")) {
					regionList.add("서울");
					
					city[i] = "서울시";
				} else if (array[0].equals("경기도")) {
	
					regionList.add("경기");
					city[i] = array[1];
				} else if (array[0].equals("인천광역시")) {
	
					regionList.add("인천");
					city[i] = "인천시";
				} else if (array[0].equals("제주특별자치도")) {
	
					regionList.add("제주");
					city[i] =  array[1];
				} else if (array[0].equals("대전광역시")) {
	
					regionList.add("대전");
					city[i] = "대전시";
				} else if (array[0].equals("충청북도")) {
	
					regionList.add("충북");
					city[i] = array[1];
				} else if (array[0].equals("충청남도")) {
					regionList.add("충남/세종");
					city[i] = array[1];
				} else if (array[0].equals("울산광역시")) {
					regionList.add("울산");
					city[i] = "울산시";
				} else if (array[0].equals("부산광역시")) {
					regionList.add("부산");
					city[i] = "부산시";
				} else if (array[0].equals("경상남도")) {
					regionList.add("경남");
					city[i] = array[1];
				} else if (array[0].equals("대구광역시")) {
					regionList.add("대구");
					city[i] = "대구시";
				} else if (array[0].equals("경상북도")) {
					regionList.add("경북");
					city[i] = array[1];
				} else if (array[0].equals("광주광역시")) {
					regionList.add("광주");
					city[i] = "광주시";
				} else if (array[0].equals("전라남도")) {
					regionList.add("전남");
					city[i] = array[1];
				} else if (array[0].equals("세종특별자치시")) {
					regionList.add("충남/세종");
					city[i] = "세종시";
				} else {
					regionList.add("전북");
					city[i] = array[1];
				}
			}		
				
			RegionDTO r_dto = new RegionDTO();
			r_dto.setTempCode(tempCode);
					
			// TP_REGION에 저장
			for (int j=0; j<place.length; j++) {			
				r_dto.setLon(lonList.get(j));
				r_dto.setLat(latList.get(j));
				r_dto.setPlaceName(placeNameList.get(j));
				r_dto.setVehicle(vehicleList.get(j));
				r_dto.setR_Cost(r_CostList.get(j));
				r_dto.setR_Time(r_TimeList.get(j));
				r_dto.setEtc(etcList.get(j));
				r_dto.setR_Comment(r_CommentList.get(j));
				r_dto.setCity(city[j]);
				r_dto.setRegion(regionList.get(j));	
				
				dao.tp_Region(r_dto);			
			}
			
			// 작가인지 아닌지 1-작가임 0-작가아님
			int result = dao.isWriterCode(userCode);
			
			if(result == 0)	// 작가 테이블에 추가
				dao.writerInsert(userCode);
			
			TempDTO insert = new TempDTO();
			
			// 템프 코드 가져오기
			dto.setUserCode(userCode);
			int searchTempCode = dao.searchTempCode(dto);
			
			System.out.println(searchTempCode);
			System.out.println(userCode+"***");
			
			insert = dao.tempInfo(searchTempCode);
			insert.setWriterCode(dao.writerCodeSearch(userCode));
			
			dao.travelInsert(insert);
			
			
			
			
			
			

			
			
			
			
			
			
			
			
			
			
			
			
	
			return "posts/WriteTempSuccess";
		}
	}

	// 파일명 랜덤생성 메서드
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
		UUID uuid = UUID.randomUUID();
		// 랜덤생성+파일이름 저장
		String savedName = uuid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		// 임시디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사
		// FileCopyUtils.copy(바이트배열, 파일객체)
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	
		
	
	

}
