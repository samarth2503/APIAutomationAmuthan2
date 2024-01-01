package com.test;

import java.lang.reflect.Method;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.Constant.FrameWorkConstant;
import com.tmb.pojos.Employee;
import com.tmb.reports.ExtentLogger;
import com.tmb.requestBuilder.RequestBuilder;
import com.tmb.utils.RandomUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.datafaker.Faker;

public class PostTest extends BaseTest {
	
	@Test(enabled=false)
	public void PostCallTest()
	{
		Employee emp = Employee.builder()
				.setFirstname(RandomUtils.getFirstName())
				.setLastname(RandomUtils.getLastName())
				.setId(RandomUtils.getId())
				.build();
		
		Response resposne = RequestBuilder.buildRequestForPostCall()
		.body(emp)
		.post("/employees");
		
		Assertions.assertThat(resposne.getStatusCode())
		.isEqualTo(201);
	}
	
	@Test
	public void postRequestUsingExternalJson(Method method)
	{
		String resources = com.tmb.utils.ApiUtils.readJsonAndGetAsString(FrameWorkConstant.REQUEST_JSON_PATH+"jsons/Request.json");
		
		resources = resources.replace("fname",RandomUtils.getFirstName())
		.replace("number", String.valueOf(RandomUtils.getId()));
		
		RequestSpecification requestSpec = RequestBuilder.buildRequestForPostCall()
				.body(resources);
		
		ExtentLogger.logRequest(requestSpec);
				
		Response resposne = requestSpec.post("/employees");
		
		resposne.prettyPrint();
		
		ExtentLogger.logResposne(resposne.prettyPrint());
		
		com.tmb.utils.ApiUtils.storeStringAsJsonFile(FrameWorkConstant.RESPONSE_JSON_PATH+method.getName()+"response.json", resposne);
		
		Assertions.assertThat(resposne.getStatusCode()).isEqualTo(201);
				
		
	}

}
