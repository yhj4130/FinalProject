package com.together.web.best;

import java.util.ArrayList;

public interface IBestMainDAO
{
	public ArrayList<BestMainDTO> bestMainTravelInfoBasic();
	public ArrayList<String> bestMainThemeType(int travelCode);
	public BestMainDTO bestMainCityStart(int travelCode);
	public BestMainDTO bestMainCityEnd(int travelCode);
	
}