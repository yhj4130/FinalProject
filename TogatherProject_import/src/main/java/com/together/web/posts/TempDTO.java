package com.together.web.posts;



import lombok.Data;


public class TempDTO {

	
	private int travelCode,userCode, tempCode, writerCode, genderCode, peopleNum, viewNum, ageCode;
	private String t_Start, t_End,savedName;
	private String title, intro, img;
	private int[] themaCode,regionCode;
	private String[] city, lon, lat, placename, vehicle, r_Cost, r_Time, etc, r_Comment;
	public int getTravelCode() {
		return travelCode;
	}
	public void setTravelCode(int travelCode) {
		this.travelCode = travelCode;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getTempCode() {
		return tempCode;
	}
	public void setTempCode(int tempCode) {
		this.tempCode = tempCode;
	}
	public int getWriterCode() {
		return writerCode;
	}
	public void setWriterCode(int writerCode) {
		this.writerCode = writerCode;
	}
	public int getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(int genderCode) {
		this.genderCode = genderCode;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	public int getAgeCode() {
		return ageCode;
	}
	public void setAgeCode(int ageCode) {
		this.ageCode = ageCode;
	}
	public String getT_Start() {
		return t_Start;
	}
	public void setT_Start(String t_Start) {
		this.t_Start = t_Start;
	}
	public String getT_End() {
		return t_End;
	}
	public void setT_End(String t_End) {
		this.t_End = t_End;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int[] getThemaCode() {
		return themaCode;
	}
	public void setThemaCode(int[] themaCode) {
		this.themaCode = themaCode;
	}
	public String[] getCity() {
		return city;
	}
	public void setCity(String[] city) {
		this.city = city;
	}
	public String[] getLon() {
		return lon;
	}
	public void setLon(String[] lon) {
		this.lon = lon;
	}
	public String[] getLat() {
		return lat;
	}
	public void setLat(String[] lat) {
		this.lat = lat;
	}
	public String[] getPlacename() {
		return placename;
	}
	public void setPlacename(String[] placename) {
		this.placename = placename;
	}
	public String[] getVehicle() {
		return vehicle;
	}
	public void setVehicle(String[] vehicle) {
		this.vehicle = vehicle;
	}
	public String[] getR_Cost() {
		return r_Cost;
	}
	public void setR_Cost(String[] r_Cost) {
		this.r_Cost = r_Cost;
	}
	public String[] getR_Time() {
		return r_Time;
	}
	public void setR_Time(String[] r_Time) {
		this.r_Time = r_Time;
	}
	public String[] getEtc() {
		return etc;
	}
	public void setEtc(String[] etc) {
		this.etc = etc;
	}
	public String[] getR_Comment() {
		return r_Comment;
	}
	public void setR_Comment(String[] r_Comment) {
		this.r_Comment = r_Comment;
	}
	public int[] getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(int[] regionCode) {
		this.regionCode = regionCode;
	}
	
	
	
	
	
}
