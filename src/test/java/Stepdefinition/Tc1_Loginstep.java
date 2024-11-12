package Stepdefinition;

import BaseClass.BaseClass;
import PayaloadManager.PayloadManager;
import PojoClassLogin.Root_Login_Output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tc1_Loginstep extends BaseClass {

    Response requesttype;
    PayloadManager payloadManager = new PayloadManager();


    @Given("the login API is available")
    public void the_login_api_is_available() {

        List<Header> list_headers = new ArrayList<Header>();
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
    public void the_response_status_should_be_and_message(Integer int1, String string) {

        addReqBody1(payloadManager.getLoginPayLoadPayload().addLoginDetails("", true));

        Response response = addReqType("POST", "ulr");
        int responseCode = getResponseCode(response);

        Assert.assertEquals("verify response code", Optional.of(responseCode), string);

        Root_Login_Output data = requesttype.as(Root_Login_Output.class);

        Assert.assertEquals("verify login Message", data.message, string);

    }
}