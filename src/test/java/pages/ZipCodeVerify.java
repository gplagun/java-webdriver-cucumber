package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZipCodeVerify extends Page {

    @FindBy(xpath = "/html ")
    private WebElement zipResult;

    public String getZipResult() {
            return zipResult.getText();
        }


}
