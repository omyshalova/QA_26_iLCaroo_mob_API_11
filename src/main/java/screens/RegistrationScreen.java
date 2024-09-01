package screens;

import dto.RegistrationBodyDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends  BaseScreen{
    public RegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegName']")
    AndroidElement fieldFirstName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    AndroidElement fieldLastName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    AndroidElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    AndroidElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    AndroidElement checkBoxIAgree;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/regBtn']")
    AndroidElement btnYalla;

    public RegistrationScreen typeRegistrationForm(RegistrationBodyDto user) {
        fieldFirstName.sendKeys(user.getFirstName());
        fieldLastName.sendKeys(user.getLastName());
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
        return this;
    }
    public RegistrationScreen clickCheckBoxIAgree(){
        checkBoxIAgree.click();
        return this;
    }

    public SearchScreen clickBtnYallaPositive() {
        btnYalla.click();
        return new SearchScreen(driver);
    }
}
