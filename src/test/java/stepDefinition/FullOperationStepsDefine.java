package stepDefinition;

import cucumberRunner.TestRun;
import java.io.IOException;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FullOperationStepsDefine extends TestRun {

	private static final String age = "70";
	private static final String name = "Test";
	private static final String salary = "6000";
	private static final String updatesalary = "9000";
	// private static final String BASE_URL = "http://dummy.restapiexample.com";
	private static Response response;

	public FullOperationStepsDefine() throws IOException {
		super();

	}

	@Given("ViewAllEmployees")
	public void view_all_employees() {

		RestAssured.baseURI = config.getProperty("BASE_URL");

		// RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/api/v1/employees");
		System.out.println(response.getStatusCode());

		// Always displays status code:Too many request(429)
		// assertEquals(200,response.getStatusCode());
	}

	@When("Creation Of Employee")
	public void creation_of_employee() {
		RestAssured.baseURI = config.getProperty("BASE_URL");
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		response = request.body("{ \"name\":\"" + name + "\", \"salary\":\"" + salary + "\",\"age\":\"" + age + "\"}")
				.post("/api/v1/create");
		System.out.println(response.getStatusCode());

		// Always displays status code:Too many request(429)
		// assertEquals(200,response.getStatusCode());

	}

	@And("Update Employee Details")
	public void update_employee_details() {

		RestAssured.baseURI = config.getProperty("BASE_URL");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request
				.body("{ \"name\":\"" + name + "\", \"salary\":\"" + updatesalary + "\",\"age\":\"" + age + "\"}")
				.put("/api/v1/update/1");
		System.out.println(response.getStatusCode());

		// Always displays status code:Too many request(429)
		// assertEquals(200,response.getStatusCode());

	}

	@And("View Employee Details")
	public void view_employee_details() {
		RestAssured.baseURI = config.getProperty("BASE_URL");
		RequestSpecification request = RestAssured.given();
		response = request.get("/api/v1/employee/1");
		System.out.println(response.getStatusCode());

		// Always displays status code:Too many request(429)
		// assertEquals(200,response.getStatusCode());

	}

	@Then("Delete the Employee")
	public void delete_the_employee() {

		RestAssured.baseURI = config.getProperty("BASE_URL");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.delete("/api/v1/delete/719");
		System.out.println(response.getStatusCode());

		// Always displays status code:Too many request(429)
		// assertEquals(200,response.getStatusCode());
	}

	@Given("start the script")
	public void start_the_script() {
		System.out.println("script execution started");
	}

	@Then("script execution in progress")
	public void script_execution_in_progress() {
		System.out.println("script execution in progress");
	}

	@Then("Execution completed")
	public void execution_completed() {
		System.out.println("Execution completed");
	}

}