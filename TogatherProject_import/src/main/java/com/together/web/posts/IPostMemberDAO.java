package com.together.web.posts;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IPostMemberDAO {
	//0) 임시게시물 갯수 조회	
	public int countTemp(int userCode);
	
	// 1) TEMP_TRAVEL 테이블에 기본정보 인서트
	/* public int addTemp_travel(Map<String, Object> map ); */
	public int addTemp_travel(TempDTO dto);
	//2) temp_code 조회
	public int tempcode_Search(TempDTO dto);
	
	//3)tThema 삽입
	public void addtThema(Map<String,Integer> themacode);
	
	//4) 지역코드조회
	//public ArrayList<String> regionCode(Map<String, String> regioncode);
	
	//5) tp_region 테이블 삽입

	public int tp_Region(RegionDTO dto);
	
	// 본인이 작가인지 
	public int isWriterCode(int userCode);
	
	// 작가 테이블에 추가
	public int writerInsert(int userCode);
	
	// 작가 코드 찾기
	public int writerCodeSearch(int userCode);
	
	// 임시게시물 코드 찾기
	public int searchTempCode(TempDTO dto);
	
	// 임시 게시물 내용 가져오기
	public TempDTO tempInfo(int tempCode);
	
	// 게시물 업로드
	public int travelInsert(TempDTO dto);
}
