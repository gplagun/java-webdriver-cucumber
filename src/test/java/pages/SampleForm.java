package pages;

import org.apache.bcel.generic.NEW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.security.PrivateKey;

import static support.TestContext.*;

public class SampleForm extends Page{

    public SampleForm (){
        setUrl("https://skryabin.com/webdriver/html/sample.html");
    }

//    public SampleForm(String url){
//        setUrl(url);
//    }

    @FindBy (xpath = "//input[@name='username'] ")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement fillEmail;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement fillPassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;


    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNum;

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement countryOfOrigin;

    @FindBy(xpath = "//input[@name='gender'][@value='female']")
    private WebElement checkGender;

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement checkAllowContact;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement fullAddress;

    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyButton;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//label[@id='password-error']")
    private WebElement passwordError;

    @FindBy(xpath = "//label[@id='email-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//input[@id='contactPersonName']")
    private WebElement contactPersonName;

    @FindBy(xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPersonPhone;

    @FindBy(xpath = "//iframe[@name='additionalInfo']")
    private WebElement iframeAddInfo;

    @FindBy(xpath = "//b[@id='currentDate']")
    private WebElement currentDate;


    public String getCurrentDate(){
        return currentDate.getText();
    }



    public String getDate() {
        Date curdate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(curdate);
        return date;
    }



    public void fillContactPersonName(String text){
        getDriver().switchTo().frame(iframeAddInfo);
        sendKeys(contactPersonName,text);
        getDriver().switchTo().defaultContent();
    }

    public void fillContactPersonPhone(String text){
        getDriver().switchTo().frame(iframeAddInfo);
        sendKeys(contactPersonPhone,text);
        getDriver().switchTo().defaultContent();
    }


    public boolean isEmailErrorDisplayed() { return emailErrorMessage.isDisplayed(); }

    public void selectDateOfBirth(){
        click(dateOfBirth);
    }

    public boolean isConfirmPasswordDisabled(){
        return !confirmPassword.isEnabled();
    }

    public boolean isConfirmPasswordEnabled(){
        return confirmPassword.isEnabled();
    }

    public boolean isPasswordErrorDisplayed(){
        return passwordError.isDisplayed();
    }

//    public boolean passwordMinimalLength(String text) {
//        int passwordLength = fillPassword.getText().length();
//        sendKeys(fillPassword, text);
//        click(confirmPassword);
//        if (passwordLength < 5) {
//            passwordError.isDisplayed();
//        }
//        return passwordError.isDisplayed();
//    }

    public String passwordMasked(){
        return fillPassword.getAttribute("type");
    }


    public void acceptThirdPartyButtonAgreement(){
        click(thirdPartyButton);
        getDriver().switchTo().alert().accept();
    }

    public void declineThirdPartyButtonAgreement(){
        click(thirdPartyButton);
        getDriver().switchTo().alert().dismiss();
    }


    public void chooseGender(String value){

        click(getByXpath("//input[@name='gender'][@value='"+value+"']"));
    }




    public void fillUserName (String text){
        sendKeys(username, text);
    }
    public void fillEmail (String text){
        sendKeys(fillEmail, text);
    }


    public void fillPassword (String text){
        sendKeys(fillPassword, text);
    }

    public void  fillConfirmPassword (String text){
        sendKeys(confirmPassword,text);
    }

    public void clickName() {
        name.click();
    }

    public void fillName(String fName, String mName, String lName){
        name.click();
        SampleFormNameDialogue nameDialogue = new SampleFormNameDialogue();
        nameDialogue.firstName.sendKeys(fName);
        nameDialogue.middleName.sendKeys(mName);
        nameDialogue.lastName.sendKeys(lName);
        nameDialogue.save.click();

    }


    public void clickPrivacyPolicy(){
        //privacyPolicy.click();
        //waitForVisible(privacyPolicy);
        //clickWithJS(privacyPolicy);
        click(privacyPolicy);
    }

    public void clickSubmitButton (){
       // submitButton.click();
        //waitForVisible(submitButton);
     //clickWithJS(submitButton);
        click(submitButton);
    }

    public void fillPhoneNum(String text){
        sendKeys(phoneNum, text);
    }



    public void selectCountryOfOrigin(String value){


    }


    public void clickAllowContact(){
        click(checkAllowContact);
    }

    public void fillAddress(String text){
        sendKeys(fullAddress,text);
    }

}

