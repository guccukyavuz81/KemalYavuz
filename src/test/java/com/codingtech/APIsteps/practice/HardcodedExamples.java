package com.codingtech.APIsteps.practice;

import static io.restassured.RestAssured.given;
// we need to import this manually in order our assertions to work
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
/**
 * we may use below-comment out for now
 * @author kemal
 *
 */
//import org.apache.hc.core5.http.ContentType;

import com.codingtech.API.utils.APIConstants;
import com.codingtech.API.utils.PayloadConstants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * RestAssured static packages
 */

//import com.codingTech.API.utils.APIConstants;
//import com.codingTech.API.utils.PayloadConstants;

/**
 * This @FixMethodOrder(MethodSorters.Name_Ascending) will execute @Test
 * annotation in ascending alphabetical order
 * 
 * @author kemal
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {

	/**
	 * Rest Assured given-prepare your request When- you re making the call to the
	 * end point Then- validating
	 * 
	 * @param args
	 */
	public static String employeeID;
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2ODkzMDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMjUwNSwidXNlcklkIjoiNzA1In0.C--vLFy1JNFkx9SVQowUPauRO4ESo6THJfD3OOpmNVw";

	public static void main(String[] args) {
		/**
		 * Base URI for all calls
		 */
		
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		/**
		 * JWT required for all calls-expired every 12 hours
		 */

		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwODE3NzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEyNDk3MiwidXNlcklkIjoiNzA1In0.mjGJcJ1fnWRlofReUCrdwqndODkVhGLuYyQZNahPJdc";
		/**
		 * Preparing/getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", ContentType.JSON)
				.header("Authorization", token).queryParam("employee_id", "16493A");
//		
//		/**
//		 * .log().all(); this will print the detailed information
//		 */
		/**
		 * Storing response
		 */

		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Two ways to print response prettyPrint()method converts JSON object into
		 * String and Prints- no need to SYSO out
		 */
		getOneEmployeeResponse.prettyPrint();
		// String response =getOneEmployeeResponse.body().asString();
		// System.out.println(getOneEmployeeResponse);

		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	public void sampleTest() {

//			/**
//			 * JWT required for all calls-expired every 12 hours
//			 */
//			RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
//
//			String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwODE3NzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEyNDk3MiwidXNlcklkIjoiNzA1In0.mjGJcJ1fnWRlofReUCrdwqndODkVhGLuYyQZNahPJdc";
//			/**
//			 * Preparing/getOneEmployee.php request
//			 */
//			RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
//					.header("Authorization", token).queryParam("employee_id", "16493A");
//			/**
//			 * .log().all(); this will print the detailed information
//			 */
//
//			Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
//			/**
//			 * Two ways to print response prettyPrint()method converts JSON object into
//			 * String and Prints- no need to SYSO out
//			 */
//			getOneEmployeeResponse.prettyPrint();
//			// String response =getOneEmployeeResponse.body().asString();
//			// System.out.println(getOneEmployeeResponse);
//
//			/**
//			 * Verifying response status code is 200
//			 */
//			getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void aPOSTcreateEmployee() {

		/**
		 * Preparing request for/createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given().header("Content-Type", ContentType.JSON)
				.header("Authorization", token)
				.body("{\r\n" + "  \"emp_firstname\": \"Prince\",\r\n" + "  \"emp_lastname\": \"Abdul\",\r\n"
						+ "  \"emp_middle_name\": \"Tugba\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
						+ "  \"emp_birthday\": \"1985-03-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}");
		/**
		 * Storing response into createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post(APIConstants.CREATE_EMPLOYEE_URI_ENDPOINT);

		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();
		/**
		 * JsonPath() to view response body which lest us get the employee ID we store
		 * employee ID as a global variable so that we may we use it with our other
		 * calls
		 * 
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		System.out.println(employeeID);
		/**
		 * verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying message using equalTo() method -manually import static package=
		 * import org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/**
		 * verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Prince"));

		/**
		 * verifying server using then().Header()
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		/**
		 * verifying Content type
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
		

	}

	@Test
	public void bGETcreatedEmployee() {
		/**
		 * Preparing request for/getOneEmployee.php Using log().all() to see all
		 * information being sent with the request
		 * 
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().log().all().get("/getOneEmployee.php");

		/**
		 * Printing response using prettyPrint()
		 */

		String response = getCreatedEmployeeResponse.prettyPrint();
		/**
		 * STORING response employeeID which will be used for verification against
		 * stored employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		/**
		 * matching exact employeeID's
		 */
		boolean verifyingEmployeeIDsMatch = empID.contentEquals(employeeID);
		/**
		 * Asserting employee ID match
		 */
		Assert.assertTrue(verifyingEmployeeIDsMatch);
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		JsonPath js = new JsonPath(response);// retrieving each value from response body
		String emplID = js.getString("employee[0].employee_id");//
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String emp_bday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(empStatus);
		System.out.println(emp_bday);

		/**
		 * Verifying employee ID's match
		 */
		Assert.assertTrue(empID.contentEquals(employeeID));//
		// second way of asserting
		Assert.assertEquals(emplID, employeeID);

		Assert.assertTrue(firstName.contentEquals("Prince"));
		/** Verifying expected first name matches actual first name */
		Assert.assertTrue(middleName.contentEquals("Tugba"));
		/** Verifying expected middle name matches actual middle name */
		Assert.assertTrue(lastName.contentEquals("Abdul"));
		/** Verifying expected last name matches actual last name */
		Assert.assertTrue(emp_bday.contentEquals("1985-03-11"));
		/** Verifying expected birthday matches actual birthday */
		Assert.assertTrue(gender.contentEquals("Male"));
		/** Verifying expected gender matches actual gender */
		Assert.assertTrue(jobTitle.contentEquals("Cloud Architect"));
		/** Verifying expected job title matches actual job title */
		Assert.assertTrue(empStatus.contentEquals("Employee"));
		/** Verifying expected employee status matches actual employee status */

	}

	@Test
	public void cGETallEmployees() {

		/** Preparing/getAllEmployees.php request */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/**
		 * Printing all employees
		 */
		// getAllEmployeesResponse.prettyPrint();// this prints all employees.

		//String allEmployees = getAllEmployeesResponse.body().asString();
		String allEmployees = getAllEmployeesResponse.prettyPrint();


		/**
		 * -- DO RESEARCH
		 */
		// allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);
		/**
		 * Retrieving the size of Employee list
		 */
		int sizeOfList = js.getInt("Employees.size");
		System.out.println(sizeOfList);
		/**
		 * print out all Employee ID's
		 */
//
//		for (int i = 0; i < sizeOfList; i++) {

//
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id"); 
//			// System.out.println(allEmployeeIDs);
		
		/**
		 * if statement inside for loop to find stored employee ID and break the loop when found
		 */
		
		
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				System.out.println("Employee ID : "+employeeID+ " is present in body");
//				String employeeFirstName=js.getString("Employees[" + i + "].emp_firstname");
//				System.out.println(employeeFirstName);
//				break;
//			}
//
//		}

	}

	@Test
	public void dPUTupdateCreatedEmployee() {
		/**
		 * Preparing request to update created employee
		 * calling static method updateCreatedEmployee()from HardcodedConstant class
		 */
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreateEmpBody());

		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		// String response=updateCreatedEmployeeResponse.prettyPrint();

		/**
		 * Asserting using hamcrest matchers equalTo() verify employee is updated
		 */

		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		
		/**
		 * retrieving response body employee ID using JSON path 
		 */

		String empID = updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		/**
		 * Asserting that response body employee ID macthes globally stored employee ID
		 */
		Assert.assertTrue(empID.contentEquals(employeeID));

	}

	public void eGETupdatedEmployee() {
		/**
		 * Preparing request to get updated employee
		 */
		RequestSpecification getUpdatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);
		
		Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
		
		// getUpdatedEmployeeResponse.prettyPrint();

		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("Gulnaz"));
		/**
		 * Asserting expected first name
		 */
		getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(employeeID));
		
	}

	@Test
	public void fPATCHpartiallyUpdateEmployee() {
		RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\r\n" + "  \"employee_id\": \"" + employeeID + "\",\r\n"
						+ "  \"emp_firstname\": \"Ahmet\"\r\n" + " \r\n" + "}");
		Response partiallyUpdatingEmployeeResponse = partiallyUpdatingEmployeeRequest.when()
				.patch("/updatePartialEmplyeesDetails.php");
		
		//partiallyUpdatingEmployeeResponse.prettyPrint();
		partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);

		partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));

	}

	@Test
	public void gDELETEemployee() {
		RequestSpecification deleteEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);
		Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");
		deleteEmployeeResponse.prettyPrint();
		deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));

	}

}
