package definitions;



import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static support.TestContext.getDriver;
import static support.TestContext.getData;



import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class UspsStepDefs {
    @Given("^I go to \"([^\"]*)\"  page$")
    public void iGoToPage(String url) throws Throwable {
        if (url.equals("usps")) {
        getDriver().get("http://www.usps.com/");
        } else if
        (url.equals("google")) {
        getDriver().get("http://www.google.com/");
        } else if
        (url.equals("converter")) {
        getDriver().get("https://www.unitconverters.net/");
        }else if (url.equals("ups")){
        getDriver().get("https://www.ups.com/us/en/Home.page");
        }else if
        (url.equals("calculator")){
        getDriver().get("https://www.calculator.net");
        }
    }

    @When("^I go to Lookup ZIP page by address$")
    public void iGoToLookupZipPageByAddress() throws Throwable {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[@class='button--link'][contains(text(),'Look Up a ZIP Code')]")).click();

        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();
    }

    @And("^I fill out \"([^\"]*)\" street \"([^\"]*)\" city \"([^\"]*)\" state$")
    public void iFillOutStreetCityState(String street, String city, String state) throws Throwable {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath(" //input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='CA']")).click();

        //Select states = new Select(TestContext.getDriver().findElement(By.xpath("//select[@id='tState']")));
        //states.selectByVisibleText(state);
        //states.selectByIndex(6);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        Thread.sleep(5000);


    }

    @Then("^I validate that \"([^\"]*)\" exists in result$")
    public void iValidateThatExistsInResult(String zip) throws Throwable {
        String res = getDriver().findElement(By.xpath("//div[@class='col-md-12 col-sm-12 col-xs-12 result-address-wrapper']")).getText();
        if (res.contains(zip)) {
            System.out.println("Zip found: " + zip);
        } else {
            System.out.println("Zip not found. Please try again");
            assert res.contains(zip);
        }


    }

    @When("^I go to Calculate Price page$")
    public void iGoToCalculatePricePage() throws Throwable {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[@class='button--link'][contains(text(),'Calculate a Price')]")).click();
        Thread.sleep(5000);


    }

    @When("^I select \"([^\"]*)\" with \"([^\"]*)\" shape and define \"([^\"]*)\" quantity\"$")
    public void iSelectWithShapeAndDefineQuantity(String country, String shape, String num) throws Throwable {
        getDriver().findElement(By.xpath("//select[@id='CountryID']")).click();
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option[contains(text(),'" + country + "')]")).click();

//        Select countries = new Select(TestContext.getDriver().findElement(By.xpath("//select[@id='CountryID']")));
//        countries.selectByValue("10143");

        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(num);
        getDriver().findElement(By.xpath(" //input[@class='btn btn-pcalc btn-default']")).click();


    }

    @Then("^I calculate the price and validate cost is \"([^\"]*)\"$")
    public void iGoToCalculateThePriceAndValidateCostIs(String cost) throws Throwable {
        String resCost = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        if (resCost.contains(cost)) {
            System.out.println("Postage cost is: " + resCost);
        }
        assert resCost.equals(cost);

    }


    @When("^I navigate to \"([^\"]*)\" menu item$")
    public void iNavigateToMenuItem(String item) throws Throwable {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + item + "')]")).click();
    }

    @And("^I enter \"([^\"]*)\" into store search$")
    public void iEnterIntoStoreSearch(String searchString) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(searchString);
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();

    }

    @Then("^I verify search didn't match any results$")
    public void iVerifySearchDidnTMatchAnyResults() {
        String res = getDriver().findElement(By.xpath("//div[@class='page-wrapper']//p[1]")).getText();
        assert res.contains("did not match");

    }


    @When("^I go to \"([^\"]*)\" tab$")
    public void iGoToTab(String arg0) throws Throwable {
       getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'Temperature')]")).click();
    }

    @And("^I should see page title from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iShouldSeePageTitleFromTo(String arg0, String arg1) throws Throwable {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'Fahrenheit')]")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'Celsius')]")).click();
    }

    @Then("^I enter from \"([^\"]*)\" and verify to is \"([^\"]*)\"$")
    public void iEnterFromAndVerifyToIs(String fromUnit, String toUnit) throws Throwable {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(fromUnit);
        String resConversion = getDriver().findElement(By.xpath("//div[@id='calResults']")).getText();
        Thread.sleep(5000);

        assert resConversion.equals(toUnit);
        if (resConversion.contains(toUnit)) {
            System.out.println("CORRECT :" + resConversion);
        }

    }

    @When("^I go to Lookup ZIP page by address with mouseover$")
    public void iGoToLookupZIPPageByAddressWithMouseover() throws Throwable {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        actions.moveToElement(element).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(text(),'Look Up a ZIP Code')]")).click();

        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();

    }

    @When("^I go to Stamps and Supplies page$")
    public void iGoToStampsAndSuppliesPage() throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        actions.moveToElement(element).perform();
        getDriver().findElement(By.xpath("//a[contains(text(),'Stamps & Supplies')]")).click();
        Thread.sleep(3000);
    }

    @And("^I open Stamps$")
    public void iOpenStamps() {
        getDriver().findElement(By.xpath("//div[@class='store-navigation-category']//span[contains(text(),'Stamps')]")).click();
    }

    @And("^I choose category Priority Mail$")
    public void iChooseCategoryPriorityMail() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//label[ contains(text(), 'Priority Mail')][not(contains(text(),'Express'))]")).click();
    }

    @Then("^I verify (\\d+) item found in result$")
    public void iVerifyItemFoundInResult(int expectedCount){
        String  actualCount= getDriver().findElement(By.xpath("//*[@class='results-numerical']")).getText();
        System.out.println(actualCount);
        int actCount = getDriver().findElements(By.xpath("//*[@class='result-page-image-holder']")).size();
        assert actCount == expectedCount;



    }

    @When("^I unselect Stamps checkbox$")
    public void iUnselectStampsCheckbox() {
        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Category-Stamps']")).click();

    }

    @And("^I select size \"([^\"]*)\"$")
    public void iSelectSize(String size) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + size + "')]")).click();

    }

    @And("^I click color \"([^\"]*)\"$")
    public void iClickColor(String color) throws Throwable {
       getDriver().findElement(By.xpath("//div[contains(@onclick, '" + color + "')]")).click();

    }

    @Then("^I verify “Vintage U\\.S\\. Postage T-Shirt” text$")
    public void iVerifyVintageUSPostageTShirtText()throws Throwable {
        String expProdDesc ="Vintage U.S. Postage T-Shirt";
        String actProdDesc = getDriver().findElement(By.xpath("//div[@class='results-product-desc']")).getText();
        assert actProdDesc.equals(expProdDesc);
        System.out.println(actProdDesc);

    }

    @Then("^I verify \"([^\"]*)\" color and  \"([^\"]*)\" size filters$")
    public void iVerifyColorAndSizeFilters(String color, String size) throws Throwable {
        String resFilter = getDriver().findElement(By.xpath("//div[@class='breadcrumb-cartridge']")).getText();
        System.out.println();
        System.out.println(resFilter);
        assert resFilter.contains(color);
        assert resFilter.contains(size);


        String colorElement = getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'Orange')]")).getText();
        assert colorElement.contains(color);

        String colorSize = getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+ size +"')]")).getText();
        assert colorElement.contains(size);

    }

    @And("^I initiate \"([^\"]*)\" search$")
    public void iInitiateSearch(String searchItem) throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        actions.moveToElement(search).perform();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'"+ searchItem.toUpperCase() + "')]")).click();

    }

    @And("^I go to Post Office Hours results$")
    public void iGoToPostOfficeHoursResults() throws Throwable{
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//span[contains(text(),'Passport Application & Passport Renewal | USPS')]")).click();
        getDriver().findElement(By.xpath("//a[@class='button--primary'][contains(text(),'Find a Post Office')]")).click();
    }

    @And("^I select \"([^\"]*)\" location \"([^\"]*)\" zip code within \"([^\"]*)\"$")
    public void iSelectLocationZipCodeWithin(String service, String zip, String area) throws Throwable {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       getDriver().findElement(By.xpath("//div[@id='locationTypeList']")).click();
       getDriver().findElement(By.xpath("//div[@id='locationTypeList']//a[text()='Collection Boxes')]")).click();

       getDriver().findElement(By.xpath("//div[@id='locationTypeList']//a[text()='" + service + "')]")).click();
        getDriver().findElement(By.xpath("//input[@id='tCityStateZip']")).sendKeys("94568");

        getDriver().manage().window().maximize();


        getDriver().findElement(By.xpath("//div[@id='sWithinWrapper']")).click();
        getDriver().findElement(By.xpath("//*[@id='sWithin']//option[@value='5']")).click();


    }

    @And("^I initiate search$")
    public void iInitiateSearch() throws Throwable{
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//input[@id='bSearch']")).click();
    }

    @Then("^I verify \"([^\"]*)\" search results$")
    public void iVerifySearchResults(String cityName) throws Throwable {

        String resCity = getDriver().findElement(By.xpath("//span[@id='" + cityName.toUpperCase() + "']")).getText();
        System.out.println(resCity);
    }


    @Given("^I go to usps page object$")
    public void iGoToUspsPageObject() throws Throwable{
        new UspsHeader().open();

    }

    @When("^I go to Lookup ZIP page by address with page object$")
    public void iGoToLookupZIPPageByAddressWithPageObject() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.mouseoverMailAndShip();
        usps.clickLookUpByZip();
        LookUpZip lookUpZip= new LookUpZip();
        lookUpZip.clickFindByAddress();
        ZipCodeByAddress zipCodeByAddress =new ZipCodeByAddress();
        zipCodeByAddress. fillByAddress("4970 El Camino Real");
        zipCodeByAddress. fillByCity("LosAltos");
        zipCodeByAddress.selectState("CA");
        zipCodeByAddress.findByAddress();

    }

    @Then("^I verify ZIP by address with page object$")
    public void iVerifyZIPByAddressWithPageObject() throws Throwable {
        ZipCodeVerify zipCodeVerify = new ZipCodeVerify();
        assertThat(zipCodeVerify.getZipResult().contains("94022"));
    }

    @When("^I go to Calculate Price page object$")
    public void iGoToCalculatePricePageObject() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.mouseoverMailAndShip();
        usps.clickCalcPrice();


    }

    @And ("^I select \"([^\"]*)\" with \"([^\"]*)\" shape$")
    public void iSelectWithShape(String selectText, String shape) throws Throwable {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.selectDestCountry(selectText);
        priceCalculator.chooseShape(shape);



    }

    @And ("^I define \"([^\"]*)\" quantity page object$")
    public void iDefineQuantityPageObject(String number) throws Throwable {
       PostcardCalculator postcardCalculator = new PostcardCalculator();
       postcardCalculator.fillQuantity("2");
       postcardCalculator.clickCalculate();
       Thread.sleep(5000);
    }

    @Then ("^I calculate the price and validate cost is \"([^\"]*)\" page object$")
    public void iCalculateThePriceAndValidateCostIsPageObject(String cost) throws Throwable {
       PostcardCalculator postcardCalculator = new PostcardCalculator();
       assertThat(postcardCalculator.totalResult().equals(cost));
    }

    @When ("^I navigate to \"([^\"]*)\" menu item with page object$")
    public void iNavigateToMenuItemWithPageObject(String menuItem) throws Throwable {
        UspsHeader uspsHeader = new UspsHeader();
        uspsHeader.clickPostalStore();

    }

    @And ("^I enter \"([^\"]*)\" into store search with page object$")
    public void iEnterIntoStoreSearchWithPageObject(String text) throws Throwable {
        PostalStore postalStore = new PostalStore();
        postalStore.fillPostalSearch("12345");
        postalStore.clickSearchButton();

    }

    @Then ("^I verify that search did not match any results$")
    public void iVerifyThatSearchDidNotMatchAnyResults()throws Throwable {
        PostalStore postalStore = new PostalStore();
        assertThat(postalStore.getSearchResults().contains("did not match"));

    }

    @When ("^I go to Stamps and Supplies page with page object$")
    public void iGoToStampsAndSuppliesPageWithPageObject()throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.mouseoverMailAndShip();
        usps.clickStampsAndSupplies();
        usps.clickStamps();
        Thread.sleep(5000);
    }

    @And ("^I choose category \"([^\"]*)\" with page object$")
    public void iChooseCategoryWithPageObject(String text) throws Throwable {
        UspsHeader usps =new UspsHeader();
        usps.clickPriorityMail();
        Thread.sleep(5000);



    }
}



