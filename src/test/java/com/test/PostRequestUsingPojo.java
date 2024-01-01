package com.test;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.pojo.Employee;
import com.pojo.FavFood;
import com.pojo.Marks;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PostRequestUsingPojo {
	
	@Test
	public void pojoTest()
	{
		FavFood fv = new FavFood("Idli","Chaptai",Arrays.asList("Rice","Dal"));
		Marks mark = new Marks(34,67);
		Marks mark1 = new Marks(38,60);
		
		
		Employee emp = new Employee(17,"Rohit","Sharma","rohits@gmail.com",fv,Arrays.asList("trainer","tester"), Arrays.asList(mark,mark1));
		
		Response res = RestAssured.given()
		.log().all()
		.body(emp)
		.post("http://localhost:3000/employees");
		
		res.prettyPrint();
		
		res.then().body(JsonSchemaValidator.matchesJsonSchema(System.getProperty("user.dir")+"\\src\\test\\resources\\jsons\\Schema.json"));
		
	}

}
