package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UpsDestination;
import pages.UpsOrigin;


import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.*;

public class UpsStepDefs {
    @Given ("^I go to \"([^\"]*)\" page$")
    public void iGoToPage(String url) throws Throwable {
        if (url.equals("ups")) {
            getDriver().get("https://www.ups.com/us/en/Home.page");
        } else if (url.equals("sample")) {
            getDriver().get("https://skryabin.com/webdriver/html/sample.html");
        } else if (url.equals("macys")) {
            getDriver().get("https://www.macys.com/");
        }
    }

    @When ("^I open \"([^\"]*)\" menu item$")
    public void iOpenMenuItem(String menuItem) throws Throwable {
        getDriver().findElement(By.xpath("//a[contains(text(), '" + menuItem + "')][@aria-expanded='false']")).click();

    }

    @And ("^I open \"([^\"]*)\" submenu item$")
    public void iOpenSubmenuItem(String subMenuItem) throws Throwable {
        getDriver().findElement(By.xpath("//a[text()='" + subMenuItem + "']")).click();

    }

    @And ("^I submit calculation form$")
    public void iSubmitCalculationForm() throws Throwable {
        //getDriver().findElement(By.xpath("//*[contains(@name,'submit')]")).click();
        List<WebElement> submitElements = getDriver().findElements(By.xpath("//*[contains(@name,'submit')]"));
        for (WebElement element : submitElements) {
            if (element.isDisplayed()) {
                element.click();
            }
            Thread.sleep(1000);
        }
    }


    @Then ("^I verify \"([^\"]*)\" form error$")
    public void iVerifyFormError(String expectedError) throws Throwable {
        String actualText = getDriver().findElement(By.xpath("//div[@id='module1edit']")).getText();

    }

