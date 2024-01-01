package com.tmb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertiesUtil {
	
	private PropertiesUtil() {}
	
	// Read content from property file and store in hashMap
	
	private static Properties properties = new Properties();
	private static Map<String,String> map = new HashMap<String,String>();
	
	static {
		
		try {
			FileInputStream file = new FileInputStream("");
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		properties.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
	}
	
	public static String getValue(String key)
	{
		return map.get(key);
	}

}
