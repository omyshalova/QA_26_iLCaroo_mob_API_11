package rest;

import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.AuthenticationController;

import java.util.Random;

public class RegistrationTestRest extends AuthenticationController{



    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .username("jon_doe_123" + i + "@mail.com")
                .password("Qwerty123!")
                .firstName("Jon")
                .lastName("Doe")
                .build();
        Assert.assertEquals(statusCodeResponseRegistrationLogin(registrationBodyDto, REGISTRATION_URL), 200);
    }

}
