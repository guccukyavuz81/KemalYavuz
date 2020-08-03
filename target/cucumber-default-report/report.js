$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/UserStory38.feature");
formatter.feature({
  "name": "User Story 38",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Getting The Job Titles",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I log in to HRMS",
  "keyword": "Given "
});
formatter.match({
  "location": "com.codingtech.steps.UserStory38.i_log_in_to_HRMS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Employee Search page",
  "keyword": "And "
});
formatter.match({
  "location": "com.codingtech.steps.UserStory38.go_to_Employee_Search_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the Job Titles as a list",
  "keyword": "When "
});
formatter.match({
  "location": "com.codingtech.steps.UserStory38.i_get_the_Job_Titles_as_a_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the Job titles from the database",
  "keyword": "And "
});
formatter.match({
  "location": "com.codingtech.steps.UserStory38.get_the_Job_titles_from_the_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the list from UI against DB",
  "keyword": "Then "
});
formatter.match({
  "location": "com.codingtech.steps.UserStory38.i_validate_the_list_from_UI_against_DB()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Getting The Job Titles");
formatter.after({
  "status": "passed"
});
});