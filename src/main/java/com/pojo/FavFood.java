package com.pojo;

import java.util.List;

public class FavFood {
	
	private String breakfast;
	private String lunch;
	private List<String> dinner;
	
	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public List<String> getDinner() {
		return dinner;
	}

	public void setDinner(List<String> dinner) {
		this.dinner = dinner;
	}

	public FavFood(String breakfast, String lunch, List<String> dinner) {
		super();
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}
	
	

}
