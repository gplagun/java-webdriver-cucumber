package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleFormNameDialogue extends SampleForm {

        @FindBy(xpath = "//input[@id='firstName']")
        WebElement firstName;

        @FindBy(xpath = "//input[@id='middleName']")
        WebElement middleName;

        @FindBy(xpath = "//input[@id='lastName']")
        WebElement lastName;

        @FindBy(xpath = "//span[contains(text(),'Save')]")
        WebElement save;

        public void firstName(String text) {
            firstName.sendKeys(text);
        }

        public void setmName(String text){
            middleName.sendKeys(text);
        }

        public void lastName(String text) {
            lastName.sendKeys(text);
        }

        public void saveName() {
            save.click();
        }

}
