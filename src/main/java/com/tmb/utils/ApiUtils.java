package com.tmb.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;

public class ApiUtils {
	
	private ApiUtils() {}
	
	public static String readJsonAndGetAsString(String filePath)
	{
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void storeStringAsJsonFile(String filePath,Response resposne)
	{
		try {
			Files.write(Paths.get(filePath), resposne.asByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
