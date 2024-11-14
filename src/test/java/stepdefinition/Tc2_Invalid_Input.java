package stepdefinition;

import baseClass.BaseClass;
import endpoints.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBody;

import static org.junit.jupiter.api.Assertions.assertEquals;

import payloadManager.PayloadManager;
import pojoClass_Invalid_logintype.Data_Invalid_input_Output;

public class Tc2_Invalid_Input extends BaseClass {

    PayloadManager payloadManager = new PayloadManager();

    @When("user add requestbody for loginInvalidInput {string} ,{string} and {string}")
    public void user_add_requestbody_for_login_invalid_input_and(String loginid, String logintype, String notification) {

        RestAssured.registerParser("text/plain", Parser.JSON);
        addReqBody(payloadManager.getInvalidLoginPayLoad().addInvalidLoginDetails(loginid, logintype, notification));

    }

    @When("the user sends a invalidlogintype request with {string}")
    public void the_user_sends_a_invalidlogintype_request_with(String string) {

        addReqType(string, Endpoints.LOGIN);
    }

    @Then("the response status should be {int} and message {string}")
    public void the_response_status_should_be_and_message(Integer expectedResponsecode, String expectedMsg) {

        int responseCode = getResponseCode();
        ResponseBody getBody = getbody();

        Data_Invalid_input_Output dataInvalidInputOutput = getBody.as(Data_Invalid_input_Output.class);
        assertEquals(responseCode, expectedResponsecode, "verify response code");
        assertEquals(expectedMsg, dataInvalidInputOutput.getMessage(), "verify message");
    }


}
