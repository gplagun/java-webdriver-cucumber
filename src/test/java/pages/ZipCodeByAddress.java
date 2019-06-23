package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ZipCodeByAddress extends UspsHeader{

    public ZipCodeByAddress(){

    }

    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement byAddress;

    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement byCity;

    @FindBy(xpath = "//select[@id='tState']")
    private WebElement byState;

    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;

    public void fillByAddress(String text){
        sendKeys(byAddress, text);
    }

    public void fillByCity(String text){
        sendKeys(byCity, text);
    }

    public void selectState(String value) {
        click(byState);
        new Select(byState).selectByValue(value);
    }
    public void findByAddress(){
        click(findButton);
    }

}
