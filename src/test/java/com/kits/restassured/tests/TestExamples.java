package com.kits.restassured.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestExamples {

	public TestExamples() {
		baseURI = "https://reqres.in/api";
	}
	@Test
	public void test1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("status: " + response.getStatusCode());
		System.out.println("response: " + response.getBody().asPrettyString());
	}
	
	@Test
	public void checkStatusCode() {
		given().get("/users?page=2").then().statusCode(200);
	}
	
	@Test
	public void checkBody() {
		given().get("/users?page=2").then().body("data[1].id", equalTo(7)).log().all();	
	}
}
