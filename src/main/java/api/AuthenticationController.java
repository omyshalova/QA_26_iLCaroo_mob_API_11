package api;



import dto.RegistrationBodyDto;
import interfaces.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class AuthenticationController implements BaseApi {

    protected Response registrationLogin(RegistrationBodyDto registrationBodyDto, String url){
        return given()
                .body(registrationBodyDto)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+url)
                .thenReturn()
                ;
    }

//    public int statusCodeResponseRegistrationLogin(RegistrationBodyDto registrationBodyDto, String url){
//        Response response = registrationLogin(registrationBodyDto, url);
//        System.out.println(response);
//        return response.getStatusCode();
//    }
}
