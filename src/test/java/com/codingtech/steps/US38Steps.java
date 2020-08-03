package com.codingtech.steps;

import java.sql.SQLException;

import org.junit.Assert;

import com.codingtech.testbase.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US38Steps extends CommonMethods{
	
	@Given("User Login to the HRMS Application")
	public void user_Login_to_the_HRMS_Application() {
		
		
		BaseClass.setUp();
		//BaseClass.tearDown();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		
		
		click(login.loginBtn);
	}

	@When("User navigate to Employee List")
	public void user_navigate_to_Employee_List() {
		
		//navigate to employee list page
		jsClick(dashboard.PIM);
		jsClick(dashboard.empListPage);
		
		click(viewEmp.adminBTN);
		click(viewEmp.Jobmenue);
		click(viewEmp.Joblist);
	}

	@Then("User will See All the values available in Database for Job Title Drop Down")
	public void user_will_See_All_the_values_available_in_Database_for_Job_Title_Drop_Down() throws SQLException {
	
	
		Assert.assertEquals(viewEmp.getAllJobTitleDropDown(viewEmp.JobTitlenames), US38DBSteps.getAllJobTitleListn());
		
		
	}
	
}


		
	
