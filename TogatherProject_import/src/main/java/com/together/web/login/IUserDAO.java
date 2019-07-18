package com.together.web.login;

import java.util.ArrayList;
import java.util.Map;

public interface IUserDAO {
	
	// 로그인
	public int login(UserDTO dto);
	
	// 회원가입
	public int checkId(String userId);
	public int checkNickname(UserDTO dto);
	public int checkEmail(UserDTO dto);
	public int add(UserDTO dto);
	public int addUthema(Map<String, Integer> map);
	public int checkNickname(String nickName);
	public int checkEmail(String email);
	public int searchUserCode(UserDTO dto);
	
	// 아이디찾기
	public int searchId(UserDTO dto);
	public String searchUserId(UserDTO dto);
	
	// 비밀번호 찾기
	public int searchPw(UserDTO dto);
	
	// 회원정보 수정
	public int pwsearchEdit(String userPw);
	public UserDTO userInfo(int userCode);
	public ArrayList<Integer> userThema(int userCode);
	public int checkNicknameEdit(UserDTO dto);
	public int checkEmailEdit(UserDTO dto);
	public int edit(UserDTO dto);
	public int deleteUThema(UserDTO dto);
	
	// 회원 탈퇴
	public int exit(UserDTO dto);	// 딸린 게시물 다 삭제로 할건지 
}