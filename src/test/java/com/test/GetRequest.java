package com.test;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest {
	
	@Test
	public void getEmployee()
	{
		Response resposne = RestAssured.given()
		.contentType(ContentType.JSON)
		.queryParam("id", 4)
		.get("http://localhost:3000/employees");
		
		
		System.out.println(resposne);
		try {
			Files.write(Paths.get(System.getProperty("user.dir")+"/response.json"),resposne.asByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
