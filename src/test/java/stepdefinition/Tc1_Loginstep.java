package stepdefinition;

import baseClass.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import endpoints.Endpoints;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBody;
import payloadManager.PayloadManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import pojoClassLogin.Data_Login_Output;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tc1_Loginstep extends BaseClass {



    PayloadManager payloadManager = new PayloadManager();

    @Given("the login API is available")
    public void the_login_api_is_available() {

        RestAssured.registerParser("text/plain", Parser.JSON);

        List<Header> list_headers = new ArrayList<>();
        Header h1 = new Header("appid", "External");
        Header h2 = new Header("specificAppId", "Harley");
        Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");

        list_headers.add(h1);
        list_headers.add(h2);
        list_headers.add(h3);
        Headers headers = new Headers(list_headers);
        addHeaders(headers);

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Base URL is: "+Endpoints.LOGIN);

    }


    @When("user add requestbody for login {string} ,{string} and {string}")
    public void user_add_requestbody_for_login_and(String loginid, String logintype, String notification) {

        addReqBody(payloadManager.getLoginPayLoadPayload().addLoginDetails(loginid, logintype, notification));

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: loginid=" + loginid + ",logintype=" + logintype + ",notification=" + notification);
    }
    @When("the user sends a login request with {string}")
    public void the_user_sends_a_login_request_with(String string) {

        addReqType(string, Endpoints.LOGIN);


    }

    @Then("Validate response with Message {string}, Status code {int} ,Success {string}, errorCode {int} and error description {string}")
    public void validate_response_with_message_status_code_success_error_code_and_error_description(String expectedMsg, Integer expectedStatuscode, String expectedSuccessmsg, Integer expectedeErrorcode, String expectedDescription) {

        int responseCode = getResponseCode();
        ResponseBody getBody = getbody();

        Data_Login_Output dataLoginOutput = getBody.as(Data_Login_Output.class);

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: "+responseCode);
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: "+getBody.asPrettyString());

        assertEquals(expectedMsg, dataLoginOutput.getMessage(), "verify message");
        assertEquals(expectedStatuscode,responseCode,"verify response code");
        assertEquals(expectedeErrorcode, dataLoginOutput.getErrorCode(), "verify error code");
        assertEquals(expectedDescription,dataLoginOutput.getErrorDescription(),"verify error description");
    }


}


