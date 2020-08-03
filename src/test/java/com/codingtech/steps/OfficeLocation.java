package com.codingtech.steps;





import com.codingtech.pages.LoginPageElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OfficeLocation {

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
		LoginPageElements login = new LoginPageElements();
		login.login("username", "password");
		
	}

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
	   
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String string) {
	    
	}

	@When("click on search button")
	public void click_on_search_button() {

	}

	@When("click on firstname which desplyed in the table")
	public void click_on_firstname_which_desplyed_in_the_table() {
	
	}

	@When("click in job button")
	public void click_in_job_button() {
	  
	}

	@When("click location button")
	public void click_location_button() {
	   
	}

	@Then("user see all the office location")
	public void user_see_all_the_office_location() {

	}

}
