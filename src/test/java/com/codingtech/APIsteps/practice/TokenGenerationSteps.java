package com.codingtech.APIsteps.practice;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class TokenGenerationSteps {

	public static String token;
	/**
	 * Storing token as a static variable
	 */
	
	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body(
				"{\r\n" + "  \"email\": \"aslantepe@hotmail.com\",\r\n" + "  \"password\": \"1905gs1981gs\"\r\n" + "}");
		Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
		// generateTokenResponse.prettyPrint();
		/**
		 * Retrieving token from generate response body and concatenating "Bearer "
		 */

		token = "Bearer " + generateTokenResponse.body().jsonPath().getString("token");
		/**
		 * Optional to print out token
		 */
		System.out.println(token);

	}

}
