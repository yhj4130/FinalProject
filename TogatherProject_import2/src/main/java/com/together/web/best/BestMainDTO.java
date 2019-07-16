package com.together.web.best;

import java.util.ArrayList;

public class BestMainDTO
{
	int travelCode;

	String recruit_End, t_Start, t_End, title, nickName
		 , city_Start, city_End, region_Start, region_End, img;

	ArrayList<String> themaType;
	
	// getter / setter
	public int getTravelCode()
	{
		return travelCode;
	}

	public void setTravelCode(int travelCode)
	{
		this.travelCode = travelCode;
	}

	public String getRecruit_End()
	{
		return recruit_End;
	}

	public void setRecruit_End(String recruit_End)
	{
		this.recruit_End = recruit_End;
	}

	public String getT_Start()
	{
		return t_Start;
	}

	public void setT_Start(String t_Start)
	{
		this.t_Start = t_Start;
	}

	public String getT_End()
	{
		return t_End;
	}

	public void setT_End(String t_End)
	{
		this.t_End = t_End;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getCity_Start()
	{
		return city_Start;
	}

	public void setCity_Start(String city_Start)
	{
		this.city_Start = city_Start;
	}

	public String getCity_End()
	{
		return city_End;
	}

	public void setCity_End(String city_End)
	{
		this.city_End = city_End;
	}

	public String getRegion_Start()
	{
		return region_Start;
	}

	public void setRegion_Start(String region_Start)
	{
		this.region_Start = region_Start;
	}

	public String getRegion_End()
	{
		return region_End;
	}

	public void setRegion_End(String region_End)
	{
		this.region_End = region_End;
	}

	public String getImg()
	{
		return img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	public ArrayList<String> getThemaType()
	{
		return themaType;
	}

	public void setThemaType(ArrayList<String> themaType)
	{
		this.themaType = themaType;
	}
}