    @When ("^I enter from \"([^\"]*)\" and \"([^\"]*)\" zip$")
    public void iEnterFromAndZip(String fromCity, String fromZip) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='orig_City']")).sendKeys(fromCity);
        getDriver().findElement(By.xpath("//input[@id='orig_PostalCode']")).sendKeys(fromZip);


    }

    @And ("^I enter to \"([^\"]*)\" and \"([^\"]*)\"zip$")
    public void iEnterToAndZip(String toCity, String toZip) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='dest_City']")).sendKeys(toCity);
        getDriver().findElement(By.xpath("//input[@id='dest_PostalCode']")).sendKeys(toZip);

    }

    @And ("^I enter \"([^\"]*)\" lbs weight$")
    public void iEnterLbsWeight(String weight) throws Throwable {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//input[@id='weightValueSec']")).sendKeys(weight);
    }


    @Then ("^I verify results contain \"([^\"]*)\" text$")
    public void iVerifyResultsContainText(String expectedText) throws Throwable {
        String resultsText = getDriver().findElement(By.xpath("//div[@id='results']")).getText();
        assertThat(resultsText.contains(expectedText));
    }

    @And ("^I fill out \"([^\"]*)\" dropdown with \"([^\"]*)\"$")
    public void iFillOutDropdownWith(String dropdown, String country) throws Throwable {
        getDriver().findElement(By.xpath("//select[@formcontrolname='" + dropdown + "']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'" + country + "')]")).click();

    }

    @And ("^I submit shipment form$")
    public void iSubmitShipmentForm() throws Throwable {
        WebElement footer = getDriver().findElement(By.xpath("//span[@id='ups-footer_custServe2']"));
        new Actions(getDriver()).moveToElement(footer).perform();
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();


    }

    @Then ("^I verify \"([^\"]*)\" field has error \"([^\"]*)\"$")
    public void iVerifyFieldHasError(String fieldName, String expectedErrorMessage) throws Throwable {
        String actualErrorMessage = getDriver().findElement(By.xpath("//p[contains(text(),'" + expectedErrorMessage + "')]")).getText();
        assertThat(actualErrorMessage.equals(expectedErrorMessage));


    }

    @When ("^I fill out \"([^\"]*)\" field with \"([^\"]*)\"$")
    public void iFillOutFieldWith(String fieldName, String text) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),' " + fieldName + " ')]/..//input")).sendKeys(text);

    }

    @When ("^I clear \"([^\"]*)\" field$")
    public void iClearField(String fieldName) throws Throwable {
        getDriver().findElement(By.xpath("//*[@name='" + fieldName + "']")).clear();


    }


    @Then ("^I verify that ship from section contains \"([^\"]*)\"$")
    public void iVerifyThatShipFromSectionContains(String expectedShipFrom) throws Throwable {
        String actualShipFrom = getDriver().findElement(By.xpath("//div[@class='ups-section']")).getText();
        assertThat(actualShipFrom.contains(expectedShipFrom));
    }

    @And ("^I cancel shipment$")
    public void iCancelShipment() throws Throwable {
        WebElement footer = getDriver().findElement(By.xpath("//span[@id='ups-footer_custServe2']"));
        new Actions(getDriver()).moveToElement(footer).perform();
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")).click();
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();

    }

    @Then ("^I verify shipment is cancelled$")
    public void iVerifyShipmentIsCancelled() throws Throwable {
        Thread.sleep(1000);
        WebElement fromTitle = getDriver().findElement(By.xpath("//h2[@class='ups-section_heading ups-centered_header text-center ng-star-inserted']"));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(fromTitle));
        assertThat(fromTitle.isDisplayed()).isTrue();
        WebElement fromName = getDriver().findElement(By.xpath("//input[@id='originname']"));
        String value = fromName.getAttribute("value");
        assertThat(value).isEmpty();


    }

    @When ("^I change to a different locale$")
    public void iChangeResolutionToADifferentLocale() throws Throwable {
        getDriver().findElement(By.xpath("//span[@class='ups-language-text make-fluid']")).click();
        getDriver().findElement(By.xpath(" //a[contains(text(),'Select Another Country or Territory')]")).click();
    }


    @And ("^I change region to \"([^\"]*)\", country to \"([^\"]*)\"$")
    public void iChangeRegionToCountryTo(String region, String country) throws Throwable {
        WebElement header = getDriver().findElement(By.xpath("//h1[contains(text(),'SELECT A REGION')]"));
        new Actions(getDriver()).moveToElement(header).perform();
        new Actions(getDriver()).sendKeys(Keys.PAGE_UP).perform();
        getDriver().findElement(By.xpath("//a[text()='" + region + "']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'" + country + "')]")).click();


    }


    @Then ("^I verify total charges \"([^\"]*)\"$")
    public void iVerifyTotalCharges(String expectedTotal) throws Throwable {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='ng-tns-c1-0']")));
        WebElement actualTotalCharges = getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']"));
        assertThat(actualTotalCharges.getText().contains(expectedTotal));

    }

    @When ("^I fill out Packaging Type dropdown with \"([^\"]*)\"$")
    public void iFillOutPackagingTypeDropdownWith(String packageType) throws Throwable {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']")).click();
        getDriver().findElement(By.xpath("//option[contains(text(),'" + packageType + "')]")).click();

    }

    @When ("^I select \"([^\"]*)\" shipment option$")
    public void iSelectShipmentOption(String cost) throws Throwable {
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double cheapestCost = Double.MAX_VALUE;
        List<WebElement> options = getDriver().findElements(By.xpath("//fieldset//p//strong"));
        for (WebElement option : options) {
            if (option.isDisplayed()) {
                double currentCost = formatter.parse(option.getText()).doubleValue();
                if (currentCost < cheapestCost) {
                    cheapestCost = currentCost;

                }
            }
        }
        System.out.println(cheapestCost);
        System.out.println(formatter.format(cheapestCost));
        Thread.sleep(5000);
        // getDriver().findElement(By.xpath("//strong[contains(text(),'"+cheapestCost+"')]")).click();

        WebElement cheapestPriceElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + formatter.format(cheapestCost) + "')]"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click()", cheapestPriceElement);
        //getExecutor().executeScript("arguments[0].click()",cheapestPriceElement).;

        // cheapestPriceElement.click();
    }

    @And ("^I fill out package weight field with \"([^\"]*)\"$")
    public void iFillOutPackageWeightFieldWith(String weight) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys(weight);

    }

    @And ("^I enable \"([^\"]*)\"$")
    public void iEnable(String deliveryOption) throws Throwable {
        WebElement stage4Heading = getDriver().findElement(By.xpath("//h2[@class='ups-section_heading ups-centered_header text-center']"));
        assertThat(stage4Heading.getText().contains("Almost done."));
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//strong[contains(text(),'" + deliveryOption + "')]/../../..//span[@class='ups-lever_switch']")).click();

    }

    @And ("^I verify I'm on \"([^\"]*)\" page$")
    public void iVerifyIMOnPage(String pageName) throws Throwable {
        new Actions(getDriver()).sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        WebElement paymentCard = getDriver().findElement(By.xpath("//div[@id='tile-3']//label[@class='ups-tile_button_content']"));
        assertThat(paymentCard.isDisplayed()).isTrue();

        if (pageName.equalsIgnoreCase("Payment")) {
            assertThat(getDriver().getCurrentUrl().contains("payment"));
        } else if (pageName.equalsIgnoreCase("Details")) {
            assertThat(getDriver().getCurrentUrl().contains("options"));
        } else if (pageName.equalsIgnoreCase("How")) {
            assertThat(getDriver().getCurrentUrl().contains("pickup-service"));
        } else if (pageName.equalsIgnoreCase("What")) {
            assertThat(getDriver().getCurrentUrl().contains("package"));
        } else if (pageName.equalsIgnoreCase("Where")) {
            assertThat(getDriver().getCurrentUrl().contains("destination"));
        }
        WebElement stepCircle = getDriver().findElement(By.xpath("//span[text()='" + pageName + "']/../../div[contains(@class,'ups-progress_number')]"));
        assertThat(stepCircle.getAttribute("class")).contains("ups-progress_current");
    }

    @And ("^I submit shipment form and verify new page opens$")
    public void iSubmitShipmentFormAndVerifyNewPageOpens() {
        String oldurl = getDriver().getCurrentUrl();
        WebElement footer = getDriver().findElement(By.xpath("//span[@id='ups-footer_custServe2']"));
        new Actions(getDriver()).moveToElement(footer).perform();
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldurl)));
    }

    @And ("^I verify \"([^\"]*)\" payment options$")
    public void iVerifyPaymentOptions(String option) throws Throwable {
        WebElement otherOption = getDriver().findElement(By.xpath("//span[contains(text(),'" + option + "')]"));
        assertThat(otherOption.isDisplayed());
        otherOption.click();

    }

    @And ("^I verify \"([^\"]*)\" appears$")
    public void iVerifyAppears(String arg0) throws Throwable {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'paypal.png')]")));
    }


    @And ("^I submit shipment form for review and verify new page opens$")
    public void iSubmitShipmentFormForReviewAndVerifyNewPageOpens() {
        String oldurl = getDriver().getCurrentUrl();
        WebElement footer = getDriver().findElement(By.xpath("//span[@id='ups-footer_custServe2']"));
        new Actions(getDriver()).moveToElement(footer).perform();

        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']  ")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldurl)));
    }

    @Then ("^I verify that \"([^\"]*)\" section contains \"([^\"]*)\"$")
    public void iVerifyThatSectionContains(String sectionName, String expectedText) throws Throwable {
        WebElement actualSection = getDriver().findElement(By.xpath("//span[contains(text(), '" + sectionName + "')][@class='h4']/../.."));
        assertThat(actualSection.getText().contains(expectedText));
    }

    @Given ("^I go to ups shipping page$")
    public void iGoToUpsShippingPage() {
        getDriver().get("https://www.ups.com/ship/guided/origin");
    }


    @When ("^I fill out ups required fileds$")
    public void iFillOutUpsRequiredFileds() throws Throwable {
        UpsOrigin origin = new UpsOrigin();
        origin.selectCountry("24: Object");
        origin.fillName(getData("name"));
        origin.fillAddress(getData("address"));
        origin.fillCity(getData("city"));
        origin.fillZip(getData("zip"));
        origin.selectState("California");
        origin.fillEmail(getData("email"));
        origin.fillPhone(getData("phone"));


    }

    @And ("^I submit ups form$")
    public void iSubmitUpsForm() throws Throwable {
        new UpsOrigin().clickContinue();
        Thread.sleep(5000);
    }

    @Then ("^I verify ups origin fields displayed$")
    public void iVerifyUpsOriginFieldsDisplayed() throws Throwable {
        UpsDestination destination = new UpsDestination();
        assertThat(destination.getOriginInfo().contains(getData("name")));
        assertThat(destination.getOriginInfo().contains(getData("address")));
        assertThat(destination.getOriginInfo().contains(getData("city")));
        assertThat(destination.getOriginInfo().contains(getData("zip")));
        assertThat(destination.getOriginInfo().contains(getData("email")));
        assertThat(destination.getOriginInfo().contains(getData("phone")));
        assertThat(destination.getOriginInfo().contains("US"));
        assertThat(destination.getOriginInfo().contains("California"));
        Thread.sleep(5000);

    }

}