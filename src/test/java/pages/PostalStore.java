package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostalStore extends UspsHeader{

    @FindBy(xpath = "//input[@id='store-search']")
    private WebElement postalSearch;

    @FindBy(xpath = "//input[@id='store-search-btn']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@id='store-search-btn']")
    private WebElement btnSearch;

    @FindBy(xpath = "//strong[contains(text(),'12345')]/..")
    private WebElement searchResult;

    public void fillPostalSearch(String text){
        sendKeys(postalSearch,text);
    }

    public void clickSearchButton(){
        click(btnSearch);
    }

    public String getSearchResults(){
        return searchResult.getText();
    }


}
