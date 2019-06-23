package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.tr.Ama;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AmazonLanding;
import java.util.ArrayList;
import java.util.List;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class AmazonStepDefs {

    @Given ("^I open Amazon page$")
    public void iOpenAmazonPage() {
        new AmazonLanding().open();
    }

    @When ("^I initiate search for \"([^\"]*)\" in \"([^\"]*)\" category$")
    public void iInitiateSearchForInCategory(String arg0, String arg1) throws Throwable {
        AmazonLanding amazon = new AmazonLanding();
        getDriver().findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']")).click();
       // amazon.clickCategory();

       // amazon.selectCategory("Collectibles & Fine Art ");
        getDriver().findElement(By.xpath("//option[contains(text(),'Collectibles & Fine Art')]")).click();
        amazon.setSearch("Morgan Dollar");
        amazon.clickGo();

    }


    @And ("^I set filter Collectible Coin Metal as \"([^\"]*)\"$")
    public void iSetFilterCollectibleCoinMetalAs(String arg) throws Throwable {
        new AmazonLanding().clickMetalSilver();

    }

    @And ("^I set sort by \"([^\"]*)\"$")
    public void iSetSortBy(String arg0) throws Throwable {
        AmazonLanding amazon = new AmazonLanding();
        amazon.clickFilter();
        amazon.clickOptionLowHigh();
        Thread.sleep(5000);
    }




    @Then ("^I verify results page$")
    public void iVerifyResultsPage() throws Throwable{

    AmazonLanding amazon = new AmazonLanding();
    amazon.getSearchItem();
    }

    @Then ("^I verify search results$")
    public void iVerifySearchResults() {
        new AmazonLanding().getItemName();
    }
}
