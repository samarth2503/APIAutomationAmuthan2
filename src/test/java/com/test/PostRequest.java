package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;

public class PostRequest {
	
	@Test
	public void createUserAsString()
	{
		Response resposne = RestAssured.given()
		.body("{\r\n"
				+ "	\"id\" : 15,\r\n"
				+ "	\"first_name\" : \"Amuthan\",\r\n"
				+ "	\"last_name\" : \"Sakthivel\",\r\n"
				+ "	\"email\" : \"amiuthansak@deloite.com\"\r\n"
				+ "}")
		.log().all()
		.post("http://localhost:3000/employees");
		
		resposne.prettyPrint();
		System.out.println(resposne.getStatusCode());
		
	}
	
	@Test
	public void createUserAsFile()
	{
		// You cannot get request from file and print on console
		// Use this only for static data
		
		String getBody = "";
		try {
			getBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\samarjain\\eclipse-workspace\\APIAutomationAmuthan\\resources\\test.json")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// By reading file and converting into String
		// Not suitable when request body has lots of dynamic parameter
		
		Response resposne1 = RestAssured.given()
		.contentType(ContentType.JSON)
		.body(getBody)
		.post("http://localhost:3000/employees");
		
		resposne1.prettyPrint();
		
				
		// By using File 
		Response resposne = RestAssured.given()
		.contentType(ContentType.JSON)
		.body(new File("C:\\Users\\samarjain\\eclipse-workspace\\APIAutomationAmuthan\\resources\\test.json"))
		.post("http://localhost:3000/employees");
		
		resposne.prettyPrint();
		
	}
	
	public void createUserWithListAndMap()
	{
		// {} --> Map Interface
		// [] --> List
		
		// Verbose and not suitable for Very big json
		// Generic type needs to be mentioned
		
		Map<String,Object> obj = new HashMap<String,Object>();
		obj.put("id", 16);
		obj.put("fname", "Rahul");
		obj.put("lname", "Singh");
		obj.put("email", "rahulsingh@gmail.com");
		
		List<String> listOfJobs = Arrays.asList("tester","trainer");
		obj.put("jobs", listOfJobs);
		
		Map<String,Object> foods = new HashMap<String,Object>();
		
		foods.put("breakfast", "idly");
		foods.put("lunch", "rice");
		
		List<String> dinnerFood = new ArrayList<String>();
		dinnerFood.add("chapathi");
		dinnerFood.add("Milk");
		
		foods.put("dinner", dinnerFood);
		
		obj.put("favFoods", foods);
		
		Response resposne = RestAssured.given()
		.header("Content-Type",ContentType.JSON)
		.body(obj)
		.post("http://localhost:3000/employees");
		
		resposne.prettyPrint();
		
	}
	
	@Test
	public void externalJsonLibrary()
	{
		// Using external Json Library
		// having same collections that can solve the problem we had while using map and list 
		// {} --> JsonObject
		// [] --> JsonArray
		// External Json Library solve the problem of verbosity
		
		JSONObject obj = new JSONObject();
		
		obj.put("id", new Faker().number().numberBetween(100, 1000));
		obj.put("fname", "Ram");
		obj.put("lname", "Shukla");
		obj.put("email", "ram@gmail.com");
		
		JSONArray listOfJobs = new JSONArray();
		
		listOfJobs.put("tester");
		listOfJobs.put("trainer");
		
		obj.put("jobs",listOfJobs);
		
		JSONObject food = new JSONObject();
		food.put("breakfast","idly");
		food.put("lunch", "rice");
		
		JSONArray listOfFoods = new JSONArray();
		listOfFoods.put("chapati");
		listOfFoods.put("milk");
		
		food.put("dinner", listOfFoods);
		obj.put("favFood", food);
		
		Response repsosne = RestAssured.given()
		.log().all()
		.contentType("application/json")
		.body(obj.toMap())						// Jackson libaray can only searlize Java Object that why we need to convert Json Object to String, Map or List
		.post("http://localhost:3000/employees");
		
		repsosne.prettyPrint();
		
	}

}
