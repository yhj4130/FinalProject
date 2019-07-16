package com.together.web.posts;

public class MemberDTO {
	private int membercode, travelcode, t_levelcode, usercode, pick_typecode, ready_typecode;
	private String m_comment, regist_date, pick_date, ready_date;

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

	public int getTravelcode() {
		return travelcode;
	}

	public void setTravelcode(int travelcode) {
		this.travelcode = travelcode;
	}

	public int getT_levelcode() {
		return t_levelcode;
	}

	public void setT_levelcode(int t_levelcode) {
		this.t_levelcode = t_levelcode;
	}

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	public int getPick_typecode() {
		return pick_typecode;
	}

	public void setPick_typecode(int pick_typecode) {
		this.pick_typecode = pick_typecode;
	}

	public int getReady_typecode() {
		return ready_typecode;
	}

	public void setReady_typecode(int ready_typecode) {
		this.ready_typecode = ready_typecode;
	}

	public String getM_comment() {
		return m_comment;
	}

	public void setM_comment(String m_comment) {
		this.m_comment = m_comment;
	}

	public String getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}

	public String getPick_date() {
		return pick_date;
	}

	public void setPick_date(String pick_date) {
		this.pick_date = pick_date;
	}

	public String getReady_date() {
		return ready_date;
	}

	public void setReady_date(String ready_date) {
		this.ready_date = ready_date;
	}

}
