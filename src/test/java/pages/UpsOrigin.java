package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpsOrigin extends Page{
    public UpsOrigin(){
        setUrl("https://www.ups.com/ship/guided/origin");
    }

    @FindBy (xpath = "//input[@id='originname']")
    private WebElement originName;

    @FindBy (xpath = "//input[@id='originaddress1']")
    private WebElement originAddress;

    @FindBy(xpath = "//input[@id='originpostal']")
    private WebElement originZip;

    @FindBy(xpath = "//input[@id='origincity']")
    private WebElement originCity;

    @FindBy(xpath = "//select[@id='originstate']")
    private WebElement originState;

    @FindBy(xpath = "//input[@id='originemail']")
    private WebElement originEmail;

    @FindBy(xpath = "//input[@id='originphone']")
    private WebElement originPhone;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement originContinueBtn;

    @FindBy(xpath = "//select[@id='origincountry']")
    private WebElement originCountry;



    public void selectCountry(String country){
        new Select(originCountry).selectByValue(country);
    }
    public void fillName(String name){
        sendKeys(originName, name);
    }
    public void fillAddress(String address){ sendKeys(originAddress, address);}
    public void fillZip(String zip){ sendKeys(originZip, zip);}
    public void fillCity(String city){ sendKeys(originCity, city);}
    public void selectState(String state){
    new Select(originState).selectByVisibleText(state);
    }
    public  void fillEmail(String email){sendKeys(originEmail, email);}
    public void fillPhone(String phone){sendKeys(originPhone, phone);}
    public void clickContinue(){click(originContinueBtn);}




}
