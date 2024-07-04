import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    static RequestSpecification requestSpec;
    String bodyText = "This is expected to be sent back as part of response body.";

    @BeforeEach
    public void spec() {
        requestSpec = given()
                .baseUri("https://postman-echo.com");
    }

    @Test
    public void whenGet_thenSuccess() {
        String keyOne = "foo1";
        String valueOne = "bar1";
        String keyTwo = "foo2";
        String valueTwo = "bar2";
        requestSpec
                .queryParam(keyOne, valueOne)
                .queryParam(keyTwo, valueTwo)
                .when().get("/get")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("args." + keyOne, equalTo(valueOne))
                .body("args." + keyTwo, equalTo(valueTwo));
    }

    @Test
    public void whenPostRawText_thenSuccess() {
        PostBody body = new PostBody("testValue");
        requestSpec
                .log().body()
                .contentType("application/json").body(body)
                .when().post("post")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("data.Test", equalTo(body.Test));
    }

    @Test
    public void whenPostFormData_thenSuccess() {
        String keyOne = "foo1";
        String valueOne = "bar1";
        String keyTwo = "foo2";
        String valueTwo = "bar2";
        requestSpec
                .log().body()
                .contentType("multipart/form-data")
                .multiPart(keyOne, valueOne)
                .multiPart(keyTwo, valueTwo)
                .when().post("post")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("form." + keyOne, equalTo(valueOne))
                .body("form." + keyTwo, equalTo(valueTwo));
    }

    @Test
    public void whenPut_thenSuccess() {
        requestSpec
                .log().body()
                .contentType("text/plain").body(bodyText)
                .when().put("put")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("data", equalTo(bodyText));
    }

    @Test
    public void whenPatch_thenSuccess() {
        requestSpec
                .log().body()
                .contentType("text/plain").body(bodyText)
                .when().patch("/patch")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("data", equalTo(bodyText));
    }

    @Test
    public void whenDelete_thenSuccess() {
        requestSpec
                .log().body()
                .contentType("text/plain").body(bodyText)
                .when()
                .delete("/delete")
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("data", equalTo(bodyText));
    }
}

