package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefs {

    Response response;

    @Given("I have access to Todo.ly")
    public void todoLyAccess() {
        System.out.println("acceso al todo.ly");
    }

    @When("I send a POST request to the url {} with json")
    public void petitionSentWithJson(String url, String body) {
        response = given().
                auth().
                preemptive().
                basic("jordi@ugarte.com", "123456789").
                contentType(ContentType.JSON).
                body(body).
                log().
                all().
                when().
                post(url);
    }

    @Then("Wait for the response code to be {int}")
    public void waitForResponse(int expectedResult) {
        response.then().
                statusCode(expectedResult);
    }

    @And("Wait for the item name to be {string}")
    public void waitForItemName(String expectedNameProject) {
        response.then().
                body("Content", equalTo(expectedNameProject));
    }
}
