package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Prosper extends Page{
    public Prosper(){
        setUrl("https://www.prosper.com/");
    }

    @FindBy(xpath = "//a[@id='intro-cta']")
    private WebElement btnCheckYourRate;


    public void clickCheckYourRate(){
        click(btnCheckYourRate);
    }
}
