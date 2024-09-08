package api;

import dto.CarDto;
import dto.TokenDto;
import interfaces.BaseApi;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class CarController implements BaseApi {

    public TokenDto tokenDto;
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void login() {
        String token ="";
        AuthenticationController authenticationController = new AuthenticationController();
        tokenDto = authenticationController.registrationLogin(USER_LOGIN, LOGIN_URL)
                .as(TokenDto.class);
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    protected Response addNewCarResponse(CarDto car, String token) {
        return given()
                .body(car)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .post(BASE_URL + ADD_NEW_CAR_URL)
                .thenReturn();
    }

    protected Response getAllUserCarResponse(String token) {
        return given()
//                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .spec(requestSpecification)
                .when()
                .get(BASE_URL + GET_USER_CARS_URL)
                .thenReturn();
    }

    protected Response deleteCarByIdResponse(String token, String id) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete(BASE_URL + DELETE_CAR_URL + id)
                .thenReturn();
    }
}