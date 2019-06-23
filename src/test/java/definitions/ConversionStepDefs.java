package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ConversionStepDefs {
    @When("^I click on Temperature$")
    public void iClickOnTemperature() {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'Temperature')]")).click();

    }
    ;
    @And("^I set Fahrenheit to Celcius$")
    public void iSetFahrenheitToCelcius() {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[@value = '3']")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[@value='1']")).click();

    }

    @Then("^I enter into From field \"([^\"]*)\" and verify \"([^\"]*)\" result$")
    public void iEnterIntoFromFieldAndVerifyResult(String fromValue, String expectedToValue) throws Throwable {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(fromValue);
        Thread.sleep(5000);
        String actualToValue = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        System.out.println(actualToValue);
        assertThat(actualToValue.equals(expectedToValue));
    }


    @When("^I click on \"([^\"]*)\" tab$")
    public void iClickOnTab(String myTab) throws Throwable {
        String[]tabs = {"Length", "Temperature", "Area", "Volume", "Time"};
        for (String tab:tabs) {
            if (tab.equals(myTab)) {
                getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'" + myTab + "')]")).click();
            }
        } Thread.sleep(5000);
    }

    @And("^I set From \"([^\"]*)\" value To \"([^\"]*)\" value$")
    public void iSetFromValueToValue(String fromValueExpected, String toValueExpected) throws Throwable {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'" + fromValueExpected + "')]")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'" + toValueExpected + "')]")).click();
    }



}

