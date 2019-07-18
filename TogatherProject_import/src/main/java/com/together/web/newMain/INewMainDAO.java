package com.together.web.newMain;

import java.util.ArrayList;

public interface INewMainDAO
{
	public ArrayList<NewMainDTO> newMainTravelInfoBasic();
	public ArrayList<String> newMainThemeType(int travelCode);
	public NewMainDTO newMainCityStart(int travelCode);
	public NewMainDTO newMainCityEnd(int travelCode);
	
}