package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;
import support.TestContext;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static support.TestContext.getDriver;

import static support.TestContext.setDriver;

public class WebDriverStepdDefs {
    @Given("^I go to \"([^\"]*)\" page and print details$")
    public void iGoToPageAndPrintDetails(String page) throws Throwable {
        if(page.equals("google")) {
            TestContext.getDriver().get("http://www.google.com");
        }
        else if (page.equals("sample")){
            TestContext.getDriver().get("https://skryabin.com/webdriver/html/sample.html");
        }


        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getWindowHandle());
        //System.out.println(getDriver().getPageSource());
        System.out.println();

    }
    @And("^I go back and forward then refresh the page$")
    public  void iGoBackAndForwardThenRefreshThePage() throws Throwable {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();

    }
    @And("^I print logs to the console$")
    public void iPintLogsToTheConsole()throws Throwable {

        LogEntries logEntries = getDriver().manage().logs().get("browser");

        for (LogEntry element : logEntries) {
            System.out.println(element);
        }

    }



    @Given("^I open \"([^\"]*)\" then \"([^\"]*)\" then \"([^\"]*)\"$")
    public void iOpenThenThen(String url0, String url1, String url2) throws Throwable {
        String[] urls = {url0, url1,url2};

        for (String url : urls) {
            getDriver().get(url);
            Thread.sleep(500);

        }

        for (int j=0; j<urls.length; j++){
            getDriver().get(urls[j]);
            Thread.sleep(500);

        }

    }

    @And("^I change resolution to \"([^\"]*)\"$")
    public void iChangeResolutionTo(String layout) throws Throwable {
        if(layout.equals("phone")){
            getDriver().manage().window().setSize(new Dimension(400, 768));
        } else if (layout.equals("desktop")){
            getDriver().manage().window().setSize(new Dimension(1024, 768));
        }
            Thread.sleep(500);

    }


    @When("^I fill out first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
    public void iFillOutFirstNameAndLastName(String firstName, String lastName) throws Throwable {
        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();




        Thread.sleep(1000);

    }
    @When("^I fill out required fields$")
    public void iFillOutRequiredFields()throws Throwable {
        getDriver().manage().window().fullscreen();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Lagunova");
       // getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("gplagun@yahoo.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("BeHappy");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("BeHappy");

        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

        Thread.sleep(3000);

    }

    @When("^I submit the form$")
    public void iSubmitTheForm()throws Throwable {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        Thread.sleep(5000);
    }


    @When("^I select \"([^\"]*)\" as country of origin$")
    public void iSelectAsCountryOfOrigin(String country) throws Throwable {

        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();


        Select countries = new Select(getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")));
        countries.selectByVisibleText(country);
        Thread.sleep(5000);



    }

    @When("^I choose \"([^\"]*)\" as date of birth$")
    public void iChooseAsDateOfBirth(String dateOfBirth) throws Throwable {
        //getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys(dateOfBirth);
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
        Select months = new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        months.selectByVisibleText("Jun");
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
        Select years = new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        years.selectByVisibleText("1954");
        getDriver().findElement(By.xpath("//*[@class='ui-state-default'][contains(text(),'10')]")).click();

        Thread.sleep(5000);
    }

    @When("^I specify \"([^\"]*)\" as an option$")
    public void iSpecifyAsAnOption(String carModel) throws Throwable {
        getDriver().findElement(By.xpath("//select[@name='carMake']")).sendKeys(carModel);
        

        Thread.sleep(5000);


    }


    @When("^I read a warning message$")
    public void iReadAWarningMessage() {
        String alertMessage;
        alertMessage=getDriver().switchTo().alert().getText();
        System.out.println(alertMessage);

    }

    @Then("^I check \"([^\"]*)\" is displayed$")
    public void iCheckIsDisplayed(String text) throws Throwable {
        String summary = getDriver().findElement(By.xpath("//div[@class='well form-summary']")).getText();
        if (summary.contains(text)){
            System.out.println(text);
            System.out.println(summary);
        }




    }

    @When("^I verify email field behavior$")
    public void iVerifyEmailFieldBehavior() throws Throwable{
        WebElement email = getDriver().findElement(By.xpath("//input[@name='email']"));
        email.clear();
        email.sendKeys("galina.lagunova.com");
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        Thread.sleep(5000);
        String emailErrMessage = getDriver().findElement(By.xpath("//label[@id='email-error']")).getText();
        assertThat(emailErrMessage.contains("enter a valid email"));

        email.sendKeys(Keys.BACK_SPACE);
        email.clear();
        email.sendKeys("galina@lagunova.com");
        boolean errorDisplayed = getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed();
        assertThat(errorDisplayed).isFalse();

    }

    @Then("^I verify submitted data$")
    public void iVerifySubmittedData() throws Throwable{

    Boolean legendDisplayed = getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).isDisplayed();
    assertThat(legendDisplayed).isTrue();
    String formRes = getDriver().findElement(By.xpath("//div[@class='well form-container container-fluid']")).getText();
    assertThat(formRes.contains("Galina"));
    assertThat(formRes.contains("Lagunova"));
    assertThat(formRes.contains("galina.lagunova.com"));
    Boolean passwordEntered = getDriver().findElement(By.xpath("//b[@name='password']/..//span[contains(text(),'Password')]")).isDisplayed();
    assertThat(passwordEntered).isTrue();
    String passwordText = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
    assertThat(passwordText).doesNotContain("BeHappy");

    }
}
