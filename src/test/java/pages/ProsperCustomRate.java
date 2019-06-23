package pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProsperCustomRate extends Page{

    @FindBy(xpath = "//input[@id='loan-amount']")
    private WebElement loanAmount;

    @FindBy(xpath = "//select[@id='listing-category-id']")
    private WebElement loanPurpose;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='date-of-birth-text']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@id='home-address']")
    private WebElement homeAddress;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityName;

    @FindBy(xpath = "//select[@id='state']")
    private WebElement stateSelection;

    @FindBy(xpath = "//input[@id='monthly-housing-payment']")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//select[@id='employment_status_id']")
    private  WebElement employmentStatus;

    @FindBy(xpath = "//input[@id='individual-yearly-income']")
    private WebElement yearlyIncome;

    @FindBy(xpath = "//input[@id='additional-income']")
    private WebElement additionalIncome;

    @FindBy(xpath = "//input[@id='home_phone']")
    private WebElement contactPhone;

    @FindBy(xpath = "//div[@class='toggle-button-tcpa toggle_yes__icon']")
    private WebElement toggleBtn;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Create Password']")
    private WebElement pwdField;

    @FindBy(xpath = "//input[@id='credit-report-authorization']")
    private WebElement authorization;

    @FindBy(xpath = "//button[@id='continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//div[@class='reveal-modal fade login-modal in']")
    private WebElement modal;


    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement modalPassword;

    @FindBy(xpath = "//button[@id='modal-sign-in']")
    private WebElement modalBtnSubmit;



    public void clickModalBtnSubmit(){
        click(modalBtnSubmit);
    }

    public void fillModalPassword(String password){
        sendKeys(modalPassword, password);
    }

    public boolean isModalDisplayed(){
        return modal.isDisplayed();
    }

    public void fillLoanAmount(String amount){
        sendKeys(loanAmount, amount);
    }


    public void selectLoanPurpose(String value){
        new Select(loanPurpose).selectByValue(value);
    }

    public void fillFirstName(String fName){
        sendKeys(firstName, fName);
    }

    public void fillLastName(String lName){
        sendKeys(lastName, lName);
    }

    public void fillDateOfBirth(String date){
        sendKeys(dateOfBirth, date);
    }

    public void fillZipCode(String zip){
        sendKeys(zipCode, zip);
    }

    public  void fillHomeAddress(String address){
        sendKeys(homeAddress, address);
    }

    public void fillCity( String city){
        sendKeys(cityName, city);
    }

    public void selectState(String state){
        new Select(stateSelection).selectByValue(state);
    }

    public void fillMonthlyPayment(String payment){
        sendKeys(monthlyPayment, payment);
    }

    public void selectEmploymentStatus(String empStatus){
        new Select(employmentStatus).selectByValue(empStatus);
    }

    public void fillYearlyIncome(String income){
        sendKeys(yearlyIncome, income);
    }

    public void fillAdditionalIncome(String addincome){
        sendKeys(additionalIncome, addincome);
    }

    public void fillContactPhone(String phone){
        sendKeys(contactPhone, phone);
    }

    public void selectToggleButton(){
        click(toggleBtn);
    }

    public void fillEmail(String email){
        sendKeys(this.email, email);
    }

    public void createPassword (String password){
        sendKeys(pwdField, password);
    }

    public void checkAthorization(){
        click(authorization);
    }

    public void clickViewOffer(){
        click(btnContinue);
    }
}
