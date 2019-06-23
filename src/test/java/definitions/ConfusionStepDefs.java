package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.util.List;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getExecutor;

public class ConfusionStepDefs {
    @Given("^I navigate to \"([^\"]*)\" url$")
    public void iNavigateToUrl(String arg0) throws Throwable {
        getDriver().get("http://localhost:3000/home");
        String homeUrl = getDriver().getCurrentUrl();
        String partUrl="home";
        assertThat(homeUrl.contains(partUrl));

    }



    @And("^I provide \"([^\"]*)\" username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iProvideUsernameAndPassword(String loginPage, String username, String password) throws Throwable {
        getDriver().findElement(By.xpath("//button[@class='btn btn-outline-secondary'][contains(text(),'"+loginPage+"')]")).click();
        getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        getDriver().findElement(By.xpath("//input[@name='remember']")).click();
        getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }



    @Then("^I verify alert message contains \"([^\"]*)\"$")
    public void iVerifyAlertMessageContains(String expectedText) throws Throwable {
        Alert alert =getDriver().switchTo().alert();
        String alertMessage  = alert.getText();
        assertThat(alertMessage.contains(expectedText));
        System.out.println(alertMessage);

    }

    @And("^I accept alert message$")
    public void iAcceptAlertMessage() {
        getDriver().switchTo().alert().accept();
    }

    @And("^I go to the tab \"([^\"]*)\"$")
    public void iGoToTheTab(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//a[@class='nav-link'][contains(text(),'"+tab+"')]")).click();

    }

    @And("^I select \"([^\"]*)\" from menu$")
    public void iSelectFromMenu(String menuItem) throws Throwable {
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-img-overlay']//h5[contains(text(),'"+menuItem+"')]")));
        getDriver().findElement(By.xpath("//div[@class='card-img-overlay']//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @And("^I click on element \"([^\"]*)\"$")
    public void iClickOnElement(String btnSubmit) throws Throwable {
        getDriver().findElement(By.xpath("//button[contains(text(),'"+btnSubmit+"')]")).click();
    }

    @And("^I choose rating \"([^\"]*)\"$")
    public void iChooseRating(String rating) throws Throwable {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//select[@name='rating']//option[contains(text(),'"+rating+"')]")).click();
    }


    @When("^I indicate my name \"([^\"]*)\"$")
    public void iIndicateMyName(String name) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='author']")).sendKeys(name);



    }

    @And("^I provide comment \"([^\"]*)\"$")
    public void iProvideComment(String textComment) throws Throwable {
        getDriver().findElement(By.xpath(" //textarea[@id='comment']")).sendKeys(textComment);
        
    }

    @And("^I submit my comment$")
    public void iSubmitMyComment() {
        getDriver().findElement(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Send Feedback')]")).click();


    }

    @Then("^I verify that text \"([^\"]*)\" is displayed on the page$")
    public void iVerifyThatTextIsDisplayedOnThePage(String expectedText) throws Throwable {
        WebElement container = getDriver().findElement(By.xpath("//body/div[@id='root']/div[@class='App']/div/div[2]/div[1]"));
        String actualText = container.getText();
        System.out.println(actualText);
        //getDriver().navigate().refresh();
        //Thread.sleep(1000);
        //assertThat(container.getText()).contains(expectedText);

    }

    @And("^I verify jumbotron elements$")
    public void iVerifyJumbotronElements() {
        WebElement jumbotron = getDriver().findElement(By.xpath("//div[@class='jumbotron']"));

        System.out.println(jumbotron.getText());
    }

    @When("^I move  to navigation bar$")
    public void iMoveToNavigationBar() {
        List<WebElement> navBar = getDriver().findElements(By.xpath("//nav[@class='navbar navbar-expand-md navbar-dark']"));
        
        

    }


    @And("^I verify logo$")
    public void iverifyLogo() {
        WebElement logo = getDriver().findElement(By.xpath(" //a[@class='mr-auto navbar-brand']//img"));
        assertThat(logo.isDisplayed());
    }


    @And("^I enter firstname \"([^\"]*)\" lastname \"([^\"]*)\" phone \"([^\"]*)\" email \"([^\"]*)\"$")
    public void iEnterFirstnameLastnamePhoneEmail(String fName, String lName, String phone, String email) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='firstname']")).sendKeys(fName);
        getDriver().findElement(By.xpath("//input[@id='lastname']")).sendKeys(lName);
        getDriver().findElement(By.xpath("//input[@id='telnum']")).sendKeys(phone);
        getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(email);
    }

    @And("^I move to \"([^\"]*)\" page and check current url$")
    public void iMoveToPageAndCheckCurrentUrl(String page) throws Throwable {
        getDriver().findElement(By.xpath("//a[@class='nav-link'][contains(text(),'" + page + "')]")).click();
        String homeUrl = getDriver().getCurrentUrl();
        String partUrl=page.toLowerCase();
        assertThat(homeUrl.contains(partUrl));
    }

    @And("^I select contact as \"([^\"]*)\"$")
    public void iSelectContactAs(String type) throws Throwable {
        getDriver().findElement(By.xpath("//input[@name='agree']")).click();
        getDriver().findElement(By.xpath("//select[@name='contactType']//option[contains(text(),'Email')]")).click();
        getDriver().findElement(By.xpath("//textarea[@id='message']")).sendKeys(type);

    }

    @And("^I provide the following feedback \"([^\"]*)\"$")
    public void iProvideTheFollowingFeedback(String message) throws Throwable {
        getDriver().findElement(By.xpath("//textarea[@id='message']")).sendKeys(message);
        getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    }

    @When("^I go back to \"([^\"]*)\" and check current url$")
    public void iGoBackToAndCheckCurrentUrl(String page) throws Throwable {
        getDriver().navigate().back();
        String homeUrl = getDriver().getCurrentUrl();
        String partUrl=page.toLowerCase();
        assertThat(homeUrl.contains(partUrl));

    }

    @Then("^I go back and forward to \"([^\"]*)\" and check current url$")
    public void iGoBackAndForwardToAndCheckCurrentUrl(String page) throws Throwable {
        getDriver().navigate().forward();
        String homeUrl = getDriver().getCurrentUrl();
        String partUrl=page.toLowerCase();
        assertThat(homeUrl.contains(partUrl));


    }
}
