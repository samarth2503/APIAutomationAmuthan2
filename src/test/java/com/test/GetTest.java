package com.test;

import org.testng.annotations.Test;

import com.tmb.requestBuilder.RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;

public class GetTest {
	
	@Test
	public void getEmployeeDetails()
	{
		Response response = RequestBuilder.buildRequestForGetCall()
				.get("/employees");
		
		response.prettyPrint();
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		
		Assertions.assertThat(response.jsonPath().getList("$").size()).isPositive()
		.as("Validating size of Employee Arrays..")
		.isLessThan(30);
	}
	
	@Test
	public void getEmployeeDetails2()
	{
		Response response = RequestBuilder.buildRequestForGetCall()
				.pathParam("id", 2)
				.get("/employees/{id}");
		
		response.prettyPrint();
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
		
		Assertions.assertThat(response.jsonPath().getMap("$").size()).isPositive()
		.as("Validating size of Employee Arrays..")
		.isLessThan(30);
		
		assertThat(response.jsonPath().getString("last_name"))
		.isEqualTo("Palmer");
	}


}
