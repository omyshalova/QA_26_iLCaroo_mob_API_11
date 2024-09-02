package api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.RegistrationBodyDto;
import interfaces.BaseApi;
import static com.jayway.restassured.RestAssured.given;

public class AuthenticationController implements BaseApi {
    private Response registrationLogin(RegistrationBodyDto registrationBodyDto, String url){
        return given()
                .body(registrationBodyDto)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+url)
                .thenReturn();
    }
    public int statusCodeResponseRegistrationLogin(RegistrationBodyDto registrationBodyDto, String url){
        Response response = registrationLogin(registrationBodyDto, url);
        System.out.println(response.toString());
        return response.getStatusCode();
    }
}
