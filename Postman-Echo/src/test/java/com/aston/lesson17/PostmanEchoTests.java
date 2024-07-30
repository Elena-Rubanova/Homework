package com.aston.lesson17;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostmanEchoTests {

    private final static String BASE_URI = "https://postman-echo.com";
    private final String expectedText = "This is expected to be sent back as part of response body.";

    private final String HOST = "postman-echo.com";
    private final String PROTO = "https";
    private final String PORT = "443";
    private final String TYPE_JSON = "application/json";
    private final String USER_AGENT = "Apache-HttpClient/4.5.13 (Java/18.0.2)";
    private final String ENCODING = "gzip,deflate";

    List<String> headersListJSon = List.of(HOST, PROTO, PORT, TYPE_JSON, USER_AGENT, ENCODING);
    List<String> headersListURLen = List.of(HOST, PROTO, PORT, TYPE_JSON, USER_AGENT, ENCODING);

    @Test
    public void testGetRequest() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URI), Specifications.responseSpecOK200());
        PostmanEchoPojo param = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("args", PostmanEchoPojo.class);
        // Проверка тела ответа
        Assert.assertEquals(param.getFoo1(), "bar1");
        Assert.assertEquals(param.getFoo2(), "bar2");

        PostmanHeadersPojo headers = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", PostmanHeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }

    @Test
    public void testPostRawText() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URI), Specifications.responseSpecOK200());
        String rawText = "\"test\": \"value\"";

        given()
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .log().body()
                .assertThat()
                .body("data", Matchers.equalTo(rawText));

        PostmanHeadersPojo headers = given()
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .extract().body().jsonPath().getObject("headers", PostmanHeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }

    @Test
    public void testPostFormData() {
        Specifications.installSpecification(Specifications.requestSpecificationUnlencoded(BASE_URI),
                Specifications.responseSpecOK200());

        PostmanEchoPojo param = given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("form", PostmanEchoPojo.class);
        // Проверка тела ответа
        Assert.assertEquals(param.getFoo1(), "bar1");
        Assert.assertEquals(param.getFoo2(), "bar2");

        PostmanHeadersPojo headers = given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .extract().body().jsonPath().getObject("headers", PostmanHeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListURLen));
    }

    @Test
    public void testPutMethod() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URI), Specifications.responseSpecOK200());

        given()
                .body(expectedText)
                .when()
                .put("/put")
                .then()
                .log().body()
                .assertThat()
                .body("data", Matchers.equalTo(expectedText));

        PostmanHeadersPojo headers = given()
                .body(expectedText)
                .when()
                .put("/put")
                .then()
                .extract().body().jsonPath().getObject("headers", PostmanHeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }

    @Test
    public void testPatchMethod() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URI), Specifications.responseSpecOK200());

        given()
                .body(expectedText)
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .assertThat()
                .body("data", Matchers.equalTo(expectedText));

        PostmanHeadersPojo headers = given()
                .body(expectedText)
                .when()
                .patch("/patch")
                .then()
                .extract().body().jsonPath().getObject("headers", PostmanHeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }

    @Test
    public void testDeleteRawText() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URI), Specifications.responseSpecOK200());

        given()
                .body(expectedText)
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .assertThat()
                .body("data", Matchers.equalTo(
                        "This is expected to be sent back as part of response body."));

        PostmanHeadersPojo headers = given()
                .body(expectedText)
                .when()
                .delete("/delete")
                .then()
                .extract().body().jsonPath().getObject("headers", PostmanHeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }
}
