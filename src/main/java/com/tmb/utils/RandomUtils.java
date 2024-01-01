package com.tmb.utils;

public final class RandomUtils {
	
	// Business Layer
	// All business level changes can be done in this class
	
	private RandomUtils() {}
	
	public static int getId()
	{
		return FakerUtils.getNumber(100, 2000);
	}
	
	public static String getFirstName()
	{
		return FakerUtils.getFirstName().toLowerCase();
	}
	
	public static String getLastName()
	{
		return FakerUtils.getLastName().toLowerCase();
	}


}
