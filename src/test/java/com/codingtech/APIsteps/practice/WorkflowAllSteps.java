package com.codingtech.APIsteps.practice;


//import com.codingTech.API.utils.APIConstants;
//import com.codingTech.API.utils.PayloadConstants;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import com.codingtech.API.utils.APIConstants;
import com.codingtech.API.utils.PayloadConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;






public class WorkflowAllSteps {
	String BaseURI = "http://18.232.148.34/syntaxapi/api";
	RequestSpecification request;
	Response response;
	static String employeeID;

	@Given("a request is prepared to create and employee")
	public void a_request_is_prepared_to_create_and_employee() {

		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationSteps.token)
				.body(PayloadConstants.createEmployeeBody());

	}

	@When("s POST call is made to create and employee")
	public void s_POST_call_is_made_to_create_and_employee() {
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI_ENDPOINT);
		response.prettyPrint();

	}

	@Then("the status code for creating an employee is {int}")
	public void the_status_code_for_creating_an_employee_is(int statusCode) {
		response.then().assertThat().statusCode(statusCode);

	}

	@Then("the employee is created and response contains key {string} and value {string}")
	public void the_employee_is_created_and_response_contains_key_and_value(String key, String value) {
		response.then().assertThat().body(key, equalTo(value));
	}

	@Then("the employeeID {string} is stored as a global variable to be used for other calls")
	public void the_employeeID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {
		employeeID=response.body().jsonPath().getString(empID);
		System.out.println(employeeID);
		
	   
	}
	@Given("a request prepared to retrive the created employee")
	public void a_request_prepared_to_retrive_the_created_employee() {
		request=given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token)
		.queryParam("employee_id", employeeID);
		
	  
	}

	@When("a GET call is made to retrieve the created employee")
	public void a_GET_call_is_made_to_retrieve_the_created_employee() {
		response=request.when().get(APIConstants.GET_ONE_EMPLOYEE_ENDPOINT);
		int code=response.getStatusCode();
		System.out.println("code : " +code);
		//Assert.assertEquals(code, "200");
		
	  }
	
	@Then("the status code for retrieving the created employee is {int}")
    public void the_status_code_for_retrieving_the_created_employee_is(int statuscode) {
        
        response.then().assertThat().statusCode(statuscode);
    }
    
	@Then("the retrieve employee ID at {string} matches the globally stored employee ID")
	public void the_retrieve_employee_ID_at_matches_the_globally_stored_employee_ID(String value) {
	   String empID=response.body().jsonPath().getString(value);
	   Assert.assertTrue(empID.contentEquals(employeeID));
	}

	 @Then("the retrieved data at {string} matches the data used to create an employee with employee ID {string}")
	    public void the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(String employeeObject, String responseEmployeeID, DataTable dataTable) {
	       
	        List<Map<String, String>> expectedData = dataTable.asMaps();
	        
	        List<Map<String, String>> actualData = response.jsonPath().get(employeeObject);
	        
	        int index = 0;
	        
	        for(Map<String, String> map : expectedData) {
	            
	            Set<String> keys = map.keySet();
	            
	            for(String key : keys) {
	                
	                String expectedValue = map.get(key);
	                String actualValue = actualData.get(index).get(key);
	                Assert.assertEquals(expectedValue, actualValue);
	            }
	            index ++;
	        }
	        String empID = response.body().jsonPath().getString(responseEmployeeID);
	        Assert.assertTrue(empID.contentEquals(employeeID));
	    }

    }






	
	

