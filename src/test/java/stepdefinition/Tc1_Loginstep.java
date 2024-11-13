package stepdefinition;

import baseClass.BaseClass;
import endpoints.Endpoints;
import payloadManager.PayloadManager;
import pojoClassLogin.Root_Login_Output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tc1_Loginstep extends BaseClass {

    Response requesttype;
    PayloadManager payloadManager = new PayloadManager();


    @Given("the login API is available")
    public void the_login_api_is_available() {

        List<Header> list_headers = new ArrayList<>();
        Header h1 = new Header("appid", "External");
        Header h2 = new Header("specificAppId", "Harley");
        Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");

        list_headers.add(h1);
        list_headers.add(h2);
        list_headers.add(h3);
        Headers headers = new Headers(list_headers);
        addHeaders(headers);

    }

    @Then("the response status should be {int} and message {string}")
    public void the_response_status_should_be_and_message(int expectedresponse, String expectedmsg) {

        addReqBody1(payloadManager.getLoginPayLoadPayload().addLoginDetails("7004813003", "mobile", "sms"));

        Response response = addReqType("POST", Endpoints.LOGIN);

        int responseCode = getResponseCode(response);

        assertEquals(expectedresponse, responseCode, "verifyresponsecode");

        Root_Login_Output data = requesttype.as(Root_Login_Output.class);

        assertEquals(expectedmsg, data.message, "verify login Message");

    }

}