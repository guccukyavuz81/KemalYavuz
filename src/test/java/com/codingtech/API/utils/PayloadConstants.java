package com.codingtech.API.utils;

import com.codingtech.APIsteps.practice.HardcodedExamples;

public class PayloadConstants {
	public static String updateCreateEmpBody() {
		String updateBody = "{\r\n" + 
                "  \"employee_id\": \""+HardcodedExamples.employeeID +"\",\r\n" + 
                "  \"emp_firstname\": \"ilyasUpdate\",\r\n" + 
                "  \"emp_lastname\": \"unakUpdate\",\r\n" + 
                "  \"emp_middle_name\": \"Update\",\r\n" + 
                "  \"emp_gender\": \"M\",\r\n" + 
                "  \"emp_birthday\": \"2000-05-11\",\r\n" + 
                "  \"emp_status\": \"Internee\",\r\n" + 
                "  \"emp_job_title\": \"CTO\"\r\n" + 
                "}";
		return updateBody;
			





	}
	public  static String createEmployeeBody() {
		/**
		 * create method to return payload-to reduce messy code
		 * @return
		 */
		String createEmployeeBody="{\r\n" + 
				"  \"emp_firstname\": \"Prince\",\r\n" + 
				"  \"emp_lastname\": \"Abdul\",\r\n" + 
				"  \"emp_middle_name\": \"Tugba\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1985-03-11\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
				"}";
		return createEmployeeBody;
	}

}
