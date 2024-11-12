package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    public static WebDriver driver;

    public void launchDriver() {
        driver = new ChromeDriver();
    }


    public static String getpropertyfilevalue(String key) throws FileNotFoundException, IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(getpropertypath() + "\\PropertyFile\\config.properties"));
        Object object = properties.get(key);
        return (String) object;

    }

    public static String getpropertypath() {
        return System.getProperty("user.dir");

    }

    RequestSpecification reqspec;
    Response response;

    public void addHeaders(Headers headers) {
        reqspec = RestAssured.given().headers(headers);

    }

    public void addHeader(String key, String value) {
        reqspec = RestAssured.given().header(key, value);

    }


    public void addReqBody1(Object body) {

        reqspec.body(body);
    }

    public void addReqBody(String body) {

        reqspec.body(body);
    }

    public Response addReqType(String Type, String endpoint) {

        switch (Type) {

            case "GET": {
                response = reqspec.get(endpoint);
                break;
            }
            case "POST": {
                response = reqspec.post(endpoint);
                break;
            }
            case "PUT": {
                response = reqspec.put(endpoint);
                break;
            }
            case "PATCH": {
                response = reqspec.patch(endpoint);
                break;
            }
            case "DELETE": {
                response = reqspec.delete(endpoint);
                break;
            }

        }
        return response;
    }

    public int getResponseCode(Response response) {
        return response.getStatusCode();

    }

    public String getResBodyAsString() {

        return response.asString();
    }

    public String getResBodyAsPrettyString() {

        return response.asPrettyString();
    }


    public RequestSpecification addBasicAuth(String userid, String Password) {

        return reqspec.auth().preemptive().basic(userid, Password);
    }

}
