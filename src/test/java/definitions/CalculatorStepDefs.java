package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefs {

    @Given("^I locate \"([^\"]*)\" page$")
    public void iLocatePage(String arg0) throws Throwable {
        getDriver().get("https://www.calculator.net/");
    }
    @When("^I follow \"([^\"]*)\"$")
    public void iFollow(String link) throws Throwable {
        getDriver().findElement(By.xpath("//a[contains(text(),'"+link+"')]")).click();

    }

    @And("^I clear all calculator fields$")
    public void iClearAllCalculatorFields() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
    }

    @And("^I calculate$")
    public void iCalculate() throws Throwable{
        getDriver().findElement(By.xpath("//*//input[@value='Calculate']")).click();

    }

    @Then("^I verify \"([^\"]*)\" calculation error$")
    public void iVerifyCalculationError(String expectedText) throws Throwable {
        String actualText=getDriver().findElement(By.xpath("//font[contains(text(),'"+expectedText+"')]")).getText();
        assertThat(actualText.equals(expectedText));
        System.out.println(actualText);

    }

    @And("^I enter \"([^\"]*)\" price, \"([^\"]*)\" months, \"([^\"]*)\" interest, \"([^\"]*)\" downpayment, \"([^\"]*)\" trade-in, \"([^\"]*)\" state, \"([^\"]*)\" percent tax, \"([^\"]*)\" fees$")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradein, String state, String tax, String fees) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradein);
        getDriver().findElement(By.xpath("//select[@name='cstate']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'"+state+"')]")).click();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);

        Thread.sleep(5000);
    }

    @Then("^I verify \"([^\"]*)\" monthly pay$")
    public void iVerifyMonthlyPay(String expectedRes) throws Throwable {
        String actualRes = getDriver().findElement(By.xpath("//*[@class='h2result']")).getText();
        assertThat(actualRes.contains(expectedRes));
        System.out.println(actualRes);

    }
}
