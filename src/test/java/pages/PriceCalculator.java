package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PriceCalculator extends Page{

    @FindBy(xpath ="//select[@id='CountryID']")
    private WebElement destCountry;



    public void selectDestCountry(String value){
       new Select(destCountry).selectByVisibleText(value);

    }

    public void chooseShape(String value){
        click(getByXpath("//input[@value='Postcard']"));
    }
}
