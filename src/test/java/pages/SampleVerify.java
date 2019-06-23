package pages;

import net.sourceforge.htmlunit.corejs.javascript.commonjs.module.provider.StrongCachingModuleScriptProvider;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class SampleVerify extends Page{
    public SampleVerify(){

    }

    @FindBy(xpath = "//div[@id='samplePageResult']" )
    private WebElement result;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement passwordResult;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContactResult;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//b[@name='phone']")
    private WebElement phoneResult;

    @FindBy(xpath = "//b[@name='dateOfBirth']")
    private WebElement dateOfBirthResult;

    @FindBy(xpath = "//b[@name='username']")
    private WebElement userNameResult;

    @FindBy(xpath = "//b[@name='gender']")
    private WebElement genderResult;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement emailResult;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement nameResult;

    @FindBy(xpath = "//b[@name='currentDate']")
    private WebElement currentDate;



    public String getCurrentDate() {
        return currentDate.getText();
    }

    public String getResult(){
       waitForVisible(result);
        return result.getText();
    }

    //public String getLegendResult(){return legendResult.getText();}

    public String getPasswordResult(){
        return passwordResult.getText();
    }

    public String getNameResult(){
        return nameResult.getText();
    }

    public String getEmailResult(){
        return emailResult.getText();
    }

    public String getPhoneResult(){
        return phoneResult.getText();
    }

    public String getGenderResult(){
        return genderResult.getText();
    }

    public String getUsernameResult(){
        return userNameResult.getText();
    }

    public String getAllowedToContactResult(){
        return allowedToContactResult.getText();
    }

    public String getAgreedToPrivacyPolicy(){
        return agreedToPrivacyPolicy.getText();
    }

    public String getDateOfBirth (){
        return dateOfBirthResult.getText();
    }

}
