package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class UpsDestination extends Page{
    public UpsDestination(){
        setUrl("https://www.ups.com/ship/guided/destination");
    }

    @FindBy(xpath = "//agent-summary[@prefix='origin']")
    private WebElement originInfo;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryContactName']")
    private WebElement origBoxContent;

    public String getOriginInfo(){
       waitForVisible(origBoxContent);
        return originInfo.getText();
    }



}
