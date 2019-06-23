package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SsnPage extends Page{
    @FindBy(xpath = "//input[@placeholder='Enter your Social Security number']")
    private WebElement ssnInputField;

    @FindBy(xpath = "//h1[contains(text(),'Social Security number')]")
    private WebElement ssnPrompt;

    @FindBy(xpath = "//button[@id='continue']")
    private WebElement btnGetRate;

    public boolean isSsnInputIsDisplayed() {
        return ssnInputField.isDisplayed();
    }

    public String ssnPromptHeader(){
        return ssnPrompt.getText();
    }
}
