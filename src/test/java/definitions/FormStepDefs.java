package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Tr;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DatePicker;
import pages.SampleForm;
import pages.SampleFormNameDialogue;
import pages.SampleVerify;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;
import static support.TestContext.getData;

public class FormStepDefs {
    @When("^I fill out all fields$")
    public void iFillOutAllFields() throws Throwable {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("gplagun");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("gplagun@yahoo.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("BeHappy");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("BeHappy");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Galina");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Lagunova");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("650-215-0000");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@value='5']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value='1954']")).click();
        getDriver().findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='10']")).click();
        getDriver().findElement(By.xpath(" ")).click();
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Belarus']")).click();
        getDriver().findElement(By.xpath("//input[@name='gender'][@value='female']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("465 Wilson Ave, Sunnyvale,CA 94086");
        WebElement iframe =getDriver().findElement(By.xpath("//iframe[@name='additionalInfo']"));
        new Actions(getDriver()).moveToElement(iframe).perform();
        WebElement toyota = getDriver().findElement(By.xpath("//option[@value='Toyota']"));
        WebElement bmw = getDriver().findElement(By.xpath("//option[@value='BMW']"));
        new Actions(getDriver()).keyDown(Keys.COMMAND).click(toyota).click(bmw).keyUp(Keys.COMMAND).perform();

        WebElement thirdPartyButton = getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']"));

        getExecutor().executeScript("arguments[0].click()", thirdPartyButton);

        String alertMessage = getDriver().switchTo().alert().getText();
        assertThat(alertMessage.contains("Do you accept third party agreement?"));
        System.out.println(alertMessage);
        getDriver().switchTo().alert().accept();
        getDriver().switchTo().frame(iframe);
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//*[@id='contactPersonPhone']")).sendKeys("1234567890");
        getDriver().switchTo().defaultContent();


//        String originalWindow = getDriver().getWindowHandle();
//
//        for(String handler : getDriver().getWindowHandles()){
//            getDriver().switchTo().window(handler);
//        }
//        assertThat(getDriver().getTitle().equals("Documents Page"));
//        String pageText = getDriver().findElement(By.xpath("//html")).getText();
//        assertThat(pageText.contains("Document 2"));
//        getDriver().close();
//
//       // getDriver().switchTo().window(originalWindow);



        Thread.sleep(5000);

        getDriver().findElement(By.xpath("//input[@id='attachment']")).sendKeys("/Users/romanlagunov/Documents/GALINA_LAGUNOVA_SQA.docx");





        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();



    }

    @Then("^I verify all filled out fields$")
    public void iVerifyAllFilledOutFields() throws Throwable{

        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[@name='password']")));
        WebElement result = getDriver().findElement(By.xpath("//legend[@class='applicationResult']"));
        WebElement container = getDriver().findElement(By.xpath("//legend[@class='applicationResult']/../section"));

        assertThat(container.getText().contains("Lagunova"));
        assertThat(container.getText().contains("06/101954"));
        assertThat(container.getText().contains("650-215-0000"));
        assertThat(container.getText().contains("Toyota, BMW"));
        assertThat(container.getText().contains("gplagun@yahoo.com"));

        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password.equals("BeHappy"));
        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");

    }

    @When("^I fill out all page object fields$")
    public void iFillOutAllPageObjectFields() throws Throwable{
        SampleForm form = new SampleForm();

        form.getDate();
        form.fillUserName(getData("username"));
        form.fillEmail(getData("email"));
        form.fillPassword(getData("password"));
        form.fillConfirmPassword(getData("confirmPassword"));
        form.fillName(getData("fName"), "", getData("lName"));
        Thread.sleep(5000);
        form.fillPhoneNum(getData("phoneNum"));
        //form.selectDateOfBirth();
        DatePicker datePicker = new DatePicker();
        form.selectDateOfBirth();
        datePicker.selectDate("5", "10","1954");
        //form.fillDateOfBirth(getData("dateOfBirth"));
        form.selectCountryOfOrigin(getData("countryOfOrigin"));
        form.chooseGender(getData("gender"));
        form.fillAddress(getData("fullAddress"));
        form.clickAllowContact();
        form.clickPrivacyPolicy();
        form.acceptThirdPartyButtonAgreement();
        form.fillContactPersonName(getData("contactPersonName"));
        form.fillContactPersonPhone(getData("contactPersonPhone"));

    }

    @Given("^I open sample page$")
    public void iOpenSamplePage() {
        new SampleForm().open();
    }

    @And("^I submit shipment form and verify new page object form$")
    public void iSubmitShipmentFormAndVerifyNewPageObjectForm() throws Throwable{
        new SampleForm().clickSubmitButton();
        Thread.sleep(5000);
    }

    @Then("^I verify all page object fields$")
    public void iVerifyAllPageObjectFields()throws Throwable {
        SampleVerify verifyPage = new SampleVerify();
        String result = verifyPage.getResult();
        System.out.print(result);
        assertThat(result).contains(getData("username"));
        assertThat(result).contains(getData("email"));
        assertThat(result).contains(getData("fName"));
        assertThat(result).contains(getData("lName"));
   //
        assertThat(result).contains(getData( "dateOfBirth"));

        assertThat(result).contains(getData( "fullAddress"));
        assertThat(result).contains(getData( "gender"));
        assertThat(result).contains(getData( "countryOfOrigin"));

        assertThat(verifyPage.getPasswordResult().contains("true"));
        assertThat(verifyPage.getAllowedToContactResult().contains("true"));
        assertThat(verifyPage.getAgreedToPrivacyPolicy().contains("true"));
        assertThat(result).contains(getData("contactPersonName"));
        assertThat(result).contains(getData("contactPersonPhone"));

    }

    @When("^I verify confirm password field is disabled$")
    public void iVerifyConfirmPasswordFieldIsDisabled() throws Throwable{
        assertThat(new SampleForm().isConfirmPasswordDisabled()).isTrue();
    }


    @And("^I verify that password field requires (\\d+) characters$")
    public void iVerifyThatPasswordFieldRequiresCharacters(int minSize){
        SampleForm form = new SampleForm();
        for (int i = 0; i<minSize-1; i++){
            form.fillPassword("A");
        }
        form.clickSubmitButton();
        assertThat(form.isPasswordErrorDisplayed()).isTrue();

        form.fillPassword("A");
        assertThat(form.isPasswordErrorDisplayed()).isFalse();

       //assertThat(new SampleForm().passwordMinimalLength("abcd"));

    }

    @And("^I verify that password field is masked$")
    public void iVerifyThatPasswordFieldIsMasked()throws Throwable {
        assertThat(new SampleForm().passwordMasked().equals("password"));


    }

    @When ("^I verify confirm password field is enabled when password filled$")
    public void iVerifyConfirmPasswordFieldIsEnabledWhenPasswordFilled() throws Throwable {
        SampleForm form = new SampleForm();
        form.fillPassword(getData("password"));
        assertThat(form.isConfirmPasswordEnabled()).isTrue();
    }

    @And ("^I verify that email does not  accept invalid format$")
    public void iVerifyThatEmailDoesNotAcceptInvalidFormat() throws Throwable {
        SampleForm form = new SampleForm();
        form.fillEmail("wrong format");
        form.clickSubmitButton();
        assertThat(form.isEmailErrorDisplayed()).isTrue();

    }


    @And ("^I fill out contact person name$")
    public void iFillOutContactPersonName() {
        SampleForm form = new SampleForm();
        form.fillContactPersonName("Will Smith");
    }

    @And ("^I fill out contact person phone$")
    public void iFillOutContactPersonPhone() {
        new SampleForm().fillContactPersonPhone("911-000-1111");
    }

    @Then ("^I verify application date is today's date$")
    public void iVerifyApplicationDateIsTodaySDate() throws Throwable{
        SampleForm form = new SampleForm();
        String applicationDate = form.getCurrentDate();
        String date = form.getDate();
        assertThat(applicationDate.equals(date)).isTrue();
    }

    @When ("^I verify that email doesn't accept \"([^\"]*)\" format$")
    public void iVerifyThatEmailDoesnTAcceptFormat(String invalidEmail) throws Throwable {
        SampleForm form = new SampleForm();
        form.fillEmail(invalidEmail);
        form.clickSubmitButton();
        assertThat(form.isEmailErrorDisplayed()).isTrue();
    }
}
