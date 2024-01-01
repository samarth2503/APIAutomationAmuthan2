package com.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateRequest {
	
	@Test
	public void updateTest()
	{
		JSONObject obj = new JSONObject();
		obj.put("firstname","abcdfg");
		obj.put("email","assgsag@gmail.com");
		
		Response res = RestAssured.given()
		.contentType(ContentType.JSON)
		.pathParam("id", 1)
		.body(obj.toMap())
		.put("http://localhost:3000/employees/{id}");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
