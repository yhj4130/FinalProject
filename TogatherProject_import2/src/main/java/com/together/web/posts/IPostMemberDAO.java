package com.together.web.posts;

import java.util.ArrayList;

public interface IPostMemberDAO {
	
	// 본인이 등록한 travle 현황 조회
	public ArrayList<TravelDTO> travelLists(int sessionId);
	
	// 본인이 참가한 travle 현황 조회
	public ArrayList<MemberDTO> memberLists(int sessionId);

}
