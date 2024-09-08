package api_tests.rest;

import dto.ErrorMessageDtoString;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.AuthenticationController;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController{

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000)+1000;
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .username("jon_doe123"+i+"@mail.com")
                .password("Qwerty123!")
                .firstName("Jon")
                .lastName("Doe")
                .build();
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getStatusCode(), 200);
    }

    @Test
    public void registrationNegativeTest_WOPassword(){
        int i = new Random().nextInt(1000)+1000;
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .username("jon_doe123"+i+"@mail.com")
                .password("")
                .firstName("Jon")
                .lastName("Doe")
                .build();
        Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getBody()
                .as(ErrorMessageDtoString.class)
                .getError(), "Bad Request");
    }
}
