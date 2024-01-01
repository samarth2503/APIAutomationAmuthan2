package com.tmb.utils;

import net.datafaker.Faker;

public final class FakerUtils {
	
	private FakerUtils() {}
	
	public static final Faker faker = new Faker();
	
	public static int getNumber(int start, int end)
	{
		return faker.number().numberBetween(start,end);
	}

	public static String getFirstName() {
		
		return faker.name().firstName();
	}
	
	public static String getLastName() {
		
		return faker.name().lastName();
	}

}
