package com.tmb.requestBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {
	
	private RequestBuilder() {}
	
	public static RequestSpecification buildRequestForGetCall()
	{
		return RestAssured.given()
				.baseUri("http://localhost:3000")
				.log().all();
	}
	
	public static RequestSpecification buildRequestForPostCall()
	{
		return RestAssured.given()
				.baseUri("http://localhost:3000")
				.log().all()
				.contentType(ContentType.JSON);
	}
	
	

}
