package api_tests.rest;

import api.CarController;
import dto.CarDto;
import dto.ErrorMessageDtoString;
import dto.Fuel;
import dto.TokenDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTestsRest extends CarController {

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
        Assert.assertEquals(addNewCarResponse(car, tokenDto.getAccessToken()).getStatusCode(), 200);
    }
    @Test
    public void addNewCarNegativeTest_WOToken_validateStatusCode(){
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
        Assert.assertEquals(addNewCarResponse(car, "").getStatusCode(), 401);
    }
    @Test
    public void addNewCarNegativeTest_WOSerialNumber_validateMessage(){
        int i = new Random().nextInt(1000) + 1000;
        CarDto car = CarDto.builder()
                //.serialNumber("777-" + i)
                .manufacture("Opel")
                .model("Astra")
                .year("2023")
                .fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.23)
                .city("Haifa")
                .build();
        System.out.println(addNewCarResponse(car, tokenDto.getAccessToken()).getBody().print());
        Assert.assertTrue(addNewCarResponse(car, tokenDto.getAccessToken()).getBody().print().contains("must not be blank"));
    }
}
