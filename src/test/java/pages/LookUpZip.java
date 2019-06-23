package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookUpZip extends UspsHeader{

    public LookUpZip() {

    }

        @FindBy(xpath = "//a[contains(@href,'byaddress')][contains(@class,'code-address')]")
        private WebElement byAddress;

         public void clickFindByAddress(){
             click(byAddress);
        }
}
