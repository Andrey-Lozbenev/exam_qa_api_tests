package dzr.hanom.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import dzr.hanom.Specs.Specs;
import dzr.hanom.models.LoginErrorResponse;
import dzr.hanom.models.UserBody;
import dzr.hanom.models.UserLoginResponse;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static dzr.hanom.Specs.Specs.requestSpecification;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;

public class RequestTests {

    @Test
    @Tag("positive")
    @DisplayName("Проверка успешной авторизации пользователя")
    void successfulLoginTestAssert() {

        UserBody userBody = new UserBody();

        userBody.setEmail("eve.holt@reqres.in");
        userBody.setPassword("cityslicka");

        UserLoginResponse userLoginResponse = given()
                .spec(requestSpecification)
                .body(userBody)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserLoginResponse.class);
        assertEquals("QpwL5tke4Pnpja7X4", userLoginResponse.getToken());
    }

    @Test
    @Tag("negative")
    @DisplayName("Проверка отказа в авторизации пользователя без пароля")
    void unsuccessfulLoginTest() {

        Faker faker = new Faker();
        String userEmail = faker.internet().emailAddress();

        UserBody userBody = new UserBody();

        userBody.setEmail(userEmail);

        given()
                .spec(requestSpecification)
                .body(userEmail)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(400);

    }

    @Test
    @Tag("negative")
    @DisplayName("Проверка отказа в регитсрации у пользовтеля со сторонними регистрационными данными")
    void successfulRegisterTest() {

        Faker faker = new Faker();
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.internet().password();

        UserBody userBody = new UserBody();

        userBody.setEmail(userEmail);
        userBody.setPassword(userPassword);

        LoginErrorResponse loginErrorResponse = given()
                .spec(requestSpecification)
                .body(userBody)
                .when()
                .post("/register")
                .then()
                .log().all()
                .statusCode(400)
                .extract().as(LoginErrorResponse.class);
        assertEquals("Note: Only defined users succeed registration", loginErrorResponse.getError());

    }

    @Test
    @Tag("positive")
    @DisplayName("Проверка успешного удаления чего-то :) ")
    void successfulDeleteTest() {

        given()
                .spec(requestSpecification)
                .when()
                .delete("/users?page=2")
                .then()
                .log().all()
                .statusCode(204)
                .body(isEmptyString());

    }

    @Test
    @Tag("positive")
    @DisplayName("Проверка корректного количества отображениения пользователей на одной странице")
    void successfulUserSearchTest() {


        given()
                .spec(requestSpecification)
                .when()
                .get("/users?page=2")
                .then()
                .log().body()
                .statusCode(200)
                .body("total", is(12));
    }


}

