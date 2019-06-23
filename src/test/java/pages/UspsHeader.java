package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsHeader extends Page{

    public UspsHeader(){
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath = "//a[@id='mail-ship-width']")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[@class='tool-zip']//a")
    private WebElement lookUpByZip;

    @FindBy(xpath = "//li[@class='tool-calc']//a")
    private WebElement calcPrice;

    @FindBy(xpath = "//*[@href='https://store.usps.com/store']")
    private WebElement postalStore;

    @FindBy(xpath = "//a[contains(text(),'Stamps & Supplies')]")
    private WebElement stampsAndSupplies;

    @FindBy(xpath = "//*[contains(@class,'stamps-navigation')]")
    private WebElement stamps;

    @FindBy(xpath = "//label[ contains(text(), 'Priority Mail')][not(contains(text(),'Express'))]")
    private WebElement priorityMail;



    public void mouseoverMailAndShip(){
        moveToElement(mailAndShip);
    }

    public void clickLookUpByZip(){
        click(lookUpByZip);
    }

    public void clickCalcPrice() {click(calcPrice);}

    public void clickPostalStore(){click(postalStore);}

    public void clickStampsAndSupplies() {
        click(stampsAndSupplies);
    }

    public void clickPriorityMail(){
        click(priorityMail);
    }

    public void clickStamps(){
        click(stamps);
    }
}
