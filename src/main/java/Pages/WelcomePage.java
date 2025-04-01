package Pages;

import BasePage.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends Base {

    public WelcomePage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='w-fit z-10']")
    public WebElement linqLogo;
    @FindBy(css = "#input-3")
    public WebElement backGroundColor;
    @FindBy(xpath = "//div[@class='flex flex-col gap-4 pb-4']/ion-button[1]")
    public WebElement emailButton;
    @FindBy(xpath = "//input[starts-with(@id, 'input-')]")
    public WebElement emailAddressField;
    @FindBy(css = "[data-test='pageHeader:title']")
    public WebElement signInWithEmailText;
    @FindBy(css = "[data-test='pageHeader:title']")
    public WebElement signUpText;


    public void inputFieldPhoneNumber(String blur){
       sendKeysToElement(backGroundColor, blur);
    }
    public void clickEmailButton(){
        clickOnElement(emailButton);
    }
    public void  inputFieldEmailAddress(String emailAddress){
        sendKeysToElement(emailAddressField, emailAddress);
    }




}
