package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AmazonLanding extends Page {
    public AmazonLanding(){
        setUrl("https://www.amazon.com/");
    }



    @FindBy(xpath = "//select[@class='nav-search-dropdown searchSelect']")
    private WebElement category;


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement search;

    @FindBy(xpath = "//*//input[@class='nav-input'][@value='Go']")
    private WebElement btnGo;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base'][contains(text(),'Silver')]")
    private WebElement metalSilver;

    @FindBy(xpath = "//span[@class='a-dropdown-label']")
    private WebElement btnFilter;

    @FindBy(xpath = "//a[@id='s-result-sort-select_1']")
    private WebElement optionLowHigh;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private WebElement searchItem;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> listOfElements;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> listOfNames;


    public void getItemName(){
        System.out.println("Number of elements: " + listOfNames.size());
//        for (int i=0; i<listOfNames.size(); i++){
//            if (listOfNames.get(i).getText().contains("Good"));{
//                System.out.println(listOfNames.get(i).getText());

                for (int i=0; i<listOfNames.size(); i++) {
                    //System.out.println(listOfNames.get(i));
                    if (listOfNames.get(i).getText().contains("Good")){
                        System.out.println(listOfNames.get(i).getText());
                    }
                }
                System.out.println();
    }

    public void getSearchItem(){
        System.out.println("Number of elements: " +listOfElements.size());

        for (int i=0; i<listOfElements.size();i++) {
            if (Integer.parseInt(listOfElements.get(i).getText()) <= 40) {
                System.out.println("Search item price:" + Integer.parseInt(listOfElements.get(i).getText()));
            }
        }
    }

    public void clickOptionLowHigh(){
        click(optionLowHigh);
    }

    public void clickFilter(){
        click(btnFilter);
    }


    public void selectCategory(String categ){
        new Select(category).selectByVisibleText(categ);
    }

    public void clickCategory(){
       click(category);
    }


    public void setSearch(String item){
        sendKeys(search, item);
    }

    public void clickGo(){
        click(btnGo);
    }

    public void clickMetalSilver(){
        click(metalSilver);
    }


}
