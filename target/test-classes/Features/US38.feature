#Author: jawid.kabul@gmail.com
  
# Description:
# For Editing Employee’s personal details, we want to have Drop down nationality
# and have all the values in Database 

Feature: Employee List Job Title Drop Down.

 @US38
  Scenario: View Job Title Drop Down Data
  
Given User Login to the HRMS Application
When User navigate to Employee List
Then User will See All the values available in Database for Job Title Drop Down 

# Note: is should be Alphabetic order

  

    
    
  
    