package api_tests.okhttptests;

import dto.*;
import interfaces.BaseApi;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Random;

public class AddNewCarTestsOkHttp implements BaseApi {
    TokenDto token = new TokenDto();

    @BeforeClass
    public void login(){
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .username("789baggins_bilbo@mail.com")
                .password("Zxc12345!")
                .build();
        RequestBody requestBody = RequestBody.create(GSON.toJson(registrationBodyDto), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL+LOGIN_URL)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            token = GSON.fromJson(response.body().string(), TokenDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(token);
    }

    @Test
    public void addNewCarPositiveTest(){
        int i = new Random().nextInt(1000) + 1000;
        CarDto car = CarDto.builder()
                .serialNumber("777-" + i)
                .manufacture("Opel")
                .model("Astra")
                .year("2023")
                .fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();
        RequestBody requestBody = RequestBody.create(GSON.toJson(car), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL+ADD_NEW_CAR_URL)
                .addHeader("Authorization",token.getAccessToken())
                .post(requestBody)
                .build();
        Response response;
        String responseBody;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(response.code() == 200){
            try {
                responseBody = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ResponseMessageDto responseMessageDto = GSON.fromJson(responseBody, ResponseMessageDto.class);
            System.out.println(responseMessageDto);
            Assert.assertEquals(responseMessageDto.getMessage(), "Car added successfully");
        }else
            Assert.fail("Error, response code --> "+response.code());

    }
}
