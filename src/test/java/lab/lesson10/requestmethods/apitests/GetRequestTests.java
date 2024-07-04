package lab.lesson10.requestmethods.apitests;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTests {

     @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }
    @Test
    public void TestGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers['user-agent']", notNullValue())
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }
}
