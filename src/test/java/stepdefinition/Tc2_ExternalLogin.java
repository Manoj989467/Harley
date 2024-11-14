package stepdefinition;

import baseClass.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import endpoints.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBody;
import payloadManager.PayloadManager;
import pojoClass_ExternalLogin.Root_ExternalLogin_Output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class Tc2_ExternalLogin extends BaseClass {

    PayloadManager payloadManager = new PayloadManager();

    @When("the user sends a login request with valid_mobile_number and add headers")
    public void the_user_sends_a_login_request_with_valid_mobile_number_and_add_headers() {

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

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Base URL is: "+ Endpoints.LOGIN);
    }

    @When("user add requestbody for validlogin {string} ,{string} and {string}")
    public void user_add_requestbody_for_validlogin_and(String loginid, String logintype, String notification) {

        addReqBody(payloadManager.getExternalLoginPayLoad().addLoginDetails(loginid, logintype, notification));
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: loginid=" + loginid + ",logintype=" + logintype + ",notification=" + notification);

    }

    @When("the user sends a Externallogin request with {string}")
    public void the_user_sends_a_externallogin_request_with(String string) {

        addReqType(string, Endpoints.LOGIN);

    }

    @Then("the response status should be {int} and message {string}")
    public void the_response_status_should_be_and_message(int expectedResponsecode, String expectedMsg) {

        int responseCode = getResponseCode();
        ResponseBody getbody = getbody();
        System.out.println(getbody.asPrettyString());
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: "+responseCode);
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: "+ getbody.asPrettyString());

        Root_ExternalLogin_Output dataExternalLoginOutput = getbody.as(Root_ExternalLogin_Output.class);

        assertEquals(expectedMsg,dataExternalLoginOutput.message,"verify message");
        assertEquals(expectedResponsecode,responseCode,"verify response code");

    }

}
