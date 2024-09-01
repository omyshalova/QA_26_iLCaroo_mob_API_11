package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    AndroidElement btnThreeDots;
    @FindBy(xpath = "//*[@text='Registration' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnRegistration;
    @FindBy(xpath = "//*[@text='Login' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnLogin;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;

    public SearchScreen clickBtnThreeDots(){
        btnThreeDots.click();
        return this;
    }

    public RegistrationScreen clickBtnRegistration() {
        //pause(2);
        btnRegistration.click();
        return new RegistrationScreen(driver);
    }
    public boolean isTextInElementPresent_popUpMessageSuccess(String text){
        return textInElementPresent(popUpMessageSuccess, text,3);
    }
}
