package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostcardCalculator extends Page {

    @FindBy(xpath = "//input[@id='quantity-0']")
    private WebElement quantity;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement buttonCalculate;

    @FindBy(xpath = "//div[@id='total']")
    private WebElement totalResult;

    public void fillQuantity(String text){
        sendKeys(quantity, text);
    }

    public void clickCalculate(){
        click(buttonCalculate);
    }

    public String totalResult(){
        return totalResult.getText();
    }
}
